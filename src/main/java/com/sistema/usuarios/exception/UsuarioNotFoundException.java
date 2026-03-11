package com.sistema.usuarios.exception;

public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException(Long id) {
        super("Usuário com id " + id + " não encontrado");
    }

}