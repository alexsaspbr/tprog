package Exercicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ex1 {
    public static void main(String[] args) {
        LocalDate dataAtual = java.time.LocalDate.now();
        int dia = dataAtual.getDayOfMonth();
        int mes = dataAtual.getMonthValue();
        int ano = dataAtual.getYear();
        System.out.printf("dia: %d\nmes: %d\nano: %d\n", dia, mes, ano);

        LocalDate novaData = dataAtual.plusDays(10);
        System.out.println("Data + 10 dias: " + novaData.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
