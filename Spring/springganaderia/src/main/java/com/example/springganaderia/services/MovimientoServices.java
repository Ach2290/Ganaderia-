package com.example.springganaderia.services;

import com.example.springganaderia.models.Movimiento;
import com.example.springganaderia.repositories.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoServices {

    @Autowired
    MovimientoRepository movimientoRepository;

    public List<Movimiento> obtenerMovimientoIdGanadero(Integer id_ganadero) { return movimientoRepository.obtenerMovimientoIdGanadero(id_ganadero);}
}
