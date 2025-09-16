package Exercicio3_Period;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Period {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatoBrasileiro = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("📊 EXERCÍCIO 3 - Diferença entre datas (Exercicio3_Period.Period)");
        System.out.println("=" .repeat(50));


        System.out.println("Escolha uma opção:");
        System.out.println("1 - Usar datas de exemplo fixas");
        System.out.println("2 - Inserir datas personalizadas");
        System.out.print("Digite sua escolha (1 ou 2): ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        LocalDate nascimento1, nascimento2;

        if (opcao == 1) {

            nascimento1 = LocalDate.of(1990, 5, 15);
            nascimento2 = LocalDate.of(1995, 8, 22);

            System.out.println("\n📋 Usando datas de exemplo:");
        } else {

            System.out.println("\n📝 Digite as datas no formato dd/MM/yyyy:");

            System.out.print("Data de nascimento 1: ");
            String data1 = scanner.nextLine();
            nascimento1 = LocalDate.parse(data1, formatoBrasileiro);

            System.out.print("Data de nascimento 2: ");
            String data2 = scanner.nextLine();
            nascimento2 = LocalDate.parse(data2, formatoBrasileiro);
        }


        System.out.println("👤 Pessoa 1 nasceu em: " + nascimento1.format(formatoBrasileiro));
        System.out.println("👤 Pessoa 2 nasceu em: " + nascimento2.format(formatoBrasileiro));


        java.time.Period diferenca = java.time.Period.between(nascimento1, nascimento2);

        int anos = Math.abs(diferenca.getYears());
        int meses = Math.abs(diferenca.getMonths());
        int dias = Math.abs(diferenca.getDays());


        System.out.println("\n🔢 RESULTADO:");
        System.out.println("Diferença: " + anos + " anos, " + meses + " meses e " + dias + " dias");


        System.out.println("\n📊 Análise detalhada:");


        if (nascimento1.isBefore(nascimento2)) {
            System.out.println("   • Pessoa 1 é mais velha");
        } else if (nascimento2.isBefore(nascimento1)) {
            System.out.println("   • Pessoa 2 é mais velha");
        } else {
            System.out.println("   • Ambas nasceram na mesma data!");
        }

        LocalDate hoje = LocalDate.now();
        java.time.Period idade1 = java.time.Period.between(nascimento1, hoje);
        java.time.Period idade2 = java.time.Period.between(nascimento2, hoje);

        System.out.println("\n🎂 Idades atuais:");
        System.out.println("   • Pessoa 1: " + idade1.getYears() + " anos, "
                + idade1.getMonths() + " meses e "
                + idade1.getDays() + " dias");
        System.out.println("   • Pessoa 2: " + idade2.getYears() + " anos, "
                + idade2.getMonths() + " meses e "
                + idade2.getDays() + " dias");


        long diasTotais = Math.abs(nascimento1.toEpochDay() - nascimento2.toEpochDay());
        System.out.println("\n📏 Diferença total aproximada: " + diasTotais + " dias");

        scanner.close();
    }
}
