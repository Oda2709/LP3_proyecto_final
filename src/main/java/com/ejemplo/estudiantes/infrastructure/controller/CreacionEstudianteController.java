package com.ejemplo.estudiantes.infrastructure.controller;

import com.ejemplo.estudiantes.application.CreacionEstudianteService;
import com.ejemplo.estudiantes.domain.Estudiante;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j //para que muestre los log
@RestController
@RequestMapping("estudiantes")
@RequiredArgsConstructor //solo crea los atributos contructores que se creen como Final
@ResponseBody

public class CreacionEstudianteController {
    private final CreacionEstudianteService creacionEstudianteService;

    @PostMapping
    public Estudiante crearEstudiante(@RequestBody Estudiante estudiante) {
        log.info("Se creo estudiante: " + estudiante); // Muestra en el Log que estudiante se creo
        return creacionEstudianteService.creaEstudiante(estudiante);
    }

}
