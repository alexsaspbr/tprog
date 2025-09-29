package ex3;

import java.time.LocalDate;
import java.time.Period;

public class PeriodEx {
    public static void main(String[] args) {
        LocalDate nascimento1 = LocalDate.of(1995, 5, 20);
        LocalDate nascimento2 = LocalDate.of(2000, 10, 15);

        Period diferenca = Period.between(nascimento1, nascimento2);

        System.out.printf("Diferença: %d anos, %d meses e %d dias%n",
                diferenca.getYears(),
                diferenca.getMonths(),
                diferenca.getDays());
    }
}
