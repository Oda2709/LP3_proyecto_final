package com.ejemplo.estudiantes.application;

import com.ejemplo.estudiantes.application.mapper.EstudianteMapper;
import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.infrastructure.repository.EstudianteRepository;
import com.ejemplo.estudiantes.infrastructure.repository.model.EstudianteEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;

@Slf4j
@Service
@RequiredArgsConstructor
public class ActualizacionEstudianteService {

    private final EstudianteRepository estudianteRepository;

    public Estudiante actualizarEstudiante(Long id, Estudiante GuardaNuevoEstudiante) {
         estudianteRepository.findById(id) // Se conserva el Id del estudiante
                .orElseThrow(() -> new ResolutionException("Ingreso un ID a actualizar no existente " + id));

        EstudianteEntity ActuEstu = EstudianteMapper.INSTANCE.mapToEntity(GuardaNuevoEstudiante);
        ActuEstu.setId(id);

        estudianteRepository.save(ActuEstu);
        log.info("Se actualizo el id: " + id);
        return EstudianteMapper.INSTANCE.mapToDomain(ActuEstu);

    }

}
