package com.example.springganaderia.controllers;

import com.example.springganaderia.models.Ganadero;
import com.example.springganaderia.services.GanaderoService;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Con este controlador  gestionamos las solicitudes relacionadas con los ganaderos
// Utilizamos la anotación '@RestController', lo que indica que cada método devuelve directamente JSON al cliente.
@RequestMapping("/ganadero")
@RestController
public class GanaderoController {

    // Usamos un servicio para gestionar la lógica relacionada con los ganaderos, y Spring se encarga de inyectar esta dependencia automáticamente.
    @Autowired
    private GanaderoService ganaderoService;

    // Este método maneja solicitudes para obtener todos los ganaderos y simplemente llama al servicio para hacerlo.
    @GetMapping("/all")
    public List<Ganadero> getAllGanaderos() {
        return ganaderoService.getAllGanaderos();
    }

    // Aquí gestionamos solicitudes para obtener un ganadero específico por su ID.
    @GetMapping("/byId/{id}")
    public Ganadero getById(@PathVariable Integer id) {
        return ganaderoService.getById(id);
    }

    // Este método maneja solicitudes de inicio de sesión por correo electrónico y devuelve una lista de ganaderos asociados al correo proporcionado.
    @PostMapping("/login/{correo}")
    public List<Ganadero> login(@PathVariable String correo) {
        return ganaderoService.logIn(correo);
    }

    // Este método maneja solicitudes de inicio de sesión por nombre y devuelve un mensaje indicando que el nombre de usuario ya está registrado.
    @PostMapping("/loginNombre/{nombre}")
    public String loginNombre(@PathVariable String nombre) {
        System.err.println(nombre);
        return "NOMBRE DE USUARIO YA REGISTRADO";
    }

    // Este método maneja solicitudes de registro de nuevos ganaderos.
    @PostMapping("/registro")
    public Ganadero registro(@RequestBody Ganadero ganadero) {
        System.err.println(ganadero);
        return ganaderoService.registro(ganadero);
    }

    // Este método maneja solicitudes de actualización de información de ganaderos.
    @PostMapping("/updateGanadero")
    public Ganadero updateCorreo(@RequestBody Ganadero ganadero) {
        return ganaderoService.updateGanadero(ganadero);
    }
}
