package com.techchallenge.restaurante.service;

import com.techchallenge.restaurante.entity.Produto;
import com.techchallenge.restaurante.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public Produto atualizar(Long id, Produto produtoAtualizado) {
        Produto produto = buscarPorId(id);

        produto.setNome(produtoAtualizado.getNome());
        produto.setDescricao(produtoAtualizado.getDescricao());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.setApenasNoLocal(produtoAtualizado.getApenasNoLocal());
        produto.setCaminhoFoto(produtoAtualizado.getCaminhoFoto());
        produto.setRestaurante(produtoAtualizado.getRestaurante());

        return repository.save(produto);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}