package com.techchallenge.restaurante.controller;

import com.techchallenge.restaurante.entity.Restaurante;
import com.techchallenge.restaurante.service.RestauranteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    private final RestauranteService service;

    public RestauranteController(RestauranteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Restaurante> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Restaurante buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Restaurante criar(@RequestBody Restaurante restaurante) {
        return service.salvar(restaurante);
    }

    @PutMapping("/{id}")
    public Restaurante atualizar(@PathVariable Long id, @RequestBody Restaurante restaurante) {
        return service.atualizar(id, restaurante);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}