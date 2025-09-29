package lambda.ex1;

public class Main {
    public static void main(String[] args) {

        // 1. Converter para maiúsculas
        Conversor maiusculas = texto -> texto.toUpperCase();

        // 2. Inverter caracteres da string
        Conversor inverter = texto -> new StringBuilder(texto).reverse().toString();

        // Testando as implementações
        String original1 = "programação";
        String original2 = "java é top";

        System.out.println("Texto original 1: " + original1);
        System.out.println("Maiúsculas: " + maiusculas.converter(original1));
        System.out.println("Invertido: " + inverter.converter(original1));

        System.out.println();

        System.out.println("Texto original 2: " + original2);
        System.out.println("Maiúsculas: " + maiusculas.converter(original2));
        System.out.println("Invertido: " + inverter.converter(original2));
    }
}

