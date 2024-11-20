package com.veterinaria.veterinaria.DTOS;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AdoptanteRequest {

    private int id;
    private String nombre;
    private String apellido;
    private int dni;
    private long telefono;
    private String email;


}
