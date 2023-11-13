package com.ejemplo.estudiantes.infrastructure.controller;

import com.ejemplo.estudiantes.application.EliminacionEstudianteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("estudiantes")
@RequiredArgsConstructor
public class EliminacionEstudianteController {

    private final EliminacionEstudianteService eliminacionEstudianteService;

    @DeleteMapping("{id}")
    public void  eliminarEstudiante(@PathVariable("id") Long estudiantePorID) {
        log.info("Se eliminara un estudiante");
        eliminacionEstudianteService.eliminarEstudiante(estudiantePorID);

    }

}
