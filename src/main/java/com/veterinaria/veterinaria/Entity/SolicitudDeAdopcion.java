package com.veterinaria.veterinaria.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class SolicitudDeAdopcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fecha", length = 50, nullable = false)
    private Date fecha;

    @Column(name = "estado", length = 100, nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "mascota_id", referencedColumnName = "id", nullable = false)
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "adoptante_id", referencedColumnName = "id", nullable = false)
    private Adoptante adoptante;

}
