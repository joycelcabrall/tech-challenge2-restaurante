package com.techchallenge.restaurante.controller;

import com.techchallenge.restaurante.entity.TipoUsuario;
import com.techchallenge.restaurante.entity.Usuario;
import com.techchallenge.restaurante.repository.TipoUsuarioRepository;
import com.techchallenge.restaurante.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final TipoUsuarioRepository tipoUsuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository, TipoUsuarioRepository tipoUsuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {

        if (usuario.getTipoUsuario() != null && usuario.getTipoUsuario().getId() != null) {
            TipoUsuario tipoUsuario = tipoUsuarioRepository.findById(usuario.getTipoUsuario().getId())
                    .orElseThrow(() -> new RuntimeException("Tipo de usuário não encontrado"));

            usuario.setTipoUsuario(tipoUsuario);
        }

        Usuario salvo = usuarioRepository.save(usuario);

        return usuarioRepository.findById(salvo.getId()).orElse(null);
    }

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }
}