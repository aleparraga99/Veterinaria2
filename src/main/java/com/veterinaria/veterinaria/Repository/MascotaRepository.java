package com.veterinaria.veterinaria.Repository;

import com.veterinaria.veterinaria.Entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer> {


    List<Mascota> findByEspecie(String especie);

    List<Mascota> findByEstado(boolean estado);

    @Query("SELECT m.estado FROM Mascota m WHERE m.id = :id")
    String findEstadoById(@Param("id") Long id);

}
