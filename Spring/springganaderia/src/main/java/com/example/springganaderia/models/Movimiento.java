package com.example.springganaderia.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "movimiento")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Movimiento {
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
