package com.techchallenge.restaurante.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techchallenge.restaurante.entity.Produto;
import com.techchallenge.restaurante.entity.Restaurante;
import com.techchallenge.restaurante.repository.ProdutoRepository;
import com.techchallenge.restaurante.repository.RestauranteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ProdutoControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @BeforeEach
    void limparBanco() {
        produtoRepository.deleteAll();
        restauranteRepository.deleteAll();
    }

    @Test
    @DisplayName("Deve criar produto")
    void deveCriarProduto() throws Exception {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Sabor Caseiro");
        restaurante.setEndereco("Rua Nossa Senhora Aparecida, 1516");
        restaurante.setTipoCozinha("Comida Caseira");
        restaurante.setHorarioFuncionamento("10h às 15h");

        restaurante = restauranteRepository.save(restaurante);

        Produto produto = new Produto();
        produto.setNome("Virada Paulista");
        produto.setDescricao("Arroz, feijão, bisteca, couve, ovo e banana");
        produto.setPreco(25.90);
        produto.setApenasNoLocal(false);
        produto.setCaminhoFoto("/imagens/virada.jpg");
        produto.setRestaurante(restaurante);

        mockMvc.perform(post("/produtos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(produto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.nome").value("Virada Paulista"));
    }

    @Test
    @DisplayName("Deve listar produtos")
    void deveListarProdutos() throws Exception {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Sabor Caseiro");
        restaurante.setEndereco("Rua Nossa Senhora Aparecida, 1516");
        restaurante.setTipoCozinha("Comida Caseira");
        restaurante.setHorarioFuncionamento("10h às 15h");

        restaurante = restauranteRepository.save(restaurante);

        Produto produto = new Produto();
        produto.setNome("Virada Paulista");
        produto.setDescricao("Arroz, feijão, bisteca, couve, ovo e banana");
        produto.setPreco(25.90);
        produto.setApenasNoLocal(false);
        produto.setCaminhoFoto("/imagens/virada.jpg");
        produto.setRestaurante(restaurante);

        produtoRepository.save(produto);

        mockMvc.perform(get("/produtos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].nome").value("Virada Paulista"));
    }
}