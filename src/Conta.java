public class Conta {

     int numeroConta;
     double saldo;

    public Conta(int numeroConta) {
        this.numeroConta = numeroConta;
        this.saldo = 0;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {

        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado.");
        } else {
            System.out.println("Valor inválido.");
        }

    }

    public void sacar(double valor) {

        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
        } else if (valor <= 0) {
            System.out.println("Valor inválido.");
        } else {
            saldo -= valor;
            System.out.println("Saque realizado.");
        }

    }
}