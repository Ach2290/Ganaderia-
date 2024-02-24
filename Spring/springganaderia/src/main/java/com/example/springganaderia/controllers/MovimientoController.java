package com.example.springganaderia.controllers;

import com.example.springganaderia.models.Movimiento;
import com.example.springganaderia.services.MovimientoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movimiento")
public class MovimientoController {

    @Autowired
    MovimientoServices movimientoServices;

    @GetMapping("/by_id_ganadero/{id_ganadero}")
    List<Movimiento> obtenerMovimientoIdGanadero(@PathVariable Integer id_ganadero) {return movimientoServices.obtenerMovimientoIdGanadero(id_ganadero);}
}
