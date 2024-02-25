package com.example.springganaderia.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// modelo de entidad para representar la información de las explotaciones en nuestra aplicación .
@Entity // Lo utilizamos para indicar que esta clase es una entidad JPA.
@Table(name= "explotacion") // nombre de la tabla en la base de datos.
@NoArgsConstructor // Genera un constructor sin argumentos.
@AllArgsConstructor // Genera un constructor con todos los argumentos.
@Data  // Genera automáticamente métodos getter, setter, toString, equals, y hashCode.
@Builder // Implementa el patrón de diseño Builder para la creación de instancias más fácil y legible.

public class Explotacion {

    // '@Column' especifica el mapeo a la columna correspondiente en la base de datos.
    // '@Id' marca este campo como clave primaria.
    // '@GeneratedValue' indica que el valor de esta columna se genera automáticamente (autoincremental).

    @Column(name= "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="ubicacion")
    private String ubicacion;

    @Column(name="tipo_animal")
    private String tipo_animal;

    @Column(name="capacidad")
    private Integer capacidad;

    @Column(name="id_ganadero")
    private Integer id_ganadero;

}
