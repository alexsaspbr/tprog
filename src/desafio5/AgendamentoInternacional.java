package desafio5;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class AgendamentoInternacional {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm z");

        // Evento em São Paulo
        ZonedDateTime eventoSaoPaulo = ZonedDateTime.of(
                2025, 10, 15, 14, 0, 0, 0,
                ZoneId.of("America/Sao_Paulo")
        );

        //  Converter para outros fusos
        ZonedDateTime eventoNovaYork = eventoSaoPaulo.withZoneSameInstant(ZoneId.of("America/New_York"));
        ZonedDateTime eventoToquio = eventoSaoPaulo.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        ZonedDateTime eventoLondres = eventoSaoPaulo.withZoneSameInstant(ZoneId.of("Europe/London"));

        // Exibir horários
        System.out.println("Agendamento Internacional");
        System.out.println("Evento em São Paulo: " + eventoSaoPaulo.format(formatter));
        System.out.println("Horário em Nova Iorque: " + eventoNovaYork.format(formatter));
        System.out.println("Horário em Tóquio: " + eventoToquio.format(formatter));
        System.out.println("Horário em Londres: " + eventoLondres.format(formatter));
    }
}
