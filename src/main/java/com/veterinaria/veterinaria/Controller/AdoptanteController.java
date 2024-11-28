package com.veterinaria.veterinaria.Controller;

import com.veterinaria.veterinaria.DTOS.AdoptanteRequest;
import com.veterinaria.veterinaria.DTOS.AdoptanteResponses;
import com.veterinaria.veterinaria.Entity.Adoptante;
import com.veterinaria.veterinaria.Entity.Mascota;
import com.veterinaria.veterinaria.Entity.SolicitudDeAdopcion;
import com.veterinaria.veterinaria.Mappers.AdoptanteMapper;
import com.veterinaria.veterinaria.Services.AdoptanteService;
import com.veterinaria.veterinaria.Services.MascotaService;
import com.veterinaria.veterinaria.Services.SolicitudDeAdopcionService;  // Assuming you have this service for handling adoption requests

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adoptantes")
public class AdoptanteController {

    @Autowired
    private AdoptanteService adoptanteService;

    @Autowired
    private AdoptanteMapper adoptanteMapper;

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private SolicitudDeAdopcionService solicitudDeAdopcionService;  // Service to handle adoption requests

    @GetMapping
    public List<Adoptante> getAlladoptantes() {
        return adoptanteService.findAll(); // Using the service to get all adoptantes
    }

    @PostMapping("/create")
    public ResponseEntity<AdoptanteResponses> crearAdoptante(@RequestBody AdoptanteRequest adoptanteRequest) {
        Adoptante adoptante = adoptanteMapper.toEntity(adoptanteRequest); // Convert DTO to entity
        Adoptante savedAdoptante = adoptanteService.save(adoptante); // Save the adoptante
        AdoptanteResponses response = adoptanteMapper.toResponse(savedAdoptante); // Convert entity to DTO
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
    public ResponseEntity<String> hacerSolicitud(@PathVariable Long idUser, @PathVariable int idMascota) {
        Optional<Adoptante> adoptanteBuscado = adoptanteService.findById(idUser); // Get adoptante details
        if (!adoptanteBuscado.isPresent()) {
            return ResponseEntity.status(404).body("No se encontró un adoptante con ID: " + idUser);
        }
        Adoptante adoptante = adoptanteBuscado.get();

        Optional<Mascota> mascotaBuscada = mascotaService.findById(idMascota); // Get mascota details
        if (!mascotaBuscada.isPresent()) {
            return ResponseEntity.status(404).body("No se encontró una mascota con ID: " + idMascota);
        }
        Mascota mascota = mascotaBuscada.get();

        if (mascota.Estado()) {  // Assuming estado is a boolean indicating if the pet is already adopted
            return ResponseEntity.status(400).body("No es posible realizar la solicitud, el animal ya se encuentra adoptado");
        } else {
            mascota.setEstado(true); // Mark the pet as adopted
            SolicitudDeAdopcion nuevaSolicitud = new SolicitudDeAdopcion(adoptante, mascota, Date.valueOf(LocalDate.now()));
            solicitudDeAdopcionService.save(nuevaSolicitud);  // Save the adoption request
            return ResponseEntity.ok("La solicitud ha sido enviada con éxito");
        }
    }
}
