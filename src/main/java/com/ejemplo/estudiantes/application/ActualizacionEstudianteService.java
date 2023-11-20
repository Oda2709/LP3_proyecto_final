package com.ejemplo.estudiantes.application;

import com.ejemplo.estudiantes.application.mapper.EstudianteMapper;
import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.exception.ResourceNotFoundException;
import com.ejemplo.estudiantes.infrastructure.repository.EstudianteRepository;
import com.ejemplo.estudiantes.infrastructure.repository.model.EstudianteEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ActualizacionEstudianteService {

    private final EstudianteRepository estudianteRepository;

    public Estudiante actualizarEstudiante(Long id, Estudiante guardaNuevoEstudiante) {
        estudianteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("El Id " + id + " no existente para ser actualizado")));

        EstudianteEntity actuEstu = EstudianteMapper.INSTANCE.mapToEntity(guardaNuevoEstudiante);
        actuEstu.setId(id);

        EstudianteEntity guardarNu = estudianteRepository.save(actuEstu);
        log.info("Se actualizo el id :  " + id);

        return EstudianteMapper.INSTANCE.mapToDomain(guardarNu);

    }

}
