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
        EstudianteEntity estudiante = estudianteRepository.findById(id) // Se conserva el Id del estudiante
                .orElseThrow(() -> new ResolutionException("Ingreso un ID a actualizar no existente " + id));

        EstudianteEntity ActuEstu = EstudianteEntity.builder()  // Variable que guarda los datos a actualizar
                .id(estudiante.getId()) // Se debe poner el ID del estudiante ya creado para que tome el id actual, cuando no se pone se crea un clon al llamar el Put
                .nombre(GuardaNuevoEstudiante.getNombre())
                .apellido(GuardaNuevoEstudiante.getApellido())
                .edad(GuardaNuevoEstudiante.getEdad())
                .build();

        estudianteRepository.save(ActuEstu);
        log.info("Se actualizo el id: " + id);
        return EstudianteMapper.INSTANCE.mapToDomain(ActuEstu);

    }

}
