package com.example.springganaderia.controllers;

import com.example.springganaderia.models.Ganadero;
import com.example.springganaderia.models.Movimiento;
import com.example.springganaderia.services.MovimientoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Utilizamos este  controlador para  gestionar las solicitudes relacionadas con los movimientos

// Utilizamos la anotación '@RestController', indicando que cada método devuelve directamente JSON al cliente.
@RequestMapping("/movimiento")
@RestController
public class MovimientoController {

    // Usamos un servicio para gestionar la lógica relacionada con los movimientos, y Spring se encarga de inyectar esta dependencia automáticamente.
    @Autowired
    MovimientoServices movimientoServices;

    // Este método maneja solicitudes para obtener movimientos filtrados por el ID del ganadero.
    @GetMapping("/by_id_ganadero/{id_ganadero}")
    List<Movimiento> obtenerMovimientoIdGanadero(@PathVariable Integer id_ganadero) {
        return movimientoServices.obtenerMovimientoIdGanadero(id_ganadero);
    }

    @GetMapping("/byId/{id}")
    public Movimiento getById(@PathVariable Integer id) {
        return movimientoServices.getById(id);
    }
}
