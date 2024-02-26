package com.example.springganaderia.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "matadero")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder


public class Matadero {


    @Column(name= "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="direccion")
    private String direccion;

    @Column(name="telefono")
    private String telefono;
}
