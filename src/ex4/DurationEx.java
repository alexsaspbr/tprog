package ex4;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class DurationEx {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalTime inicio = LocalTime.now();
        System.out.println("Pressione ENTER para continuar...");
        scanner.nextLine();

        LocalTime fim = LocalTime.now();

        Duration duracao = Duration.between(inicio, fim);

        System.out.println("Tempo decorrido: " + duracao.getSeconds() + " segundos");
        System.out.println("Tempo exato em nanos: " + duracao.toNanos() + " nanossegundos");
    }
}
