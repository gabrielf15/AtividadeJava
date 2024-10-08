import java.util.Scanner;

abstract class ContaBancaria {
    protected String titular;
    protected double saldo;

    public ContaBancaria(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void exibirDados() {
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: R$" + saldo);
    }
}

class ContaCorrente extends ContaBancaria {
    private double chequeEspecial = 1000.0;

    public ContaCorrente(String titular) {
        super(titular);
    }

    public void usarChequeEspecial(double valor) {
        if (valor <= saldo + chequeEspecial) {
            saldo -= valor;
            System.out.println("Uso de cheque especial de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Limite de cheque especial excedido.");
        }
    }
}

class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(String titular) {
        super(titular);
    }

    public void calcularRendimento(double selic) {
        double rendimento;
        if (selic > 8.5) {
            rendimento = 0.005 * saldo;
        } else {
            rendimento = 0.007 * selic * saldo;
        }
        saldo += rendimento;
        System.out.println("Rendimento de R$" + rendimento + " calculado e adicionado ao saldo.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaBancaria conta = null;

        System.out.println("Selecione o tipo de conta:");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        int tipoConta = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.println("Digite o nome do titular:");
        String titular = scanner.nextLine();

        if (tipoConta == 1) {
            conta = new ContaCorrente(titular);
        } else if (tipoConta == 2) {
            conta = new ContaPoupanca(titular);
        } else {
            System.out.println("Tipo de conta inválido.");
            System.exit(0);
        }

        int opcao;
        do {
            System.out.println("\nMenu de opções:");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            if (conta instanceof ContaCorrente) {
                System.out.println("3. Usar cheque especial");
            } else if (conta instanceof ContaPoupanca) {
                System.out.println("3. Calcular rendimento");
            }
            System.out.println("4. Exibir dados da conta");
            System.out.println("5. Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor do depósito:");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.println("Digite o valor do saque:");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    if (conta instanceof ContaCorrente) {
                        System.out.println("Digite o valor do cheque especial:");
                        double valorCheque = scanner.nextDouble();
                        ((ContaCorrente) conta).usarChequeEspecial(valorCheque);
                    } else if (conta instanceof ContaPoupanca) {
                        System.out.println("Digite a taxa Selic atual:");
                        double selic = scanner.nextDouble();
                        ((ContaPoupanca) conta).calcularRendimento(selic);
                    }
                    break;
                case 4:
                    conta.exibirDados();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}
