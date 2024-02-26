package com.example.springganaderia.repositories;

import com.example.springganaderia.models.Animal;
import com.example.springganaderia.models.Explotacion;
import com.example.springganaderia.models.Ganadero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExplotacionRepository extends JpaRepository<Explotacion, Integer> {

    // Consulta personalizada para obtener una lista de explotaciones ganaderas filtradas por el ID del ganadero.
    @Query("SELECT e FROM Explotacion e WHERE e.id_ganadero = ?1")
    List<Explotacion> obtenerExplotacionesPorIdGanadero( Integer ganaderoId);

    @Query("SELECT e FROM Explotacion e WHERE e.id =?1 AND e.id_ganadero = ?2")
    List<Explotacion> barrabusqueda(Integer explotacionNombre, Integer idGanadero);


}
