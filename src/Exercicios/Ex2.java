package Exercicios;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ex2 {
    public static void main(String[] args) {
        LocalTime horaAtual = LocalTime.now();
        LocalTime novaHora = horaAtual.plusHours(2).plusMinutes(30);
        System.out.printf("Hora atual: %s\nHora + 2h30m: %s\n", horaAtual.format(DateTimeFormatter.ofPattern("HH:mm")),
                novaHora.format(DateTimeFormatter.ofPattern("HH:mm")));
    }
}
