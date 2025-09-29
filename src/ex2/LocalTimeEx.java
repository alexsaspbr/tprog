package ex2;

import java.time.LocalTime;

public class LocalTimeEx {
    public static void main(String[] args) {
        LocalTime horaAtual = LocalTime.now();
        System.out.println("Hora atual: " + horaAtual);

        LocalTime horaModificada = horaAtual.plusHours(2).plusMinutes(30);
        System.out.println("Hora depois de adicionar 2h30: " + horaModificada);
    }
}
