package com.victorbarreto.bilhete_unico.usuario.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.victorbarreto.bilhete_unico.usuario.dto.UsuarioCreateDTO;
import com.victorbarreto.bilhete_unico.usuario.entity.UsuarioModel;
import com.victorbarreto.bilhete_unico.exception.UsuarioCadastradoException;
import com.victorbarreto.bilhete_unico.usuario.repository.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {
    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Test
    @DisplayName("Criação de usuario com sucesso")
    void cadastrarUsuarioSucesso() {
        UsuarioCreateDTO usuarioNovo = new UsuarioCreateDTO("victor", "02094567543", LocalDate.of(2000, 5, 20));

        Mockito.when(usuarioRepository.existsByCpf(anyString())).thenReturn(false);

        Mockito.when(usuarioRepository.save(Mockito.any(UsuarioModel.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        UsuarioModel usuarioModel = usuarioService.cadastrarUsuario(usuarioNovo);

        assertNotNull(usuarioModel);
        assertEquals("victor", usuarioModel.getNome());
        assertEquals("02094567543", usuarioModel.getCpf());
        assertEquals(LocalDate.of(2000, 5, 20), usuarioModel.getDataNasc());
    }

    @Test
    @DisplayName("Criação de usuario com erro de cpf já existente")
    void cadastrarUsuarioExisteCpf() {
        UsuarioCreateDTO usuarioNovo = new UsuarioCreateDTO("victor", "02094567543", LocalDate.of(2000, 5, 20));

        Mockito.when(usuarioRepository.existsByCpf(anyString())).thenReturn(true);

        UsuarioCadastradoException exception = assertThrows(
                UsuarioCadastradoException.class,
                () -> usuarioService.cadastrarUsuario(usuarioNovo)
        );

        assertEquals("Usuario já cadastrado no sistema!", exception.getMessage());
    }
}