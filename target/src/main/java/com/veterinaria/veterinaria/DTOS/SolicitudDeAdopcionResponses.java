package com.veterinaria.veterinaria.DTOS;

import com.veterinaria.veterinaria.Entity.Adoptante;
import com.veterinaria.veterinaria.Entity.Mascota;
import com.veterinaria.veterinaria.Entity.SolicitudDeAdopcion;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class SolicitudDeAdopcionResponses{

    private int id;
    private Date fecha;
    private String estado;
    private Mascota mascota;
    private Adoptante adoptante;
}
