package com.veterinaria.veterinaria.Services;

import com.veterinaria.veterinaria.Entity.Mascota;
import com.veterinaria.veterinaria.Repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    public List<Mascota> findAll(){

        return mascotaRepository.findAll();
    }

    public Optional<Mascota> findById(Integer id) {

        return mascotaRepository.findById(id);
    }

    public Mascota save(Mascota mascota) {

        return mascotaRepository.save(mascota);
    }

    public void deleteById(Integer id) {

        mascotaRepository.deleteById(id);
    }

    public void testDatabaseConnection() {
        try {
            long count = mascotaRepository.count();
            System.out.println("Número de mascotas en la base de datos: " + count);
        } catch (Exception e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
    
    public boolean traerEstadoMascota(int id){
        return mascotaRepository.findById(id)
                .map(Mascota::getEstado)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));
    }
}
