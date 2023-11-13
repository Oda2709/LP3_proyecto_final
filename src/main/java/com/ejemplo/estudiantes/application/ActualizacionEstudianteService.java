package com.ejemplo.estudiantes.application;

import com.ejemplo.estudiantes.application.mapper.EstudianteMapper;
import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.infrastructure.repository.EstudianteRepository;
import com.ejemplo.estudiantes.infrastructure.repository.model.EstudianteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;

@Service
@RequiredArgsConstructor
public class ActualizacionEstudianteService {

    private final EstudianteRepository estudianteRepository;
    public Estudiante actualizarEstudiante(Long id, Estudiante newestudiante){
        EstudianteEntity actualizarEstudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new ResolutionException("No existe el ID a actualizar:" + id));

        EstudianteEntity Act = EstudianteEntity.builder()
                .nombre(newestudiante.getNombre())
                .apellido(newestudiante.getApellido())
                .edad(newestudiante.getEdad())
                .build();

        estudianteRepository.save(Act);
        return EstudianteMapper.INSTANCE.mapToDomain(Act);
    }

}
