import java.time.*;
import java.time.format.DateTimeFormatter;

public class DesafioAgendamento {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dataEvento = LocalDateTime.of(2025, 10, 15, 14, 0);
    ZonedDateTime spTimeZone = ZonedDateTime.of(dataEvento, ZoneId.of("America/Sao_Paulo"));

    System.out.println("Data e hora em São Paulo: " + formatter.format(spTimeZone));
        ZonedDateTime nyTimeZone = spTimeZone.withZoneSameInstant(ZoneId.of("America/New_York"));
    System.out.println("Data e hora em Nova York: " + formatter.format(nyTimeZone));
        ZonedDateTime tokyoTimeZone = spTimeZone.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
    System.out.println("Data e hora em Tóquio: " + formatter.format(tokyoTimeZone));
        ZonedDateTime londonTimeZone = spTimeZone.withZoneSameInstant(ZoneId.of("Europe/London"));
    System.out.println("Data e hora em Londres: " + formatter.format(londonTimeZone));
  }

}
