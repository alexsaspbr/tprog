import java.time.*;
import java.time.format.DateTimeFormatter;
public class exercicios {
  public static void main(String[] args) {


    //EXERCICIO 1
    LocalDate dataAtual = LocalDate.now();
    System.out.println("dia: " + dataAtual.getDayOfMonth());
    System.out.println("mês: " + dataAtual.getMonthValue());
    System.out.println("ano: " + dataAtual.getYear());

    LocalDate novaData = dataAtual.plusDays(10);
    System.out.println("Nova data: " + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(novaData));

    //EXERCICIO 2
    LocalTime horaAtual = LocalTime.now();
    System.out.println("Hora atual: " + horaAtual);
    LocalTime novaHora = horaAtual.plusHours(2).plusMinutes(30);
    System.out.println("Nova hora: " + novaHora);
  }

}
