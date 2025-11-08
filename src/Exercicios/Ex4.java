package Exercicios;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        LocalTime agora = LocalTime.now();
        Scanner ler = new Scanner(System.in);
        System.out.println("Pressione Enter para continuar...");
        ler.nextLine();
        LocalTime agora2 = LocalTime.now();
        Duration duracao = Duration.between(agora, agora2);
        System.out.printf("Tempo decorrido: %d s %d ns\n", duracao.getSeconds(), duracao.getNano());
    }
}
