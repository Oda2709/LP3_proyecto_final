package com.ejemplo.estudiantes.application;

import com.ejemplo.estudiantes.infrastructure.repository.EstudianteRepository;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.description.type.RecordComponentList;
import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;

@Slf4j
@Service
@RequiredArgsConstructor
public class EliminacionEstudianteService {

    private final EstudianteRepository estudianteRepository;

    public void eliminarEstudiante(Long estudiantePorID) {
        try {
            estudianteRepository.deleteById(estudiantePorID);
            log.info("Se elimino estudiante con el id  " + estudiantePorID); // aparece cuando se elimina el ID solicitado

        } catch (EmptyResultDataAccessException s) {
            throw new ResolutionException("El ID " + estudiantePorID + " no existente para ser eliminado ");
        }


    }
}
