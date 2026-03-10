package com.sistema.bancario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaCadastro {

    public static void main (String[] args) {
        SpringApplication.run(SistemaCadastro.class, args);
    }

}

//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        SistemaBanco sistema = new SistemaBanco();
//
//        int opcao;
//
//        do {
//            System.out.println("===========MENU============");
//            System.out.println("1 - Cadastrar usuário");
//            System.out.println("2 - Listar usuários");
//            System.out.println("3 - Editar usuários");
//            System.out.println("4 - Excluir usuários");
//            System.out.println("5 - Depositar");
//            System.out.println("6 - Sacar");
//            System.out.println("7 - Ver saldo");
//            System.out.println("0 - Sair");
//
//            opcao = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (opcao) {
//
//                case 1:
//                    sistema.cadastrarUsuario();
//
//                    break;
//
//                case 2:
//                    sistema.listarUsuarios();
//                    break;
//
//                case 3:
//                    sistema.editarUsuario();
//                    break;
//
//                case 4:
//                    sistema.excluirUsuario();
//                    break;
//
//                case 5:
//                    sistema.depositar();
//                    break;
//
//                case 6:
//                    sistema.sacar();
//                    break;
//
//                case 7:
//                    sistema.verSaldo();
//                    break;
//            }
//        } while(opcao != 0) ;
//
//    }
//}
