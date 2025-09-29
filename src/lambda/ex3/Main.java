package lambda.ex3;

public class Main {
    public static void main(String[] args) {

        // 1. Verificar se uma string não está vazia
        Validador<String> naoVazia = s -> s != null && !s.trim().isEmpty();

        // 2. Verificar se um número é positivo
        Validador<Integer> numeroPositivo = n -> n != null && n > 0;

        // 3. Verificar se uma senha tem pelo menos 8 caracteres e contém um número
        Validador<String> senhaValida = senha ->
                senha != null &&
                        senha.length() >= 8 &&
                        senha.matches(".*\\d.*"); // regex: contém pelo menos um dígito

        System.out.println("String não vazia:");
        System.out.println("'' -> " + naoVazia.validar(""));
        System.out.println("'Java' -> " + naoVazia.validar("Java"));
        System.out.println();

        System.out.println("Número positivo:");
        System.out.println("-10 -> " + numeroPositivo.validar(-10));
        System.out.println("42 -> " + numeroPositivo.validar(42));
        System.out.println();

        System.out.println("Senha válida:");
        System.out.println("'abc' -> " + senhaValida.validar("abc"));
        System.out.println("'segredo123' -> " + senhaValida.validar("segredo123"));
    }
}
