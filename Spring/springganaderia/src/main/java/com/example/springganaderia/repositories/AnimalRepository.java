package com.example.springganaderia.repositories;

import com.example.springganaderia.models.Animal;
import com.example.springganaderia.models.Explotacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Integer>{

    // Consulta personalizada para obtener una lista de animales filtrados por el ID de explotación.
    @Query("SELECT a FROM Animal a WHERE a.id_explotacion =?1")
    List<Animal>obtenerAnimalesPorIdExplotacion(Integer id_explotacion);

    // Consulta personalizada para obtener una lista de animales filtrados por el ID de explotación y el ID del animal.
    @Query("SELECT a FROM Animal a WHERE a.id_explotacion =?1 a.id = ?2")
    List<Animal> obtenerAnimalesPorId(Integer explotacionId, Integer id);
}
