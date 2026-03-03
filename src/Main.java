import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> usuarios = new ArrayList<>();

        int opcao;

        do{
            System.out.println("========== MENU ============");
            System.out.println("1- CADASTRAR USUÁRIO");
            System.out.println("2- LISTAR USUÁRIO");
            System.out.println("3- EDITAR USUÁRIO");
            System.out.println("4- EXCLUIR USUÁRIO");
            System.out.println("0- SAIR");
            System.out.println("Escolha uma das opções ou 0 para sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.print(" Digite o nome do usuário: ");
                String nome = scanner.nextLine();
                usuarios.add(nome);
                System.out.println("Usuário cadastrado com sucesso!");
                break;

            case 2:
                if (usuarios.isEmpty()){
                    System.out.println("Nenhum usuário cadastrado");
                } else{
                    System.out.println( "\n Lista de Usuários Cadastrados ");
                    for (int i = 0 ; i< usuarios.size(); i++) {
                        System.out.println( i + "-" + usuarios.get(i));
                    }
                }
                break;

            case 3:
                System.out.println("digite o indice do usuário para editar: ");
                int indiceParaEditar = scanner.nextInt();
                scanner.nextLine();

                if (indiceParaEditar >= 0 && indiceParaEditar < usuarios.size()){
                    System.out.println("Novo nome: ");
                    String novoNome = scanner.nextLine();
                    usuarios.set(indiceParaEditar, novoNome);
                    System.out.println("Usuário Atualizado.");
                }else {
                    System.out.println("Índice inválido");
                }
                break;

            case 4:
                System.out.println("digite o indice do usuário para excluir: ");
                int indiceParaExcluir = scanner.nextInt();

                if( indiceParaExcluir >= 0 && indiceParaExcluir < usuarios.size()){
                    usuarios.remove(indiceParaExcluir);
                    System.out.println("Usuário removido");
                }else{
                    System.out.println( "Índice não valido");
                }
                break;
            case 0:
                System.out.println(" Encerrando Aplicação...");
                break;

            default:
                System.out.println(" Opção inválida." );
        }

        }while (opcao != 0);
        scanner.close();




        }
}

