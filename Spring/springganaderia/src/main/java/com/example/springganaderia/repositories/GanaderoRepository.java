package com.example.springganaderia.repositories;

import com.example.springganaderia.models.Animal;
import com.example.springganaderia.models.Ganadero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GanaderoRepository extends JpaRepository<Ganadero, Integer> {

    @Query("SELECT a FROM Ganadero a WHERE a.correo = ?1")
    List<Ganadero> obtenerGanaderoPorCorreo(String ganaderoCorreo);

    @Query("SELECT a FROM Ganadero a WHERE a.nombre = ?1")
    List<Ganadero> obtenerGanaderoPorNombre(String ganaderoNombre);
}
