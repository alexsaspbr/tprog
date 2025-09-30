import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Exercicio05 {
    public static void main(String[] args) {
        System.out.println("EXERCÍCIO 5 – Desafio Final: Agendamento com ZonedDateTime");
        System.out.println("============================================================");
        
        // Criar um evento para 15 de outubro de 2025 às 14:00 no fuso horário de São Paulo
        LocalDate dataEvento = LocalDate.of(2025, 10, 15);
        LocalTime horaEvento = LocalTime.of(14, 0);
        ZonedDateTime eventoSaoPaulo = ZonedDateTime.of(dataEvento, horaEvento, ZoneId.of("America/Sao_Paulo"));
        
        System.out.println("Evento em São Paulo: " + eventoSaoPaulo);
        System.out.println();
        
        // Converter para outros fusos horários
        ZonedDateTime eventoNovaYork = eventoSaoPaulo.withZoneSameInstant(ZoneId.of("America/New_York"));
        ZonedDateTime eventoTokyo = eventoSaoPaulo.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        ZonedDateTime eventoLondres = eventoSaoPaulo.withZoneSameInstant(ZoneId.of("Europe/London"));
        
        // Exibir os horários equivalentes
        System.out.println("Horários equivalentes:");
        System.out.println("Nova York: " + eventoNovaYork);
        System.out.println("Tóquio: " + eventoTokyo);
        System.out.println("Londres: " + eventoLondres);
        
        // Formatação mais clara
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println();
        System.out.println("Formato mais claro:");
        System.out.println("São Paulo: " + eventoSaoPaulo.format(formatter));
        System.out.println("Nova York: " + eventoNovaYork.format(formatter));
        System.out.println("Tóquio: " + eventoTokyo.format(formatter));
        System.out.println("Londres: " + eventoLondres.format(formatter));
    }
}
