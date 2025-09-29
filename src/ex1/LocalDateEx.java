package ex1;
import java.time.LocalDate;

public class LocalDateEx {
    public static void main(String[] args) {
        LocalDate dataAtual = LocalDate.now();

        System.out.println("Data atual: " + dataAtual);
        System.out.println("Dia: " + dataAtual.getDayOfMonth());
        System.out.println("Mês: " + dataAtual.getMonthValue());
        System.out.println("Ano: " + dataAtual.getYear());

        LocalDate maisDezDias = dataAtual.plusDays(10);
        System.out.println("Data +10 dias: " + maisDezDias);
    }
}
