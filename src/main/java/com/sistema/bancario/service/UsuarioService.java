package com.sistema.bancario.service;

import com.sistema.bancario.dto.UsuarioRequestDto;
import com.sistema.bancario.dto.UsuarioResponseDto;

import java.util.List;

public interface UsuarioService {

    UsuarioResponseDto criarUsuario(UsuarioRequestDto usuarioRequestDto);

    UsuarioResponseDto buscarUsuarioId ( Long id);

    List<UsuarioResponseDto> listarUsuarios();

    void deletarUsuarioID ( Long id);

    UsuarioResponseDto atualizarUsuarioId(Long id, UsuarioRequestDto usuarioRequestDto);
}
