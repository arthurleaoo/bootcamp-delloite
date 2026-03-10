package com.sistema.usuarios.service.impl;

import com.sistema.usuarios.dto.UsuarioRequestDto;
import com.sistema.usuarios.dto.UsuarioResponseDto;
import com.sistema.usuarios.entities.Usuario;
import com.sistema.usuarios.repository.UsuarioRepository;
import com.sistema.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository repository;

    @Override
    public UsuarioResponseDto criarUsuario(UsuarioRequestDto usuarioRequestDto) {
        Usuario usuario = new Usuario();
        usuario.setCpf(usuarioRequestDto.cpf());
        usuario.setNome(usuarioRequestDto.nome());
        usuario.setEmail(usuarioRequestDto.email());
        usuario.setSenha(usuarioRequestDto.senha());

        repository.save(usuario);
        return new UsuarioResponseDto(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getCpf()
        );
    }

    @Override
    public UsuarioResponseDto buscarUsuarioId(Long id) {

        Usuario usuario = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuário não encontrado") );

        return new UsuarioResponseDto(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getCpf()
        );
    }

    @Override
    public List<UsuarioResponseDto> listarUsuarios() {

        List<Usuario> usuarios = repository.findAll();

        if (usuarios.isEmpty()) {
            throw new RuntimeException("Nenhum usuário encontrado");
        }

        return usuarios.stream()
                .map(usuario -> new UsuarioResponseDto(
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getEmail(),
                        usuario.getCpf()
                ))
                .toList();
    }

    @Override
    public void deletarUsuarioID(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        repository.delete(usuario);

    }

    @Override
    public UsuarioResponseDto atualizarUsuarioId(Long id, UsuarioRequestDto usuarioRequestDto) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setNome(usuarioRequestDto.nome());
        usuario.setEmail(usuarioRequestDto.email());
        usuario.setCpf(usuarioRequestDto.cpf());
        usuario.setSenha(usuarioRequestDto.senha());

        Usuario usuarioAtualizado = repository.save(usuario);

        return new UsuarioResponseDto(
                usuarioAtualizado.getId(),
                usuarioAtualizado.getNome(),
                usuarioAtualizado.getEmail(),
                usuarioAtualizado.getCpf()
        );

    }

}
