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
    private String dni;
    private String telefono;
    private String email;


}
