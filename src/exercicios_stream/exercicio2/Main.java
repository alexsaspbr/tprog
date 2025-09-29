package exercicios_stream.exercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();

        nomes.add("Pedro");
        nomes.add("Maria");
        nomes.add("Rafael");
        nomes.add("Antonio");
        nomes.add("Ana");
        nomes.add("Paula");
        nomes.add("Guilherme");

        transformarNomesEmMaiusculos(nomes);
    }

    public static void transformarNomesEmMaiusculos(List<String> nomes) {
        nomes.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
