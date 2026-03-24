package com.techchallenge.restaurante.controller;

import com.techchallenge.restaurante.entity.Pedido;
import com.techchallenge.restaurante.entity.Produto;
import com.techchallenge.restaurante.entity.Restaurante;
import com.techchallenge.restaurante.entity.Usuario;
import com.techchallenge.restaurante.repository.PedidoRepository;
import com.techchallenge.restaurante.repository.ProdutoRepository;
import com.techchallenge.restaurante.repository.RestauranteRepository;
import com.techchallenge.restaurante.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoRepository pedidoRepository;
    private final UsuarioRepository usuarioRepository;
    private final RestauranteRepository restauranteRepository;
    private final ProdutoRepository produtoRepository;

    public PedidoController(PedidoRepository pedidoRepository,
                            UsuarioRepository usuarioRepository,
                            RestauranteRepository restauranteRepository,
                            ProdutoRepository produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.usuarioRepository = usuarioRepository;
        this.restauranteRepository = restauranteRepository;
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido) {

        Usuario usuario = usuarioRepository.findById(pedido.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Restaurante restaurante = restauranteRepository.findById(pedido.getRestaurante().getId())
                .orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));

        Produto produto = produtoRepository.findById(pedido.getProduto().getId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        pedido.setUsuario(usuario);
        pedido.setRestaurante(restaurante);
        pedido.setProduto(produto);

        double valorTotal = produto.getPreco() * pedido.getQuantidade();
        pedido.setValorTotal(valorTotal);

        if (pedido.getStatus() == null || pedido.getStatus().isBlank()) {
            pedido.setStatus("PENDENTE");
        }

        return pedidoRepository.save(pedido);
    }

    @GetMapping
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }
}