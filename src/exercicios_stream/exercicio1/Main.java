package exercicios_stream.exercicio1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numerosInteiros = new ArrayList<>();

        for (int i = 0; i <= 50; i++) {
            numerosInteiros.add(i);
        }

        filtrarNumerosPares(numerosInteiros);
    }

    public static void filtrarNumerosPares(List<Integer> numerosInteiros) {
        numerosInteiros.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
    }
}
