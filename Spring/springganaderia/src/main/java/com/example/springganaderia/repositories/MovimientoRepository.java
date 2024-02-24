package com.example.springganaderia.repositories;

import com.example.springganaderia.models.Ganadero;
import com.example.springganaderia.models.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {

    @Query("SELECT m FROM Movimiento m WHERE m.id_explotacion IN (SELECT e.id FROM Explotacion e WHERE e.id_ganadero = ?1)")
    List<Movimiento> obtenerMovimientoIdGanadero(Integer id_ganadero);
}
