package com.techchallenge.restaurante.controller;

import com.techchallenge.restaurante.entity.Produto;
import com.techchallenge.restaurante.entity.Restaurante;
import com.techchallenge.restaurante.repository.ProdutoRepository;
import com.techchallenge.restaurante.repository.RestauranteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;
    private final RestauranteRepository restauranteRepository;

    public ProdutoController(ProdutoRepository produtoRepository, RestauranteRepository restauranteRepository) {
        this.produtoRepository = produtoRepository;
        this.restauranteRepository = restauranteRepository;
    }

    // 🔹 Criar produto
    @PostMapping
    public Produto criar(@RequestBody Produto produto) {

        if (produto.getRestaurante() != null && produto.getRestaurante().getId() != null) {
            Restaurante restaurante = restauranteRepository.findById(produto.getRestaurante().getId())
                    .orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));

            produto.setRestaurante(restaurante);
        }

        return produtoRepository.save(produto);
    }

    // 🔹 Listar todos os produtos
    @GetMapping
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    // 🔹 Buscar produto por ID
    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    // 🔹 Atualizar produto
    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {

        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setNome(produtoAtualizado.getNome());
        produto.setDescricao(produtoAtualizado.getDescricao());
        produto.setPreco(produtoAtualizado.getPreco());

        if (produtoAtualizado.getRestaurante() != null && produtoAtualizado.getRestaurante().getId() != null) {
            Restaurante restaurante = restauranteRepository.findById(produtoAtualizado.getRestaurante().getId())
                    .orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));

            produto.setRestaurante(restaurante);
        }

        return produtoRepository.save(produto);
    }

    // 🔹 Deletar produto
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }
}