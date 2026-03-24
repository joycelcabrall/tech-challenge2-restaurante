package com.techchallenge.restaurante.repository;

import com.techchallenge.restaurante.entity.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {
}