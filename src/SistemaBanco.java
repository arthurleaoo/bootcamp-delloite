//// Por enquanto vou deixar os métodos separados dentro dessa classe para melhor organização do Código, quando partir para Spring, eu organizo de acordo com as melhores práticas
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class SistemaBanco {
//
//    public ArrayList<Usuario> usuarios = new ArrayList<>();
//    public Scanner scanner = new Scanner(System.in);
//    public int contadorConta = 1;
//
//    public void cadastrarUsuario() {
//
//        System.out.println("Nome:");
//        String nome = scanner.nextLine();
//
//        System.out.println("CPF:");
//        String cpf = scanner.nextLine();
//
//        if (cpfExiste(cpf)) {
//            System.out.println("Já existe um usuário com esse CPF.");
//            return;
//        }
//
//        System.out.println("Email:");
//        String email = scanner.nextLine();
//
//        if (emailExiste(email)) {
//            System.out.println("Já existe um usuário com esse email.");
//            return;
//        }
//
//        System.out.println("Senha:");
//        String senha = scanner.nextLine();
//
//        Usuario usuario = new Usuario(nome, cpf, email, senha, contadorConta++);
//        usuarios.add(usuario);
//
//        System.out.println("Usuário criado com conta número: " + usuario.getConta().getNumeroConta());
//    }
//
//    public void listarUsuarios() {
//
//        if (usuarios.isEmpty()) {
//            System.out.println("\n Não existe nenhum usuário cadastrado. \n");
//            return;
//        }
//
//        System.out.println("\n=== USUÁRIOS CADASTRADOS ===");
//
//        for (int i = 0; i < usuarios.size(); i++) {
//
//            Usuario u = usuarios.get(i);
//
//            System.out.println(i + " - " + u.getNome() + " | Conta: " + u.getConta().getNumeroConta());
//        }
//    }
//
//    public void editarUsuario() {
//
//        listarUsuarios();
//        if (usuarios.isEmpty()) {
//            return;
//        }
//
//        System.out.println("Escolha o índice do usuário:");
//        int indice = scanner.nextInt();
//        scanner.nextLine();
//
//        if (indice >= 0 && indice < usuarios.size()) {
//
//            Usuario usuario = usuarios.get(indice);
//
//            System.out.println("Novo nome:");
//            String novoNome = scanner.nextLine();
//
//            usuario.setNome(novoNome);
//
//            System.out.println("Usuário atualizado.");
//
//        } else {
//            System.out.println("Índice inválido.");
//        }
//    }
//
//    public void excluirUsuario() {
//
//        listarUsuarios();
//
//        System.out.println("Escolha o índice do usuário para excluir:");
//        int indice = scanner.nextInt();
//
//        if (indice >= 0 && indice < usuarios.size()) {
//
//            usuarios.remove(indice);
//            System.out.println("Usuário removido.");
//
//        } else {
//            System.out.println("Índice inválido.");
//        }
//    }
//
//
//    public void depositar() {
//
//        listarUsuarios();
//
//        System.out.println("Escolha o índice do usuário para depositar:");
//        int indice = scanner.nextInt();
//
//        System.out.println("Valor do depósito:");
//        double valor = scanner.nextDouble();
//
//        usuarios.get(indice).getConta().depositar(valor);
//    }
//
//    public void sacar() {
//
//        listarUsuarios();
//
//        System.out.println("Escolha o indice do usuário para sacar:");
//        int indice = scanner.nextInt();
//
//        System.out.println("Valor do saque:");
//        double valor = scanner.nextDouble();
//
//        usuarios.get(indice).getConta().sacar(valor);
//    }
//
//    public void verSaldo() {
//
//        listarUsuarios();
//
//        System.out.println("Escolha o índice do usuário:");
//        int indice = scanner.nextInt();
//
//        if (indice >= 0 && indice < usuarios.size()) {
//
//            Usuario usuario = usuarios.get(indice);
//
//            System.out.println("Saldo da conta: R$ " + usuario.getConta().getSaldo());
//
//        } else {
//            System.out.println("Índice inválido.");
//        }
//
//
//
//    }
//    public boolean cpfExiste(String cpf) {
//
//        for (Usuario u : usuarios) {
//            if (u.getCpf().equals(cpf)) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    public boolean emailExiste(String email) {
//
//        for (Usuario u : usuarios) {
//            if (u.getEmail().equals(email)) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//}