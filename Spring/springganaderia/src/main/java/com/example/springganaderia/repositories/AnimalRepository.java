package com.example.springganaderia.repositories;

import com.example.springganaderia.models.Animal;
import com.example.springganaderia.models.Explotacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    @Query("SELECT a FROM Animal a WHERE a.id_explotacion = ?1")
    List<Animal> obtenerAnimalesPorIdExplotacion(Integer explotacionId);
}
