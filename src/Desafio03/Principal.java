package Desafio03;

public class Principal {
    public static void main(String[] args) {

        // Verificar se uma string não está vazia
        Validador<String> stringNaoVazia = s -> s != null && !s.trim().isEmpty();

        // Verificar se um número é positivo
        Validador<Integer> numeroPositivo = n -> n != null && n > 0;

        // Verificar se a senha tem pelo menos 8 caracteres e contém um número
        Validador<String> senhaValida = senha -> {
            if (senha == null || senha.length() < 8) return false;
            return senha.matches(".*\\d.*"); // regex: contém pelo menos um dígito
        };

        // Testando os validadores
        System.out.println("String 'Java': " + stringNaoVazia.validar("Java"));
        System.out.println("String '   ': " + stringNaoVazia.validar("   "));
        System.out.println("Número 10: " + numeroPositivo.validar(10));
        System.out.println("Número -5: " + numeroPositivo.validar(-5));
        System.out.println("Senha 'abc123': " + senhaValida.validar("abc123"));
        System.out.println("Senha 'Segura123': " + senhaValida.validar("Segura123"));
    }
}
