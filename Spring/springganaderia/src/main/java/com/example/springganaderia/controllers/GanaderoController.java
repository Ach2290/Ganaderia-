package com.example.springganaderia.controllers;

import com.example.springganaderia.models.Ganadero;
import com.example.springganaderia.services.GanaderoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ganadero")
public class GanaderoController {

    @Autowired
    private GanaderoService ganaderoService;

    @GetMapping("/all")
    public List<Ganadero> getAllGanaderos() { return ganaderoService.getAllGanaderos();}
}
