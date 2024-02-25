package com.example.springganaderia.services;

// Este es el servicio encargado de gestionar la lógica de negocio relacionada con la entidad 'Ganadero' en nuestra aplicación Spring.

import com.example.springganaderia.models.Ganadero;
import com.example.springganaderia.repositories.GanaderoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// La anotación '@Service' indica que esta clase es un servicio y se encargará de la lógica de negocio.
@Service
public class GanaderoService {

    // metemos automáticamente el repositorio para acceder a los datos de la entidad 'Ganadero'.
    @Autowired
    private GanaderoRepository ganaderoRepository;

    // Este método devuelve una lista de todos los ganaderos.
    public List<Ganadero> getAllGanaderos() {
        return ganaderoRepository.findAll();
    }

    // Este método devuelve un ganadero específico por su ID.
    public Ganadero getById(Integer id) {
        return ganaderoRepository.findById(id).get();
    }

    // Este método devuelve una lista de ganaderos filtrados por correo electrónico.
    public List<Ganadero> logIn(String ganaderoCorreo) {
        return ganaderoRepository.obtenerGanaderoPorCorreo(ganaderoCorreo);
    }

    // Este método devuelve una lista de ganaderos filtrados por nombre.
    public List<Ganadero> logInNombre(String nombre) {
        return ganaderoRepository.obtenerGanaderoPorNombre(nombre);
    }

    // Este método guarda un nuevo ganadero en la base de datos.
    public Ganadero registro(Ganadero ganadero) {
        return ganaderoRepository.save(ganadero);
    }

    // Este método actualiza la información de un ganadero existente en la base de datos.
    public Ganadero updateGanadero(Ganadero ganadero) {
        return ganaderoRepository.save(ganadero);
    }
}