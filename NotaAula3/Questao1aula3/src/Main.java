import java.time.LocalDate;
import java.time.Period;

class Funcionario {
    private String nome;
    private LocalDate dataNascimento;
    private double salario;

    public Funcionario(String nome, LocalDate dataNascimento, double salario) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public int calcularIdade() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("Salário: R$" + salario);
        System.out.println("Idade: " + calcularIdade() + " anos");
    }
}

class Gerente extends Funcionario {
    private String projeto;

    public Gerente(String nome, LocalDate dataNascimento, double salario, String projeto) {
        super(nome, dataNascimento, salario);
        this.projeto = projeto;
    }

    public void informarProjeto() {
        System.out.println("Projeto: " + projeto);
    }
}

class Programador extends Funcionario {
    private String linguagemProgramacao;

    public Programador(String nome, LocalDate dataNascimento, double salario, String linguagemProgramacao) {
        super(nome, dataNascimento, salario);
        this.linguagemProgramacao = linguagemProgramacao;
    }

    public void informarLinguagem() {
        System.out.println("Linguagem de Programação: " + linguagemProgramacao);
    }
}

public class Main {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("João Silva", LocalDate.of(1985, 5, 15), 3000.0);
        Gerente gerente = new Gerente("Maria Oliveira", LocalDate.of(1978, 8, 22), 8000.0, "Projeto X");
        Programador programador = new Programador("Carlos Souza", LocalDate.of(1990, 12, 10), 5000.0, "Java");

        funcionario.exibirDados();
        System.out.println();

        gerente.exibirDados();
        gerente.informarProjeto();
        System.out.println();

        programador.exibirDados();
        programador.informarLinguagem();
    }
}
