package com.example.springganaderia.services;

import com.example.springganaderia.models.Animal;
import com.example.springganaderia.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServices {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> getAllAnimales() { return animalRepository.findAll();}

    public List<Animal> getAnimalesByIdExplotacion(Integer id){ return animalRepository.obtenerAnimalesPorIdExplotacion(id);}

    public List<Animal> getAnimalesById(Integer idexplotacion, Integer idanimal){ return animalRepository.obtenerAnimalesPorId(idexplotacion, idanimal);}


}
