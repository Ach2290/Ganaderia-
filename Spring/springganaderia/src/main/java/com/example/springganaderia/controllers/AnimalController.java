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

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalServices animalServices;

    @GetMapping("/all")
    public List<Animal> getAllAnimales() { return animalServices.getAllAnimales();}

    @GetMapping("/by_id_explotacion/{id_explotacion}")
    public List<Animal> getAnimalesByIdExplotacion(@PathVariable Integer id_explotacion) { return animalServices.getAnimalesByIdExplotacion(id_explotacion);}

    @GetMapping("/by_id/{idexplotacion}/{idanimal}")
    public List<Animal> getAnimalesById(@PathVariable Integer idexplotacion, @PathVariable Integer idanimal) { return animalServices.getAnimalesById(idexplotacion, idanimal);}

}
