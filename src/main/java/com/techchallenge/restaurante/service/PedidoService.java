package com.techchallenge.restaurante.service;

import com.techchallenge.restaurante.entity.*;
import com.techchallenge.restaurante.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final UsuarioRepository usuarioRepository;
    private final RestauranteRepository restauranteRepository;
    private final ProdutoRepository produtoRepository;

    public PedidoService(PedidoRepository pedidoRepository,
                         UsuarioRepository usuarioRepository,
                         RestauranteRepository restauranteRepository,
                         ProdutoRepository produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.usuarioRepository = usuarioRepository;
        this.restauranteRepository = restauranteRepository;
        this.produtoRepository = produtoRepository;
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public Pedido salvar(Pedido pedido) {

        Usuario usuario = usuarioRepository.findById(pedido.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Restaurante restaurante = restauranteRepository.findById(pedido.getRestaurante().getId())
                .orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));

        Produto produto = produtoRepository.findById(pedido.getProduto().getId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        pedido.setUsuario(usuario);
        pedido.setRestaurante(restaurante);
        pedido.setProduto(produto);

        // cálculo automático
        pedido.setValorTotal(produto.getPreco() * pedido.getQuantidade());

        return pedidoRepository.save(pedido);
    }

    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }
}