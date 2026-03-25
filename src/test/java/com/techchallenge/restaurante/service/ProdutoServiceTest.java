package com.techchallenge.restaurante.service;

import com.techchallenge.restaurante.entity.Produto;
import com.techchallenge.restaurante.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {

    @Mock
    private ProdutoRepository repository;

    @InjectMocks
    private ProdutoService service;

    @Test
    void deveListarProdutos() {
        Produto produto = new Produto();
        produto.setNome("Virado à Paulista");

        when(repository.findAll()).thenReturn(List.of(produto));

        List<Produto> resultado = service.listarTodos();

        assertEquals(1, resultado.size());
        assertEquals("Virado à Paulista", resultado.get(0).getNome());
    }

    @Test
    void deveBuscarProdutoPorId() {
        Produto produto = new Produto();
        produto.setId(1L);
        produto.setNome("Virado à Paulista");

        when(repository.findById(1L)).thenReturn(Optional.of(produto));

        Produto resultado = service.buscarPorId(1L);

        assertEquals("Virado à Paulista", resultado.getNome());
    }
}