package com.sistema.usuarios.exception;

public class ListaUsuariosVaziaException extends RuntimeException {

    public ListaUsuariosVaziaException() {
        super("Nenhum usuário encontrado no sistema");
    }

}