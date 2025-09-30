import java.time.LocalDate;
import java.time.Period;

public class Exercicio03 {
    public static void main(String[] args) {
        System.out.println("EXERCÍCIO 3 – Diferença entre datas (Period)");
        System.out.println("============================================");
        
        // Duas datas de nascimento fixas
        LocalDate data1 = LocalDate.of(1990, 5, 15);
        LocalDate data2 = LocalDate.of(1985, 8, 20);
        
        System.out.println("Data 1: " + data1);
        System.out.println("Data 2: " + data2);
        
        // Calcular a diferença usando Period
        Period diferenca = Period.between(data2, data1);
        
        // Exibir o resultado de forma clara
        System.out.println("Diferença: " + diferenca.getYears() + " anos, " + 
                          diferenca.getMonths() + " meses e " + 
                          diferenca.getDays() + " dias");
    }
}
