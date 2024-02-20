package com.example.springganaderia.services;

import com.example.springganaderia.models.Ganadero;
import com.example.springganaderia.repositories.GanaderoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GanaderoService {

    @Autowired
    private GanaderoRepository ganaderoRepository;

    public List<Ganadero> getAllGanaderos() { return ganaderoRepository.findAll();}

    
}
