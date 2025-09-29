package lambda.ex2;

public class Main {
    public static void main(String[] args) {

      Mensagem mensagemFormatada = texto ->
                System.out.println("[MENSAGEM]: " + texto);

       mensagemFormatada.exibir("Olá, mundo!");
        mensagemFormatada.exibir("Java com lambda é top!");
    }
}

