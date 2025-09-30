package Exercicio2;

public class Principal {
    public static void main(String[] args) {

        // Lambda que formata e exibe a mensagem
        Mensagem msg = texto -> System.out.println("[MENSAGEM]: " + texto);

        // Testando
        msg.exibir("Olá, mundo!");
        msg.exibir("Programando com lambdas em Java.");
        msg.exibir("Interfaces funcionais são muito úteis!");
    }
}
