package Exercicio4_Duration;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercicio4_Duration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

        System.out.println("⏱️  EXERCÍCIO 4 - Medindo tempo com Duration");
        System.out.println("=" .repeat(50));

        LocalTime horaInicial = LocalTime.now();
        System.out.println("🚀 Cronômetro iniciado!");
        System.out.println("📍 Hora inicial: " + horaInicial.format(formatoHora));

        System.out.println("\n⏳ Pressione ENTER para parar o cronômetro...");
        System.out.println("💭 (Aguarde alguns segundos para ver uma diferença interessante)");
        scanner.nextLine();

        LocalTime horaFinal = LocalTime.now();
        System.out.println("🏁 Cronômetro parado!");
        System.out.println("📍 Hora final: " + horaFinal.format(formatoHora));

        Duration duracao = Duration.between(horaInicial, horaFinal);

        System.out.println("\n📊 TEMPO DECORRIDO:");
        System.out.println("   ⏰ Segundos: " + duracao.getSeconds() + " segundos");
        System.out.println("   ⏰ Nanossegundos: " + duracao.getNano() + " nanossegundos");

        System.out.println("\n📏 CONVERSÕES:");
        System.out.println("   • Em milissegundos: " + duracao.toMillis() + " ms");
        System.out.println("   • Em nanossegundos total: " + duracao.toNanos() + " ns");

        long segundosTotais = duracao.getSeconds();
        long minutos = segundosTotais / 60;
        long segundosRestantes = segundosTotais % 60;
        long milissegundos = duracao.toMillis() % 1000;

        System.out.println("\n🕐 FORMATO LEGÍVEL:");
        if (minutos > 0) {
            System.out.println("   " + minutos + " min, " + segundosRestantes + " seg, " + milissegundos + " ms");
        } else {
            System.out.println("   " + segundosRestantes + " seg, " + milissegundos + " ms");
        }

        System.out.println("\n🎯 ANÁLISE:");
        if (duracao.getSeconds() < 1) {
            System.out.println("   ⚡ Você foi muito rápido! Tempo de reação excelente!");
        } else if (duracao.getSeconds() < 3) {
            System.out.println("   🏃 Tempo de reação normal!");
        } else if (duracao.getSeconds() < 10) {
            System.out.println("   🤔 Você pensou um pouquinho antes de pressionar ENTER!");
        } else {
            System.out.println("   🐢 Você realmente tomou seu tempo... Muito relaxante!");
        }

        if (duracao.toMillis() > 0) {
            long batimentosCardiaco = duracao.getSeconds(); // Aproximadamente 1 batimento por segundo
            System.out.println("   💓 Nesse tempo, seu coração bateu aproximadamente " + batimentosCardiaco + " vezes!");
        }

        scanner.close();
    }
}
