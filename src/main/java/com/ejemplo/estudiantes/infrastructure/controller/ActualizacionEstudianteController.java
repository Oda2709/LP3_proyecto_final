package com.ejemplo.estudiantes.infrastructure.controller;

import com.ejemplo.estudiantes.application.ActualizacionEstudianteService;
import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.infrastructure.repository.model.EstudianteEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("estudiantes")
@RequiredArgsConstructor
public class ActualizacionEstudianteController {

    public final ActualizacionEstudianteService actualizacionEstudianteService;

   @PutMapping("{id}")
    public Estudiante actualizarEstudiante(@PathVariable("id") Long id,@RequestBody Estudiante newestudiante) {
        log.info("Se va a actualizar un estudiante");
        return actualizacionEstudianteService.actualizarEstudiante(id, newestudiante);
    }
}
