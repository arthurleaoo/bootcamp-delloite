package com.sistema.usuarios.service;

import com.sistema.usuarios.dto.UsuarioRequestDto;
import com.sistema.usuarios.dto.UsuarioResponseDto;

import java.util.List;

public interface UsuarioService {

    UsuarioResponseDto criarUsuario(UsuarioRequestDto usuarioRequestDto);

    UsuarioResponseDto buscarUsuarioId ( Long id);

    List<UsuarioResponseDto> listarUsuarios();

    void deletarUsuarioID ( Long id);

    UsuarioResponseDto atualizarUsuarioId(Long id, UsuarioRequestDto usuarioRequestDto);
}
