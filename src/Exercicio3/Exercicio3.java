package Exercicio3;

public class Exercicio3 {
    public static void main(String[] args) {
        System.out.println("EXERCÍCIO 3 - Interface Conversor");
        System.out.println("=".repeat(60));

        Validador<String> validadorStringNaoVazia = texto ->
            texto != null && !texto.trim().isEmpty();

        Validador<Number> validadorNumeroPositivo = numero ->
                numero != null && numero.doubleValue() > 0;

        Validador<String> validadorSenha = senha -> {
            if (senha == null || senha.length() < 8) {
                return false;
            }
            return senha.matches(".*\\d.*");
        };

        System.out.println("TESTE 1 - string não vazia:");
        System.out.println("-".repeat(40));

        String[] textos = {
                "Hello World",
                "",
                null,
                "Java",
                "A"
        };

        for (String texto : textos) {
            String exbicao = texto == null ? "null" : "\"" + texto + "\"";
            boolean valido = validadorStringNaoVazia.validar(texto);
            System.out.println(String.format("%-15s -> %s %s",
                                exbicao,
                                valido ? "✅" : "❌",
                                valido ? "VÁLIDO" : "INVÁLIDO"));
        }

        System.out.println("\n TESTE 2 - Número positivo:");
        System.out.println("-".repeat(40));

        Number[] numeros = {
                10,
                -5,
                0,
                3.14,
                -2.5,
                100,
                null
        };
        for (Number numero : numeros) {
            String exibicao = numero == null ? "null" : numero.toString();
            boolean valido = validadorNumeroPositivo.validar(numero);
            System.out.println(String.format("%-10s -> %s %s",
                    exibicao,
                    valido ? "✅" : "❌",
                    valido ? "VÁLIDO" : "INVÁLIDO"));
        }

        System.out.println("\n TESTE3 - senha(>=8 caracteres + números)");
        System.out.println("-".repeat(50));

        String[] senhas = {
                "password123",
                "abc",
                "password",
                "12345678",
                "",
                "shortpw",
                null,
                "LongPasswordWithoutNumbers"
        };

        for (String senha : senhas) {
            String exibicao = senha == null ? "null" : "\"" + senha + "\"";
            boolean valido = validadorSenha.validar(senha);
            String motivo = "";

            if (!valido && senha != null) {
                if (senha.length() < 8) {
                    motivo = "(muito curta)";
                } else if (!senha.matches(".*\\d.*")) {
                    motivo = "(sem números)";
                }
            } else if (!valido && senha == null) {
                motivo = "(nulo)";
            }

            System.out.println(String.format("%-35s -> %s %s %s",
                    exibicao,
                    valido ? "✅" : "❌",
                    valido ? "VÁLIDA" : "INVÁLIDA",
                    motivo));
        }

        System.out.println("\n" + "=".repeat(60));
        System.out.println("EXEMPLOS ADICIONAIS - Outros validadores:\n");
        System.out.println("=".repeat(60));

        Validador<String> validadorEmail = email ->
            email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");

        Validador<Integer> validadorIdade = idade ->
            idade != null && idade >= 0 && idade <= 150;

        Validador<String> validadorCPF = cpf ->
            cpf != null && cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");

        Validador<String> validadorNome = nome ->
                validadorStringNaoVazia.validar(nome) &&
                nome.matches("^[a-zA-ZÀ-ÿ\\s]+$");

        System.out.println("\n Validador de Email: ");
        String[] emails = {"user@example.com", "invalid-email", "test@test.co"};
        testarValidador(validadorEmail, emails);

        System.out.println("\nValidador de Idade: ");
        Integer[] idades = {25, -5, 150, 200, null};
        testarValidador(validadorIdade, idades);

        System.out.println("\nValidador de CPF: ");
        String[] cpfs = {"123.456.789-00", "12345678900", "123.456.789-0"};
        testarValidador(validadorCPF, cpfs);

        System.out.println("\nValidador de Nome: ");
        String[] nomes = {"João Silva", "123Nome", "Maria", "Jose123"};
        testarValidador(validadorNome, nomes);

        System.out.println("\n COMBINANDO VALIDADORES:");
        System.out.println("-".repeat(40));

        Validador<String> validadorSenhaSegura = senha ->
                validadorSenha.validar(senha) &&
                senha.matches(".*[A-Z].*") &&
                senha.matches(".*[a-z].*") &&
                senha.matches(".*[!@#$%^&*(),.?\":{}|<>].*");

        String[] senhasSeguras = {
                "MinhaSenh@123",
                "password123",
                "PASSWORD123!",
                "MinhaSenh@",
        };

        System.out.println("Senha segura(8+ chars, número, maiúscula, minúscula, símbolo):");
        for (String senha : senhasSeguras) {
            boolean valido = validadorSenhaSegura.validar(senha);
            System.out.println(String.format("\"%-15s\" -> %s %s",
                                senha,
                                valido ? "✅" : "❌",
                                valido ? "SEGURA" : "INSEGURA"));
        }
    }

    private static <T> void testarValidador(Validador<T> validador, T[] valores) {
        for (T valor : valores) {
            String exibicao = valor == null ? "null" : valor.toString();
            boolean valido = validador.validar(valor);
            System.out.println(String.format("%s-20s -> %s %s",
                                            "\"" + exibicao + "\"",
                                            valido ? "✅" : "❌",
                                            valido ? "VÁLIDO" : "INVÁLIDO"
                    ));
        }
    }
}
