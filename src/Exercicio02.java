import java.time.LocalTime;

public class Exercicio02 {
    public static void main(String[] args) {
        System.out.println("EXERCÍCIO 2 – Usando LocalTime");
        System.out.println("================================");
        
        // Mostrar a hora atual do sistema
        LocalTime horaAtual = LocalTime.now();
        System.out.println("Hora atual: " + horaAtual);
        
        // Adicionar 2 horas e 30 minutos ao horário atual
        LocalTime horaModificada = horaAtual.plusHours(2).plusMinutes(30);
        System.out.println("Hora após adicionar 2h30min: " + horaModificada);
    }
}
