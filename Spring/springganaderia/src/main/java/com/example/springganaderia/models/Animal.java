package com.example.springganaderia.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "animal")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Animal {

    @Column(name= "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="especie")
    private String nombre;

    @Column(name="sexo")
    private String sexo;

    @Column(name="edad")
    private Integer edad;

    @Column(name="estado")
    private String estado;

    @Column(name="id_explotacion")
    private Integer id_explotacion;



}
