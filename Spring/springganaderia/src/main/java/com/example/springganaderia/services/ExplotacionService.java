package com.example.springganaderia.services;

import com.example.springganaderia.models.Explotacion;
import com.example.springganaderia.models.Ganadero;
import com.example.springganaderia.repositories.ExplotacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExplotacionService {

    @Autowired
    private ExplotacionRepository explotacionRepository;

    public List<Explotacion> getAllExplotaciones() { return explotacionRepository.findAll();}

    public List<Explotacion> getExplotacionesByIdGanadero(Integer id) { return explotacionRepository.obtenerExplotacionesPorIdGanadero(id);}
}
