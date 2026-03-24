package com.techchallenge.restaurante.service;

import com.techchallenge.restaurante.entity.Restaurante;
import com.techchallenge.restaurante.repository.RestauranteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {

    private final RestauranteRepository repository;

    public RestauranteService(RestauranteRepository repository) {
        this.repository = repository;
    }

    public List<Restaurante> listarTodos() {
        return repository.findAll();
    }

    public Restaurante buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));
    }

    public Restaurante salvar(Restaurante restaurante) {
        return repository.save(restaurante);
    }

    public Restaurante atualizar(Long id, Restaurante restauranteAtualizado) {
        Restaurante restaurante = buscarPorId(id);

        restaurante.setNome(restauranteAtualizado.getNome());
        restaurante.setEndereco(restauranteAtualizado.getEndereco());
        restaurante.setTipoCozinha(restauranteAtualizado.getTipoCozinha());
        restaurante.setHorarioFuncionamento(restauranteAtualizado.getHorarioFuncionamento());
        restaurante.setDono(restauranteAtualizado.getDono());

        return repository.save(restaurante);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}