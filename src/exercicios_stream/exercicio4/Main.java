package exercicios_stream.exercicio4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numerosInteiros = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            numerosInteiros.add(i);
        }

        int soma = somarTodosOsNumeros(numerosInteiros);

        System.out.println("Soma dos elementos: " + soma);
    }

    public static int somarTodosOsNumeros(List<Integer> numerosInteiros) {
        return numerosInteiros.stream().reduce(0, Integer::sum);
    }
}
