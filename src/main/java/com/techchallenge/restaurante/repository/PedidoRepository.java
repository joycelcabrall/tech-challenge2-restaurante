package com.techchallenge.restaurante.repository;

import com.techchallenge.restaurante.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}