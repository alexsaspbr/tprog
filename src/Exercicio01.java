import java.time.LocalDate;

public class Exercicio01 {
    public static void main(String[] args) {
        System.out.println("EXERCÍCIO 1 – Trabalhando com LocalDate");
        System.out.println("==========================================");
        
        // Obter a data atual do sistema
        LocalDate dataAtual = LocalDate.now();
        System.out.println("Data atual: " + dataAtual);
        
        // Mostrar o dia, mês e ano separadamente
        System.out.println("Dia: " + dataAtual.getDayOfMonth());
        System.out.println("Mês: " + dataAtual.getMonthValue());
        System.out.println("Ano: " + dataAtual.getYear());
        
        // Adicionar 10 dias à data atual e exibir o resultado
        LocalDate dataMais10Dias = dataAtual.plusDays(10);
        System.out.println("Data atual + 10 dias: " + dataMais10Dias);
    }
}
