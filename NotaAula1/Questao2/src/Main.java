import java.util.Scanner;

class Produto {
    private int codigo;
    private String nome;
    private String tamanhoPeso;
    private String cor;
    private double valor;
    private int quantidadeEstoque;

    public Produto(int codigo, String nome, String tamanhoPeso, String cor, double valor, int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.tamanhoPeso = tamanhoPeso;
        this.cor = cor;
        this.valor = valor;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getTamanhoPeso() {
        return tamanhoPeso;
    }

    public String getCor() {
        return cor;
    }

    public double getValor() {
        return valor;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void vender(int quantidade) {
        if (quantidade <= quantidadeEstoque) {
            quantidadeEstoque -= quantidade;
        } else {
            System.out.println("Estoque insuficiente.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cadastro do produto
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o tamanho/peso do produto: ");
        String tamanhoPeso = scanner.nextLine();
        System.out.print("Digite a cor do produto: ");
        String cor = scanner.nextLine();
        System.out.print("Digite o valor do produto: ");
        double valor = scanner.nextDouble();
        System.out.print("Digite a quantidade em estoque: ");
        int quantidadeEstoque = scanner.nextInt();

        Produto produto = new Produto(codigo, nome, tamanhoPeso, cor, valor, quantidadeEstoque);

        // Realizar venda
        System.out.print("Digite a quantidade a ser vendida: ");
        int quantidadeVenda = scanner.nextInt();
        produto.vender(quantidadeVenda);

        // Calcular valor total da venda
        double valorTotal = produto.getValor() * quantidadeVenda;

        // Aplicar desconto ou parcelamento
        System.out.print("Forma de pagamento (Pix, Especie, Transferencia, Debito, Credito): ");
        scanner.nextLine(); // Consumir a nova linha
        String formaPagamento = scanner.nextLine();
        double valorFinal = valorTotal;

        if (formaPagamento.equalsIgnoreCase("Pix") || formaPagamento.equalsIgnoreCase("Especie") ||
                formaPagamento.equalsIgnoreCase("Transferencia") || formaPagamento.equalsIgnoreCase("Debito")) {
            valorFinal = valorTotal * 0.95;
        } else if (formaPagamento.equalsIgnoreCase("Credito")) {
            System.out.println("Valor pode ser parcelado em 3x sem juros de: " + (valorTotal / 3));
        }

        // Informar troco se pagamento em espécie
        if (formaPagamento.equalsIgnoreCase("Especie")) {
            System.out.print("Digite o valor pago: ");
            double valorPago = scanner.nextDouble();
            if (valorPago > valorFinal) {
                double troco = valorPago - valorFinal;
                System.out.println("Troco: " + troco);
            }
        }

        // Exibir informações da venda
        System.out.println("Produto: " + produto.getNome());
        System.out.println("Quantidade vendida: " + quantidadeVenda);
        System.out.println("Valor total: " + valorTotal);
        System.out.println("Valor final com desconto: " + valorFinal);
        System.out.println("Quantidade em estoque após venda: " + produto.getQuantidadeEstoque());

        scanner.close();
    }
}