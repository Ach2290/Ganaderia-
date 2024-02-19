package com.example.springganaderia.repositories;

import com.example.springganaderia.models.Ganadero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GanaderoRepository extends JpaRepository<Ganadero, Integer> {

}
