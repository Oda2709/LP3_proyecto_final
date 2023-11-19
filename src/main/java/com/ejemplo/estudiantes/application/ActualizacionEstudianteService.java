package com.ejemplo.estudiantes.application;

import com.ejemplo.estudiantes.application.mapper.EstudianteMapper;
import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.exception.ResourceNotFoundException;
import com.ejemplo.estudiantes.infrastructure.repository.EstudianteRepository;
import com.ejemplo.estudiantes.infrastructure.repository.model.EstudianteEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;

@Service
@RequiredArgsConstructor
public class ActualizacionEstudianteService {

    private final EstudianteRepository estudianteRepository;

    public Estudiante actualizarEstudiante(Long id, Estudiante GuardaNuevoEstudiante) {
         estudianteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("El Id " +id+" no existente para ser actualizado")));

        EstudianteEntity ActuEstu = EstudianteMapper.INSTANCE.mapToEntity(GuardaNuevoEstudiante);
        ActuEstu.setId(id);

        return EstudianteMapper.INSTANCE.mapToDomain(ActuEstu);

    }

}
