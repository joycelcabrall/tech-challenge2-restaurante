package com.techchallenge.restaurante.service;

import com.techchallenge.restaurante.entity.Restaurante;
import com.techchallenge.restaurante.repository.RestauranteRepository;
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
class RestauranteServiceTest {

    @Mock
    private RestauranteRepository repository;

    @InjectMocks
    private RestauranteService service;

    @Test
    void deveListarRestaurantes() {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Sabor Caseiro");

        when(repository.findAll()).thenReturn(List.of(restaurante));

        List<Restaurante> resultado = service.listarTodos();

        assertEquals(1, resultado.size());
        assertEquals("Sabor Caseiro", resultado.get(0).getNome());
    }

    @Test
    void deveBuscarRestaurantePorId() {
        Restaurante restaurante = new Restaurante();
        restaurante.setId(1L);
        restaurante.setNome("Sabor Caseiro");

        when(repository.findById(1L)).thenReturn(Optional.of(restaurante));

        Restaurante resultado = service.buscarPorId(1L);

        assertEquals("Sabor Caseiro", resultado.getNome());
    }
}