package com.veterinaria.veterinaria.Mappers;

import com.veterinaria.veterinaria.DTOS.MascotaRequest;
import com.veterinaria.veterinaria.DTOS.MascotaResponses;
import com.veterinaria.veterinaria.Entity.Mascota;
import org.springframework.stereotype.Component;


@Component
public class MascotaMapper {

    public MascotaResponses toResponse(Mascota mascota) {

        MascotaResponses response = new MascotaResponses();
        response.setId(mascota.getId());
        response.setNombre(mascota.getNombre());
        response.setEstado(mascota.getEstado());
        response.setEspecie(mascota.getEspecie());
        return response;
    }

    public Mascota toEntity(MascotaRequest request) {

        Mascota mascota;
        mascota = new Mascota();
        mascota.setNombre(request.getNombre());
        mascota.setEstado(request.getEstado());
        mascota.setEspecie(request.getEspecie());
        return mascota;
    }
}

