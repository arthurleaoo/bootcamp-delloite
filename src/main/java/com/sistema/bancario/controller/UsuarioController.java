package com.sistema.bancario.controller;

import com.sistema.bancario.dto.UsuarioRequestDto;
import com.sistema.bancario.dto.UsuarioResponseDto;
import com.sistema.bancario.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public UsuarioResponseDto criar(@RequestBody UsuarioRequestDto usuarioRequestDtodto){
        return usuarioService.criarUsuario(usuarioRequestDtodto);
    }

    @GetMapping("/{id}")
    public UsuarioResponseDto buscarUsuarioId(@PathVariable Long id){
        return usuarioService.buscarUsuarioId(id);
    }
    @PutMapping("/{id}")
    public UsuarioResponseDto atualizarUsuarioId(@PathVariable Long id,
                                                 @RequestBody UsuarioRequestDto usuarioRequestDto ){

        return usuarioService.atualizarUsuarioId(id, usuarioRequestDto);
    }

    @GetMapping
    public List<UsuarioResponseDto> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuarioID(id);
    }
}