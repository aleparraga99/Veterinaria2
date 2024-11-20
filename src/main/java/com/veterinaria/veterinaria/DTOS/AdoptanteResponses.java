package com.veterinaria.veterinaria.DTOS;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AdoptanteResponses {

    private int id;
    private String nombre;
    private String apellido;
    private int dni;
    private long telefono;
    private String email;

    public void setTelefono(String telefono) {

    }
}
