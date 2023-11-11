package com.ejemplo.estudiantes.application;

import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.infrastructure.repository.EstudianteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VerEstudianteService {

    private final EstudianteRepository estudianteRepository;

    public List<Estudiante> obtenerEstudiantes() {
        return estudianteRepository.findAll().stream()
                .map(estudianteEntity ->
                    Estudiante.builder()
                            .id(estudianteEntity.getId())
                            .edad(estudianteEntity.getEdad())
                            .nombre(estudianteEntity.getNombre())
                            .apellido(estudianteEntity.getApellido())
                            .build())
                .collect(Collectors.toList());
    }
    public Estudiante obtenerEstudiante(Long EstudiantePorId) {
        return estudianteRepository.findById(EstudiantePorId)
                .map(estudianteEntity ->
                        Estudiante.builder()
                                .id(estudianteEntity.getId())
                                .edad(estudianteEntity.getEdad())
                                .nombre(estudianteEntity.getNombre())
                                .apellido(estudianteEntity.getApellido())
                                .build())
                .orElseThrow(() -> new RuntimeException("Usuario no existe"));
    }
}
