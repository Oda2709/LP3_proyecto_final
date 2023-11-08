package com.ejemplo.estudiantes.infrastructure.repository.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "estudiante")
@Data
public class EstudianteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private int edad;
}
