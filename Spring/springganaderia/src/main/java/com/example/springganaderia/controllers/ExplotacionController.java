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

@RestController
@RequestMapping("/explotacion")
public class ExplotacionController {

    @Autowired
    private ExplotacionService explotacionService;

    @GetMapping("/all")
    public List<Explotacion> getAllExplotaciones() { return explotacionService.getAllExplotaciones();}

    @GetMapping("/by_id/{id}")
    public Explotacion getExplotacionById(@PathVariable Integer id){ return explotacionService.getExplotacionById(id);}

    @GetMapping("/by_name/{name}")
    public List<Explotacion> getExplotacionByName(@PathVariable String name) {

        List<Explotacion> explotaciones = explotacionService.getAllExplotaciones();
        List<Explotacion> nameFilter = new ArrayList<>();

        for (Explotacion explotacion : explotaciones){
            if (explotacion.getNombre().equals(name)){
                nameFilter.add(explotacion);
            }
        }
        return nameFilter;

    }

    @GetMapping("/by_id_ganadero/{id}")
    public List<Explotacion> getExplotacionesByIdGanadero(@PathVariable Integer id) {

        return explotacionService.getExplotacionesByIdGanadero(id);


    }

}


