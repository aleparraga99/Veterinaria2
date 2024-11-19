package com.veterinaria.veterinaria.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Adoptante {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "apellido", length = 100, nullable = false)
    private String apellido;

    @Column(name = "dni", length = 20, nullable = false)
    private int dni;

    @Column(name = "telefono", length = 20)
    private long telefono;

    @Column(name = "email", length = 150)
    private String email;

    public Adoptante(int id, String nombre, String apellido, int dni, long telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
    }

    public Adoptante() {

    }
}
