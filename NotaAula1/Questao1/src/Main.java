import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita o nome do aluno
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        // Solicita as notas do aluno
        System.out.print("Digite a primeira nota: ");
        double nota1 = scanner.nextDouble();
        System.out.print("Digite a segunda nota: ");
        double nota2 = scanner.nextDouble();
        System.out.print("Digite a terceira nota: ");
        double nota3 = scanner.nextDouble();

        // Calcula a média
        double media = (nota1 + nota2 + nota3) / 3;

        // Determina a situação acadêmica
        String situacao;
        if (media >= 7) {
            situacao = "Aprovado";
        } else if (media < 4) {
            situacao = "Reprovado";
        } else {
            situacao = "Final";
        }
        String mediaformat = String.format("%.2f", media);
        // Exibe o resultado
        System.out.println("Aluno: " + nome);
        System.out.println("Média: " + mediaformat);
        System.out.println("Situação: " + situacao);

        scanner.close();
    }
}