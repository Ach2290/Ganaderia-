package com.example.springganaderia.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "explotacion")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Explotacion {

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
