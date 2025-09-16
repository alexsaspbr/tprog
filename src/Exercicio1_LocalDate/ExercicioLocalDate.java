package Exercicio1_LocalDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExercicioLocalDate {

    public static void main(String[] args) {
        System.out.println("🗓️  EXERCÍCIO 1 - Trabalhando com LocalDate");
        System.out.println("=" .repeat(50));

        LocalDate dataAtual = LocalDate.now();
        System.out.println("📅 Data atual: " + dataAtual);

        int dia = dataAtual.getDayOfMonth();
        int mes = dataAtual.getMonthValue();
        int ano = dataAtual.getYear();

        System.out.println("\n📍 Componentes da data:");
        System.out.println("   • Dia: " + dia);
        System.out.println("   • Mês: " + mes);
        System.out.println("   • Ano: " + ano);

        LocalDate dataFutura = dataAtual.plusDays(10);
        System.out.println("\n⏭️  Data após adicionar 10 dias:");
        System.out.println("   • Formato padrão: " + dataFutura);


        DateTimeFormatter formatoBrasileiro = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("   • Formato brasileiro: " + dataFutura.format(formatoBrasileiro));

        System.out.println("\n📊 Informações extras:");
        System.out.println("   • Dia da semana atual: " + dataAtual.getDayOfWeek());
        System.out.println("   • Dia da semana (+10 dias): " + dataFutura.getDayOfWeek());
        System.out.println("   • Mês atual por extenso: " + dataAtual.getMonth());
    }
}
