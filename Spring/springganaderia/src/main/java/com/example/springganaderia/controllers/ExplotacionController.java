package com.example.springganaderia.controllers;

import com.example.springganaderia.models.Explotacion;
import com.example.springganaderia.models.Ganadero;
import com.example.springganaderia.services.ExplotacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// gestionamos las solicitudes relacionadas con las explotaciones ganaderas en nuestra aplicación Spring.

// '@RestController', cada método devuelve directamente JSON al cliente.
@RequestMapping("/explotacion")
@RestController
public class ExplotacionController {

    // Vamos a usar un servicio para gestionar la lógica relacionada con las explotaciones ganaderas, y Spring se encarga de inyectar esta dependencia automáticamente.
    @Autowired
    private ExplotacionService explotacionService;

    // Este método maneja solicitudes para obtener todas las explotaciones ganaderas y simplemente llama al servicio para hacerlo.
    @GetMapping("/all")
    public List<Explotacion> getAllExplotaciones() {
        return explotacionService.getAllExplotaciones();
    }

    // Aquí gestionamos solicitudes para obtener una explotación ganadera específica por su ID.
    @GetMapping("/by_id/{id}")
    public Explotacion getExplotacionById(@PathVariable Integer id) {
        return explotacionService.getExplotacionById(id);
    }

    // Este método maneja solicitudes para obtener explotaciones ganaderas filtradas por nombre.
    @GetMapping("/by_name/{name}")
    public List<Explotacion> getExplotacionByName(@PathVariable String name) {
        List<Explotacion> explotaciones = explotacionService.getAllExplotaciones();
        List<Explotacion> nameFilter = new ArrayList<>();

        // Filtramos explotaciones por nombre y las agregamos a la lista 'nameFilter'.
        for (Explotacion explotacion : explotaciones) {
            if (Objects.equals(explotacion.getNombre(), name)) {
                nameFilter.add(explotacion);
            }
        }
        return nameFilter;
    }

    // Este método maneja solicitudes para obtener explotaciones ganaderas filtradas por el ID del ganadero al que pertenecen.
    @GetMapping("/by_id_ganadero/{id}")
    public List<Explotacion> getExplotacionesByIdGanadero(@PathVariable Integer id) {
        return explotacionService.getExplotacionesByIdGanadero(id);
    }
}


