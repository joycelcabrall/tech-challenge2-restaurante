package com.techchallenge.restaurante.controller;

import com.techchallenge.restaurante.entity.TipoUsuario;
import com.techchallenge.restaurante.repository.TipoUsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos-usuario")
public class TipoUsuarioController {

    private final TipoUsuarioRepository repository;

    public TipoUsuarioController(TipoUsuarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public TipoUsuario criar(@RequestBody TipoUsuario tipo) {
        return repository.save(tipo);
    }

    @GetMapping
    public List<TipoUsuario> listar() {
        return repository.findAll();
    }
}