import java.time.LocalTime;
import java.time.Duration;
import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        System.out.println("EXERCÍCIO 4 – Medindo tempo com Duration");
        System.out.println("=========================================");
        
        Scanner scanner = new Scanner(System.in);
        
        // Capturar a hora atual
        LocalTime horaInicio = LocalTime.now();
        System.out.println("Hora inicial: " + horaInicio);
        
        // Esperar o usuário pressionar ENTER
        System.out.println("Pressione ENTER para continuar...");
        scanner.nextLine();
        
        // Capturar novamente a hora
        LocalTime horaFim = LocalTime.now();
        System.out.println("Hora final: " + horaFim);
        
        // Calcular o tempo decorrido usando Duration
        Duration duracao = Duration.between(horaInicio, horaFim);
        
        // Exibir o resultado em segundos e nanos
        System.out.println("Tempo decorrido: " + duracao.getSeconds() + " segundos e " + 
                          duracao.getNano() + " nanossegundos");
        
        scanner.close();
    }
}
