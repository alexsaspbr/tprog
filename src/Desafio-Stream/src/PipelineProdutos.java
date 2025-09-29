import java.util.*;
import java.util.stream.Collectors;

public class PipelineProdutos {
    public static void main(String[] args) {
        // Criando lista de produtos
        List<Produto> produtos = Arrays.asList(
                new Produto("iPhone 15", 4500.00, "Eletrônicos"),
                new Produto("Samsung TV", 3200.00, "Eletrônicos"),
                new Produto("Notebook Gamer", 5500.00, "Eletrônicos"),
                new Produto("Tablet", 800.00, "Eletrônicos"),
                new Produto("Fone Bluetooth", 300.00, "Eletrônicos"),
                new Produto("Smartwatch", 1200.00, "Eletrônicos"),
                new Produto("Camiseta", 50.00, "Vestuário"),
                new Produto("Tênis", 250.00, "Vestuário"),
                new Produto("Livro Java", 80.00, "Livros")
        );

        // Pipeline completo
        List<String> resultado = produtos.stream()
                // 1. Filtrar apenas Eletrônicos com preço acima de 500
                .filter(p -> "Eletrônicos".equals(p.getCategoria()) && p.getPreco() > 500)

                // 2. Ordenar pelo preço em ordem decrescente
                .sorted((p1, p2) -> Double.compare(p2.getPreco(), p1.getPreco()))

                // 3. Agrupar por categoria (apenas para demonstração)
                .collect(Collectors.toList()) // Coletamos temporariamente
                .stream()

                // 4. Extrair apenas os nomes dos 2 produtos mais caros
                .limit(2)
                .map(Produto::getNome)

                // Coletar resultado final
                .collect(Collectors.toList());

        System.out.println("=== RESULTADO FINAL ===");
        System.out.println("Top 2 produtos mais caros da categoria Eletrônicos (acima de R$ 500):");
        resultado.forEach(System.out::println);


        System.out.println("\n=== AGRUPAMENTO POR CATEGORIA ===");
        Map<String, List<Produto>> produtosPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria));

        produtosPorCategoria.forEach((categoria, listaProdutos) -> {
            System.out.println("\nCategoria: " + categoria);
            listaProdutos.forEach(p ->
                    System.out.println("  - " + p.getNome() + " - R$ " + p.getPreco()));
        });


        System.out.println("\n=== VERSÃO ALTERNATIVA COMPLETA ===");
        Map<String, List<String>> resultadoCompleto = produtos.stream()

                .collect(Collectors.groupingBy(Produto::getCategoria))


                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            if ("Eletrônicos".equals(entry.getKey())) {
                                return entry.getValue().stream()
                                        .filter(p -> p.getPreco() > 500)
                                        .sorted((p1, p2) -> Double.compare(p2.getPreco(), p1.getPreco()))
                                        .limit(2)
                                        .map(Produto::getNome)
                                        .collect(Collectors.toList());
                            } else {
                                return entry.getValue().stream()
                                        .map(Produto::getNome)
                                        .collect(Collectors.toList());
                            }
                        }
                ));

        resultadoCompleto.forEach((categoria, nomes) -> {
            System.out.println("\nCategoria: " + categoria);
            System.out.println("Produtos: " + nomes);
        });
    }
}