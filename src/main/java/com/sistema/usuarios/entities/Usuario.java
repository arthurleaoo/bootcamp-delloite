package com.sistema.usuarios.entities;


import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tb_usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String nome;
    public String cpf;
    public String email;
    public String senha;


}
