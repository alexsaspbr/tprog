package desafio;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class AgendamentoInternacional {

    public static void main(String[] args) {


        LocalDateTime dataHoraSaoPaulo = LocalDateTime.of(2025, 10, 15, 14, 0);
        ZoneId fusoSaoPaulo = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime eventoSaoPaulo = ZonedDateTime.of(dataHoraSaoPaulo, fusoSaoPaulo);

        ZoneId fusoNovaIorque = ZoneId.of("America/New_York");
        ZoneId fusoToquio = ZoneId.of("Asia/Tokyo");
        ZoneId fusoLondres = ZoneId.of("Europe/London");

        ZonedDateTime eventoNovaIorque = eventoSaoPaulo.withZoneSameInstant(fusoNovaIorque);
        ZonedDateTime eventoToquio = eventoSaoPaulo.withZoneSameInstant(fusoToquio);
        ZonedDateTime eventoLondres = eventoSaoPaulo.withZoneSameInstant(fusoLondres);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm:ss");

        System.out.println("--- Agendamento internacional ---");
        System.out.println("Evento em Sao Paulo: " + eventoSaoPaulo.format(formatador) + " ( " + fusoSaoPaulo + ")");
        System.out.println("Horário em Nova Iorque: " + eventoNovaIorque.format(formatador) + " (" + fusoNovaIorque + ")");
        System.out.println("Horário em Toquio: " + eventoToquio.format(formatador) + " (" + fusoToquio + ")");
        System.out.println("Horario em Londres : " + eventoLondres.format(formatador) + " (" + fusoLondres + ")");

    }
}