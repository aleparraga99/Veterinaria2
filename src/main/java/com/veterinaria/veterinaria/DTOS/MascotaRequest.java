package com.veterinaria.veterinaria.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MascotaRequest {
    private String nombre;
    private String especie;
    private Boolean estado;

}
