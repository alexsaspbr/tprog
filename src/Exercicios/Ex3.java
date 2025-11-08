package Exercicios;

import java.time.LocalDate;
import java.time.Period;

public class Ex3 {
    public static void main(String[] args) {
        LocalDate myBday = LocalDate.of(1987, 3, 21);
        LocalDate wifeBday = LocalDate.of(1988, 6, 10);
        Period diferenca = Period.between(myBday, wifeBday);
        System.out.printf("Diferença: %d anos, %d meses e %d dias\n", diferenca.getYears(), diferenca.getMonths(), diferenca.getDays());
    }
}
