package com.techchallenge.restaurante.repository;

import com.techchallenge.restaurante.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}