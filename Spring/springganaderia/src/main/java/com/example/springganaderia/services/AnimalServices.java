package com.example.springganaderia.services;

import com.example.springganaderia.models.Animal;
import com.example.springganaderia.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Encargado de gestionar la lógica de negocio relacionada con la entidad 'Animal'.
@Service //indica que esta clase es un servicio y se encargará de la lógica de negocio
public class AnimalServices {

    @Autowired     // Metemos automáticamente el repositorio para acceder a los datos de la entidad 'Animal'.
    private AnimalRepository animalRepository;

    // Este método devuelve una lista de todos los animales.
    public List<Animal> getAllAnimales() { return animalRepository.findAll();}

    // Este método devuelve una lista de animales filtrados por el ID de explotación.
    public List<Animal> getAnimalesByIdExplotacion(Integer id_explotacion){ return animalRepository.obtenerAnimalesPorIdExplotacion(id_explotacion);}

    // Este método devuelve una lista de animales filtrados por el ID de explotación y el ID de animal.
    public List<Animal> getAnimalesById(Integer idexplotacion, Integer idanimal){ return animalRepository.obtenerAnimalesPorId(idexplotacion, idanimal);}


}
