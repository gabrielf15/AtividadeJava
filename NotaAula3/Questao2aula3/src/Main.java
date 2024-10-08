abstract class Animal {
    protected String nome;
    protected String raca;

    public Animal(String nome, String raca) {
        this.nome = nome;
        this.raca = raca;
    }

    public void mostrarDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Raça: " + raca);
    }

    public void caminha() {
        System.out.println(nome + " está caminhando.");
    }
}

class Cachorro extends Animal {
    public Cachorro(String nome) {
        super(nome, "Cachorro");
    }

    public void late() {
        System.out.println(nome + " está latindo: Au Au!");
    }
}

class Gato extends Animal {
    public Gato(String nome) {
        super(nome, "Gato");
    }

    public void mia() {
        System.out.println(nome + " está miando: Miau!");
    }
}

public class Main {
    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro("Rex");
        Gato gato = new Gato("Mimi");

        cachorro.mostrarDados();
        cachorro.caminha();
        cachorro.late();

        System.out.println();

        gato.mostrarDados();
        gato.caminha();
        gato.mia();
    }
}
