package Exercicios;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Ex5 {
    public static void main(String[] args) {
        LocalDateTime data = LocalDateTime.of(2025, 10, 15, 14,0);
        ZoneId zone = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime evento = ZonedDateTime.of(data, zone);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        ZonedDateTime eventoNY = evento.withZoneSameInstant(ZoneId.of("America/New_York"));
        ZonedDateTime eventoTokyo = evento.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        ZonedDateTime eventoLondon = evento.withZoneSameInstant(ZoneId.of("Europe/London"));

        System.out.println("Evento em São Paulo: " + evento.format(formato));
        System.out.println("Evento em Nova York: " + eventoNY.format(formato));
        System.out.println("Evento em Tóquio: " + eventoTokyo.format(formato));
        System.out.println("Evento em Londres: " + eventoLondon.format(formato));

    }
}
