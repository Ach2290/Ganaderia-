package com.example.springganaderia.services;

import com.example.springganaderia.models.Explotacion;
import com.example.springganaderia.models.Ganadero;
import com.example.springganaderia.repositories.ExplotacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// La anotación '@Service' indica que esta clase es un servicio y se encargará de la lógica de negocio.
@Service
public class ExplotacionService {

    // metemos automáticamente el repositorio para acceder a los datos de la entidad 'Explotacion'.
    @Autowired
    private ExplotacionRepository explotacionRepository;

    // Este método devuelve una lista de todas las explotaciones ganaderas.
    public List<Explotacion> getAllExplotaciones() {
        return explotacionRepository.findAll();
    }

    // Este método devuelve una explotación ganadera específica por su ID.
    public Explotacion getExplotacionById(Integer id) {
        return explotacionRepository.findById(id).get();
    }

    // Este método devuelve una lista de explotaciones ganaderas filtradas por el ID del ganadero.
    public List<Explotacion> getExplotacionesByIdGanadero(Integer id) {
        return explotacionRepository.obtenerExplotacionesPorIdGanadero(id);
    }
}