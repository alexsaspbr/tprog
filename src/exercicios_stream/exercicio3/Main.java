package exercicios_stream.exercicio3;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> decimais = Arrays.asList(10.5, 3.2, 7.8, 1.1, 9.9);

        ordenarELimitarResultado(decimais, 3);
    }

    public static void ordenarELimitarResultado(List<Double> decimais, int limit) {
        decimais.stream().sorted().limit(limit).forEach(System.out::println);
    }
}
