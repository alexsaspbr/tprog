package Exercicio2Lambda;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Exercicio2 {
    public static void main(String[] args) {
        System.out.println("EXERCÍCIO 2 - Interface Mensagem");
        System.out.println("=".repeat(50));

        Mensagem mensagemFormatada = texto -> {
            System.out.println("[MENSAGEM:]" + texto);
        };

        System.out.println("Testando Mensagem Formatada:\n");

        String[] mensagens = {
                "Olá Mundo",
                "Java é uma linguagem poderosa",
                "Lambdas tornam o código mais limpo",
                "Interface Funcional em ação",
                "Programação funcional em Java"
        };

        for (String msg : mensagens) {
            mensagemFormatada.exibir(msg);
        }

        System.out.println("\n" + "=".repeat(50));

        System.out.println("OUTROS EXEMPLOS DE FORMATAÇÃO:\n");

        Mensagem mensagemComHora = texto -> {
            LocalTime agora = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            System.out.println("[" + agora.format(formatter) + "]" + texto);
        };

        Mensagem mensagemCaixa = texto -> {
            String borda = "+" + "-".repeat(texto.length() + 2) + "+";
            System.out.println(borda);
            System.out.println("| " + texto + "|");
            System.out.println(borda);
        };

        Mensagem mensagemColorida = texto -> {
            String RESET = "\u001B[0m";
            String GREEN = "\u001B[32m";
            String BLUE = "\u001B[34m";
            System.out.println(GREEN + "[INFO]" + RESET + " " + BLUE + texto + RESET);

        };

        Mensagem mensagemPrioridade = texto -> {
            String prioridade = texto.toUpperCase().contains("ERRO") ? "ALTA" :
                    texto.toUpperCase().contains("AVISO") ? "MÉDIA" : "BAIXA";
            System.out.println("[PRIORIDADE: " + prioridade + "]" + texto);
        };

        String mensagemTeste = "Sistema funcionando corretamente";

        System.out.println("Com timestamp:");
        mensagemComHora.exibir(mensagemTeste);

        System.out.println("\n Em caixa:");
        mensagemCaixa.exibir(mensagemTeste);

        System.out.println("\n Colorida:");
        mensagemColorida.exibir(mensagemTeste);

        System.out.println("\n Prioridade:");
        mensagemPrioridade.exibir("AVISO: Memória baixa");
        mensagemPrioridade.exibir("ERRO: Falha na conexão");
        mensagemPrioridade.exibir("Sistema inicializado");

        System.out.println("\n" + "=".repeat(50));
        System.out.println("EXEMPLO PRÁTICO - LOGGER SIMPLES:\n");

        criarLogger().exibir("Aplicação iniciada");
        criarLogger().exibir("Usuário logado: admin");
        criarLogger().exibir("Operação concluída com sucesso");

    }

    private static Mensagem criarLogger() {
        return texto -> {
            LocalDateTime agora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            String nivel = determinarNivel(texto);
            String formatada = String.format("[%s] [%s] %s", agora.format(formatter), nivel, texto);
            System.out.println(formatada);
        };
    }

    private static String determinarNivel(String texto) {
        String textoUpper = texto.toUpperCase();
        if (textoUpper.contains("ERRO") || textoUpper.contains("ERROR")) {
            return "ERROR";
        } else if (textoUpper.contains("AVISO") || textoUpper.contains("WARN")) {
            return "WARN";
        } else if (textoUpper.contains("DEBUG")){
            return "DEBUG";
        } else {
            return "INFO";
        }
    }
}
