package com.example.springganaderia.services;

import com.example.springganaderia.models.Matadero;
import com.example.springganaderia.repositories.GanaderoRepository;
import com.example.springganaderia.repositories.MataderoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MataderoService {

    @Autowired
    MataderoRepository mataderoRepository;

    public Matadero byId(Integer id) {return mataderoRepository.findById(id).get();}
}
