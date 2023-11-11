package com.ejemplo.estudiantes.infrastructure.controller;

import com.ejemplo.estudiantes.application.CreacionEstudianteService;
import com.ejemplo.estudiantes.domain.Estudiante;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j //para que muestre los log
@RestController
@RequestMapping("estudiantes")
@RequiredArgsConstructor //solo crea los atributos contructores que se creen como Final

public class CreacionEstudianteController {
    private final CreacionEstudianteService creacionEstudianteService;
    @PostMapping
    public Estudiante crearEstudiante(@RequestBody Estudiante estudiante) {
        log.info("Se va a crear un estudiante");
        return creacionEstudianteService.creaEstudiante(estudiante);
    }
}
