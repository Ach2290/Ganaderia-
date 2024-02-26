package com.example.springganaderia.repositories;

import com.example.springganaderia.models.Ganadero;
import com.example.springganaderia.models.Matadero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MataderoRepository extends JpaRepository<Matadero, Integer> {

}
