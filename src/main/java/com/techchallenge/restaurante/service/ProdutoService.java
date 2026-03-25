package com.techchallenge.restaurante.service;

import com.techchallenge.restaurante.entity.Produto;
import com.techchallenge.restaurante.entity.Restaurante;
import com.techchallenge.restaurante.repository.ProdutoRepository;
import com.techchallenge.restaurante.repository.RestauranteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final RestauranteRepository restauranteRepository;

    public ProdutoService(ProdutoRepository produtoRepository, RestauranteRepository restauranteRepository) {
        this.produtoRepository = produtoRepository;
        this.restauranteRepository = restauranteRepository;
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto salvar(Produto produto) {
        if (produto.getRestaurante() != null && produto.getRestaurante().getId() != null) {
            Restaurante restaurante = restauranteRepository.findById(produto.getRestaurante().getId())
                    .orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));

            produto.setRestaurante(restaurante);
        }

        return produtoRepository.save(produto);
    }

    public Produto atualizar(Long id, Produto produtoAtualizado) {
        Produto produto = buscarPorId(id);

        produto.setNome(produtoAtualizado.getNome());
        produto.setDescricao(produtoAtualizado.getDescricao());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.setApenasNoLocal(produtoAtualizado.getApenasNoLocal());
        produto.setCaminhoFoto(produtoAtualizado.getCaminhoFoto());

        if (produtoAtualizado.getRestaurante() != null && produtoAtualizado.getRestaurante().getId() != null) {
            Restaurante restaurante = restauranteRepository.findById(produtoAtualizado.getRestaurante().getId())
                    .orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));

            produto.setRestaurante(restaurante);
        }

        return produtoRepository.save(produto);
    }

    public void deletar(Long id) {
        Produto produto = buscarPorId(id);
        produtoRepository.delete(produto);
    }
}