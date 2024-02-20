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

    public Ganadero getById(Integer id) { return ganaderoRepository.findById(id).get();}

    public List<Ganadero> logIn(String ganaderoCorreo) {return  ganaderoRepository.obtenerGanaderoPorCorreo(ganaderoCorreo);}
    public List<Ganadero> logInNombre(String nombre) {return  ganaderoRepository.obtenerGanaderoPorNombre(nombre);}

    public Ganadero registro(Ganadero ganadero){return ganaderoRepository.save(ganadero);}
}
