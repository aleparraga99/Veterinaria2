package com.veterinaria.veterinaria.Controller;

import com.veterinaria.veterinaria.DTOS.AdoptanteRequest;
import com.veterinaria.veterinaria.DTOS.AdoptanteResponses;
import com.veterinaria.veterinaria.Entity.Adoptante;
import com.veterinaria.veterinaria.Entity.SolicitudDeAdopcion;
import com.veterinaria.veterinaria.Mappers.AdoptanteMapper;
import com.veterinaria.veterinaria.Services.AdoptanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.veterinaria.veterinaria.Entity.Mascota;
import com.veterinaria.veterinaria.Services.MascotaService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.*;


@RestController
@RequestMapping("/api/adoptantes")

class AdoptanteController {

    @Autowired
    private Adoptante adoptante;

    @Autowired
    private Mascota mascota;

    @Autowired
    private AdoptanteService adoptanteService;

    @Autowired
    private AdoptanteMapper adoptanteMapper;

    @Autowired
    private MascotaService mascotaService;

    @GetMapping
    public List<Adoptante> getAlladoptantes() {
        List<Adoptante> listNull = new ArrayList<Adoptante>();
        return listNull;//este metodo proviene de exteneder el JPA repository
    }


    @PostMapping("/create")
    public ResponseEntity<AdoptanteResponses> crearAdoptante(@RequestBody AdoptanteRequest adoptanteRequest) {
        Adoptante adoptante = AdoptanteMapper.toEntity(adoptanteRequest); // Convertir DTO a entidad
        Adoptante savedAdoptante = adoptanteService.save(adoptante); // Guardar la mascota
        AdoptanteResponses response = adoptanteMapper.toResponse(savedAdoptante); // Convertir entidad a DTO
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdoptanteResponses> obtenerAdoptantePorId(@PathVariable Long id) {
        Adoptante adoptante = adoptanteService.findById(id)
                .orElseThrow(() -> new RuntimeException("Adoptante no encontrado"));
        AdoptanteResponses adoptanteObtenido = adoptanteMapper.toResponse(adoptante);
        return ResponseEntity.ok(adoptanteObtenido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAdoptante(@PathVariable Long id) {
        adoptanteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/{idUser}/mascota/{idMascota}/solicitar")

    // Metodo para generar una solicitud

    public void hacerSolicitud(@PathVariable Long idUser, @PathVariable Long idMascota) {
        Optional<Adoptante> adoptanteBuscado = adoptanteService.findById(idUser); //traigo los datos del adoptante
        if (adoptanteBuscado.isPresent()) {
            Adoptante adoptante = adoptanteBuscado.get();
            String adoptanteNombre = adoptante.getNombre();
            String adoptanteApellido = adoptante.getApellido();
            String adoptanteDni = adoptante.getDni();
            String adoptanteTelefono = adoptante.getTelefono();
            String adoptanteEmail = adoptante.getEmail();
        } else {
            System.out.println("No se encontró un adoptante con ID: " + idUser);
        }
        Optional<Mascota> mascotaBuscada = mascotaService.findById(Math.toIntExact(idMascota)); // traigo los datos de la mascota
        // Este if-else evalua el estado de la mascota
        if (mascotaBuscada.isPresent()) {
            Mascota mascota = mascotaBuscada.get();
            String nombre = mascota.getNombre();
            String especie = mascota.getEspecie();
            boolean estado = mascota.getEstado();

            if (estado) {
                System.out.println("No es posible realizar la solicitud, el animal ya se enciuentra adoptado");
            }
            // En caso de que no este adoptado, se crea la solicitud (se instancia un objeto de la clase SolicitudDeAdopcion)
            else {
                mascota.setEstado(true);
                System.out.println("La solicitud ha sido enviada");
                Date fecha = java.sql.Date.valueOf(LocalDate.now());
                SolicitudDeAdopcion nuevaSolicitud = new SolicitudDeAdopcion(adoptante, mascota,fecha);
            }
        }
    }
}

