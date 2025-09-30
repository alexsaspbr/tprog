package Exercicio1;

public class Principal {
    public static void main(String[] args) {

        // Converter para maiúsculas
        Conversor paraMaiusculas = texto -> texto.toUpperCase();

        // Inverter os caracteres da string
        Conversor inverter = texto -> new StringBuilder(texto).reverse().toString();

        // Testando as implementações
        String exemplo1 = "java";
        String exemplo2 = "Lambda";
        String exemplo3 = "Interface Funcional";

        System.out.println("Texto original: " + exemplo1);
        System.out.println("Maiúsculas: " + paraMaiusculas.converter(exemplo1));
        System.out.println("Invertido: " + inverter.converter(exemplo1));

        System.out.println("\nTexto original: " + exemplo2);
        System.out.println("Maiúsculas: " + paraMaiusculas.converter(exemplo2));
        System.out.println("Invertido: " + inverter.converter(exemplo2));

        System.out.println("\nTexto original: " + exemplo3);
        System.out.println("Maiúsculas: " + paraMaiusculas.converter(exemplo3));
        System.out.println("Invertido: " + inverter.converter(exemplo3));
    }
}


