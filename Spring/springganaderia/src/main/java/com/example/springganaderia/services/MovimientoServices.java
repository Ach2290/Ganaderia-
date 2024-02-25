package com.example.springganaderia.services;

// Este es el servicio encargado de gestionar la lógica de negocio relacionada con la entidad 'Movimiento' en nuestra aplicación Spring.
import com.example.springganaderia.models.Movimiento;
import com.example.springganaderia.repositories.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoServices {

    // metemos automáticamente el repositorio para acceder a los datos de la entidad 'Movimiento'.
   @Autowired
    MovimientoRepository movimientoRepository;

    // Este método devuelve una lista de movimientos filtrados por el ID del ganadero.
   public List<Movimiento> obtenerMovimientoIdGanadero(Integer id_ganadero) {return movimientoRepository.obtenerMovimientoIdGanadero(id_ganadero);}

}
