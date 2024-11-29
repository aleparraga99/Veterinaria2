package com.veterinaria.veterinaria.Services;

import com.veterinaria.veterinaria.Entity.Adoptante;
import com.veterinaria.veterinaria.Repository.AdoptanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.veterinaria.veterinaria.Entity.Mascota;

import java.util.List;
import java.util.Optional;


@Service
public class AdoptanteService {

    @Autowired
    private AdoptanteRepository adoptanteRepository;

    public List<Adoptante> findAll() {
        return adoptanteRepository.findAll();
    }

    public Optional<Adoptante> findById(Long id) {
        return adoptanteRepository.findById(id);
    }

    public Adoptante save(Adoptante adoptante) {
        return adoptanteRepository.save(adoptante);
    }

    public void deleteById(Long id) {
        adoptanteRepository.deleteById(id);
    }
}

