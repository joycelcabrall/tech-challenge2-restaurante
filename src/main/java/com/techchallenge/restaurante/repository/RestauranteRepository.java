package com.techchallenge.restaurante.repository;

import com.techchallenge.restaurante.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}