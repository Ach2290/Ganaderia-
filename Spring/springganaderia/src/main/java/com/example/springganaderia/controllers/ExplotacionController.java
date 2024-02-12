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

@RestController
@RequestMapping("/explotacion")
public class ExplotacionController {

    @Autowired
    private ExplotacionService explotacionService;

    @GetMapping("/all")
    public List<Explotacion> getAllExplotaciones() { return explotacionService.getAllExplotaciones();}

    @GetMapping("/by_id_ganadero/{id}")
    public List<Explotacion> getExplotacionesByIdGanadero(@PathVariable Integer id) {

        return explotacionService.getExplotacionesByIdGanadero(id);


    }

}


