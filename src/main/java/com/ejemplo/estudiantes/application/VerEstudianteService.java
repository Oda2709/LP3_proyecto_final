package com.ejemplo.estudiantes.application;

import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.infrastructure.repository.VerEstudianteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VerEstudianteService {

    private final VerEstudianteRepository verEstudianteRepository;

    public List<Estudiante> obtenerEstudiantes() {
        return verEstudianteRepository.findAll().stream()
                .map(estudianteEntity ->
                    Estudiante.builder()
                            .id(estudianteEntity.getId())
                            .edad(estudianteEntity.getEdad())
                            .nombre(estudianteEntity.getNombre())
                            .apellido(estudianteEntity.getApellido())
                            .build())
                .collect(Collectors.toList());
    }
}
