package com.example.springganaderia.controllers;

import com.example.springganaderia.models.Ganadero;
import com.example.springganaderia.services.GanaderoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ganadero")
public class GanaderoController {

    @Autowired
    private GanaderoService ganaderoService;

    @GetMapping("/all")
    public List<Ganadero> getAllGanaderos() { return ganaderoService.getAllGanaderos();}

    @PostMapping("/login/{correo}")
    public  List<Ganadero> login(@PathVariable String correo) { return ganaderoService.logIn(correo);}
}
