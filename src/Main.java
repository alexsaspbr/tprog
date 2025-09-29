import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // Criando lista de produtos de exemplo
        List<Produto> produtos = criarListaProdutos();

        System.out.println("========================================");
        System.out.println("   PIPELINE COMPOSTO COM STREAMS");
        System.out.println("========================================\n");

        // =====================================================
        // ETAPA 1 e 2: Filtrar e Ordenar
        // =====================================================
        System.out.println("📋 ETAPA 1 e 2: Eletrônicos > R$ 500 (ordem decrescente)");
        System.out.println("─────────────────────────────────────────");
        
        List<Produto> eletronicosCaros = produtos.stream()
                .filter(p -> p.getCategoria().equals("Eletrônicos"))
                .filter(p -> p.getPreco() > 500)
                .sorted(Comparator.comparing(Produto::getPreco).reversed())
                .collect(Collectors.toList());

        eletronicosCaros.forEach(System.out::println);

        // =====================================================
        // ETAPA 3: Agrupar por Categoria
        // =====================================================
        System.out.println("\n📦 ETAPA 3: Agrupamento por Categoria");
        System.out.println("─────────────────────────────────────────");
        
        Map<String, List<Produto>> produtosPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria));

        produtosPorCategoria.forEach((categoria, listaProdutos) -> {
            System.out.println("\n▸ " + categoria + " (" + listaProdutos.size() + " produtos):");
            listaProdutos.forEach(p -> System.out.println("  • " + p));
        });

        // =====================================================
        // ETAPA 4: Top 2 Eletrônicos Mais Caros
        // =====================================================
        System.out.println("\n🏆 ETAPA 4: Top 2 Eletrônicos Mais Caros");
        System.out.println("─────────────────────────────────────────");
        
        List<String> top2Eletronicos = produtos.stream()
                .filter(p -> p.getCategoria().equals("Eletrônicos"))
                .sorted(Comparator.comparing(Produto::getPreco).reversed())
                .limit(2)
                .map(Produto::getNome)
                .collect(Collectors.toList());

        for (int i = 0; i < top2Eletronicos.size(); i++) {
            System.out.println((i + 1) + "º lugar: " + top2Eletronicos.get(i));
        }

        // =====================================================
        // PIPELINE COMPLETO EM UMA ÚNICA OPERAÇÃO
        // =====================================================
        System.out.println("\n\n BONUS: PIPELINE COMPLETO INTEGRADO");
        System.out.println("─────────────────────────────────────────");
        
        executarPipelineCompleto(produtos);

        // =====================================================
        // ESTATÍSTICAS ADICIONAIS
        // =====================================================
        System.out.println("\n\n ESTATÍSTICAS ADICIONAIS");
        System.out.println("─────────────────────────────────────────");
        exibirEstatisticas(produtos);
    }

    /**
     * Pipeline completo em uma única operação encadeada
     */
    private static void executarPipelineCompleto(List<Produto> produtos) {
        // Pipeline integrado que executa todas as etapas

        // Filtragem e ordenação
        List<Produto> eletronicosCaros = produtos.stream()
                .filter(p -> p.getCategoria().equals("Eletrônicos") && p.getPreco() > 500)
                .sorted(Comparator.comparing(Produto::getPreco).reversed())
                .collect(Collectors.toList());

        // Agrupamento
        Map<String, List<Produto>> agrupamento = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria));

        // Top 2 mais caros
        List<String> top2 = produtos.stream()
                .filter(p -> p.getCategoria().equals("Eletrônicos"))
                .sorted(Comparator.comparing(Produto::getPreco).reversed())
                .limit(2)
                .map(Produto::getNome)
                .collect(Collectors.toList());

        // Exibir resultado final
        System.out.println("✓ Eletrônicos > R$ 500 encontrados: " + eletronicosCaros.size());
        System.out.println("✓ Categorias diferentes: " + agrupamento.keySet().size());
        System.out.println("✓ Top 2 Eletrônicos: " + String.join(", ", top2));
    }

    /**
     * Exibe estatísticas avançadas usando Streams
     */
    private static void exibirEstatisticas(List<Produto> produtos) {
        // Preço médio por categoria
        Map<String, Double> precoMedioPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(
                        Produto::getCategoria,
                        Collectors.averagingDouble(Produto::getPreco)
                ));

        System.out.println("\n💰 Preço Médio por Categoria:");
        precoMedioPorCategoria.forEach((cat, media) ->
                System.out.printf("  • %s: R$ %.2f%n", cat, media));

        // Produto mais caro geral
        Optional<Produto> maisCaro = produtos.stream()
                .max(Comparator.comparing(Produto::getPreco));

        maisCaro.ifPresent(p ->
                System.out.println("\n💎 Produto mais caro: " + p));

        // Contagem por categoria
        Map<String, Long> contagemPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(
                        Produto::getCategoria,
                        Collectors.counting()
                ));

        System.out.println("\n Quantidade por Categoria:");
        contagemPorCategoria.forEach((cat, count) ->
                System.out.printf("  • %s: %d produtos%n", cat, count));
    }

    /**
     * Cria uma lista de produtos de exemplo para o desafio
     */
    private static List<Produto> criarListaProdutos() {
        return Arrays.asList(
                // Eletrônicos
                new Produto("iPhone 15 Pro Max", 8999.00, "Eletrônicos"),
                new Produto("Samsung Galaxy S24 Ultra", 7499.00, "Eletrônicos"),
                new Produto("MacBook Pro M3", 15999.00, "Eletrônicos"),
                new Produto("Dell XPS 15", 9500.00, "Eletrônicos"),
                new Produto("iPad Air", 4999.00, "Eletrônicos"),
                new Produto("Fone Bluetooth JBL", 299.00, "Eletrônicos"),
                new Produto("Smart TV 65\" OLED", 6799.00, "Eletrônicos"),
                new Produto("PlayStation 5", 3899.00, "Eletrônicos"),
                new Produto("Apple Watch Ultra", 8599.00, "Eletrônicos"),
                new Produto("Mouse Logitech MX", 450.00, "Eletrônicos"),

                // Livros
                new Produto("Clean Code", 89.90, "Livros"),
                new Produto("Design Patterns", 125.00, "Livros"),
                new Produto("Java Efetivo", 95.00, "Livros"),
                new Produto("Código Limpo", 79.90, "Livros"),

                // Roupas
                new Produto("Camiseta Nike", 149.90, "Roupas"),
                new Produto("Tênis Adidas", 599.00, "Roupas"),
                new Produto("Jaqueta North Face", 899.00, "Roupas"),
                new Produto("Calça Jeans Levis", 349.00, "Roupas"),

                // Alimentos
                new Produto("Café Especial 500g", 45.00, "Alimentos"),
                new Produto("Chocolate Lindt", 35.00, "Alimentos"),
                new Produto("Azeite Extra Virgem", 89.00, "Alimentos"),
                new Produto("Queijo Parmesão", 120.00, "Alimentos")
        );
    }
}
