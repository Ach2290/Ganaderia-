package com.example.springganaderia.controllers;

import com.example.springganaderia.models.Animal;
import com.example.springganaderia.services.AnimalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AnimalController {

    @Autowired
    private AnimalServices animalServices;

    @GetMapping("by_id_explotacion/{id}")
    public List<Animal> getAnimalesByIdExplotacion(Integer id) { return animalServices.getAnimalesByIdExplotacion(id);}
}
