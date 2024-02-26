package com.example.springganaderia.controllers;

import com.example.springganaderia.models.Animal;
import com.example.springganaderia.services.AnimalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
// Controlador para gestionar animales
// Aquí estamos usando la anotación '@RestController', lo que significa que cada método devuelve directamente JSON al cliente.
@RequestMapping("/animal")
@RestController
public class AnimalController {

    // Vamos a usar un servicio para gestionar la lógica relacionada con los animales, y Spring se encarga de inyectar esta dependencia automáticamente.
    @Autowired
    private AnimalServices animalServices;

    // Este método maneja solicitudes para obtener todos los animales y simplemente llama al servicio para hacerlo.
    @GetMapping("/all")
    public List<Animal> getAllAnimales() {
        return animalServices.getAllAnimales();
    }

    // Aquí, gestionamos solicitudes para obtener animales filtrados por el ID de explotación.
    @GetMapping("/by_id_explotacion/{id_explotacion}")
    public List<Animal> getAnimalesByIdExplotacion(@PathVariable Integer id_explotacion) {
        return animalServices.getAnimalesByIdExplotacion(id_explotacion);
    }

    // Este método maneja solicitudes para obtener animales filtrados por el ID de explotación y el ID de animal.
    @GetMapping("/by_id/{id_explotacion}/{id}")
    public List<Animal> getAnimalesById(@PathVariable Integer id_explotacion, @PathVariable Integer id) {
        return animalServices.getAnimalesById(id_explotacion, id);
    }
}
