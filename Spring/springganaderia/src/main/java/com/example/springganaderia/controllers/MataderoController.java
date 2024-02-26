package com.example.springganaderia.controllers;

import com.example.springganaderia.models.Matadero;
import com.example.springganaderia.services.MataderoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/matadero")
@RestController
public class MataderoController {

    @Autowired
    MataderoService mataderoService;

    @GetMapping("byId/{id}")
    public Matadero byId(@PathVariable Integer id){return mataderoService.byId(id);}
}
