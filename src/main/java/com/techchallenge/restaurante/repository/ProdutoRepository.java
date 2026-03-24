package com.techchallenge.restaurante.repository;

import com.techchallenge.restaurante.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}