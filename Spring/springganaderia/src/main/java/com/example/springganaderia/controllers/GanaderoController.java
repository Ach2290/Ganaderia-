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

    @GetMapping("/byId/{id}")
    public Ganadero getById(@PathVariable Integer id) { return ganaderoService.getById(id);}

    @PostMapping("/login/{correo}")
    public  List<Ganadero> login(@PathVariable String correo) { return ganaderoService.logIn(correo);}

    @PostMapping("/loginNombre/{nombre}")
    public  String loginNombre(@PathVariable String nombre) {
        System.err.println(nombre);
        return "NOMBRE DE USUARIO YA REGISTRADO";
    }

    @PostMapping("/registro")
    public Ganadero registro(@RequestBody Ganadero ganadero) {
        System.err.println(ganadero);
        return ganaderoService.registro(ganadero);}
}
