package com.example.springganaderia.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// modelo de entidad para representar la información de los movimientos en nuestra aplicación .
@Entity // Lo utilizamos para indicar que esta clase es una entidad JPA.
@Table(name= "movimiento") // nombre de la tabla en la base de datos.
@NoArgsConstructor // Genera un constructor sin argumentos.
@AllArgsConstructor // Genera un constructor con todos los argumentos.
@Data  // Genera automáticamente métodos getter, setter, toString, equals, y hashCode.
@Builder // Implementa el patrón de diseño Builder para la creación de instancias más fácil y legible.
public class Movimiento {

    // '@Column' especifica el mapeo a la columna correspondiente en la base de datos.
    // '@Id' marca este campo como clave primaria.
    // '@GeneratedValue' indica que el valor de esta columna se genera automáticamente (autoincremental).

    @Column(name= "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="tipo")
    private String tipo;

    @Column(name="id_matadero")
    private Integer id_matadero;

    @Column(name="id_explotacion")
    private Integer id_explotacion;

    @Column(name="fecha")
    private String fecha;
}
