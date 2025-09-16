package Exercicio2_LocalTime;

import java.time.format.DateTimeFormatter;

public class LocalTime {

    public static void main(String[] args) {
        System.out.println("🕐 EXERCÍCIO 2 - Usando LocalTime");
        System.out.println("=" .repeat(50));

        java.time.LocalTime horaAtual = java.time.LocalTime.now();
        System.out.println("⏰ Hora atual do sistema: " + horaAtual);

        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("🎯 Hora formatada: " + horaAtual.format(formatoHora));

        System.out.println("\n📍 Componentes do horário:");
        System.out.println("   • Hora: " + horaAtual.getHour() + "h");
        System.out.println("   • Minutos: " + horaAtual.getMinute() + "min");
        System.out.println("   • Segundos: " + horaAtual.getSecond() + "s");

        java.time.LocalTime horaFutura = horaAtual.plusHours(2).plusMinutes(30);

        System.out.println("\n📝 COMPARAÇÃO:");
        System.out.println("   • ANTES: " + horaAtual.format(formatoHora));
        System.out.println("   • DEPOIS (+2h 30min): " + horaFutura.format(formatoHora));

        System.out.println("\n📊 Detalhes da operação:");
        System.out.println("   • Horas adicionadas: 2h");
        System.out.println("   • Minutos adicionados: 30min");
        System.out.println("   • Total adicionado: 2h 30min");

        if (horaFutura.isBefore(horaAtual)) {
            System.out.println("   ⚠️ Atenção: A hora futura passou da meia-noite!");
        }


        int hora = horaAtual.getHour();
        String periodo;
        if (hora >= 6 && hora < 12) {
            periodo = "Manhã";
        } else if (hora >= 12 && hora < 18) {
            periodo = "Tarde";
        } else if (hora >= 18 && hora < 24) {
            periodo = "Noite";
        } else {
            periodo = "Madrugada";
        }

        System.out.println("   🌅 Período do dia: " + periodo);
    }
}
