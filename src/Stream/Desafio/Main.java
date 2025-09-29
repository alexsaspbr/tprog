package Stream.Desafio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(" EXERCICIO 5 - PIPELINE COMPOSTO POR STREAMS");
        System.out.println("=".repeat(70));

        List<Produto> produtos = criarListaProdutos();

        System.out.println("\n LISTA ORIGINAL DE PRODUTOS :");
        System.out.println("=".repeat(70));
        System.out.println(String.format("%-25s | %-10s | %s", "Nome", "Preço", "Categoria"));
        System.out.println("-".repeat(70));
        produtos.forEach(System.out::println);

        System.out.println("\n" + "=".repeat(70));
        System.out.println("EXECUTANDO PIPELINE DE OPERAÇÕES");
        System.out.println("=".repeat(70));

        System.out.println("\n ETAPA 1: Filtrar Eletrônicos com preço > R$ 500,00");
        System.out.println("-".repeat(70));

        List<Produto> eletronicosCaros = produtos.stream()
                .filter(p -> p.getCategoria().equals("Eletrônicos"))
                .filter(p -> p.getPreco() > 500)
                .collect(Collectors.toList());

        System.out.println("\n ETAPA 2: Ordenar por preço decrescente");
        System.out.println("-".repeat(70));

        List<Produto> eletronicosOrdenados = eletronicosCaros.stream()
                .sorted(Comparator.comparing(Produto::getPreco).reversed())
                .collect(Collectors.toList());

        System.out.println("Produtos Ordenados:");
        eletronicosOrdenados.forEach(System.out::println);

        System.out.println("ETAPA 3: Agrupar produtos por categoria");
        System.out.println("-".repeat(70));

        Map<String, List<Produto>> produtosPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria));

        System.out.println("Produtos agruagados por categoria:");
        produtosPorCategoria.forEach((categoria, lista) ->{
            System.out.println("\n " + categoria + " (" + lista.size() + " produtos):");
            lista.forEach(p -> System.out.println(" * " + p));
        });

        System.out.println("ETAPA 4: Top 2 produtos mais caros de eletrônicos");
        System.out.println("-".repeat(70));

        List<String> top2Eletronicos = produtos.stream()
                .filter(p -> p.getCategoria().equals("Eletrônicos"))
                .sorted(Comparator.comparing(Produto::getPreco).reversed())
                .limit(2)
                .map(Produto::getNome)
                .collect(Collectors.toList());

        System.out.println(" Top 2 mais caros:");
        for (int i = 0;i < top2Eletronicos.size(); i++) {
            System.out.println(" " + (i + 1) + "º - " + top2Eletronicos.get(i));
        }

        System.out.println("=".repeat(70));
        System.out.println("RESULTADO FINAL CONSOLIDADO");
        System.out.println("=".repeat(70));

        System.out.println("\n ESTATISTICAS:");
        System.out.println(" * Total de produtos: " + produtos.size());
        System.out.println(" * Categorias Únicas:" + produtosPorCategoria.size());
        System.out.println(" * Eletrônicos > R$ 500: " + eletronicosCaros.size());

        System.out.println("TOP 2 ELETRÔNICOS MAIS CAROS:");
        produtos.stream()
                .filter(p -> p.getCategoria().equals("Eletrônicos"))
                .sorted(Comparator.comparing(Produto::getPreco).reversed())
                .limit(2)
                .forEach(p -> System.out.println(" " + p));

        System.out.println("\n💰 ANÁLISE DE PREÇOS POR CATEGORIA:");
        produtosPorCategoria.forEach((categoria, lista) -> {
            double media = lista.stream()
                    .mapToDouble(Produto::getPreco)
                    .average()
                    .orElse(0.0);

            double min = lista.stream()
                    .mapToDouble(Produto::getPreco)
                    .min()
                    .orElse(0.0);

            double max = lista.stream()
                    .mapToDouble(Produto::getPreco)
                    .max()
                    .orElse(0.0);

            System.out.println(String.format("\n   📦 %s:", categoria));
            System.out.println(String.format("      • Média: R$ %.2f", media));
            System.out.println(String.format("      • Mínimo: R$ %.2f", min));
            System.out.println(String.format("      • Máximo: R$ %.2f", max));
        });

        // BÔNUS: Pipeline completo em uma única expressão
        System.out.println("\n" + "=" .repeat(70));
        System.out.println("⚡ BÔNUS - Pipeline Completo em Uma Expressão:");
        System.out.println("=" .repeat(70));

        List<String> resultadoCompleto = produtos.stream()
                .filter(p -> p.getCategoria().equals("Eletrônicos"))
                .filter(p -> p.getPreco() > 500)
                .sorted(Comparator.comparing(Produto::getPreco).reversed())
                .limit(2)
                .map(p -> String.format("%s - R$ %.2f", p.getNome(), p.getPreco()))
                .collect(Collectors.toList());

        System.out.println("\n✨ Top 2 Eletrônicos (preço > R$ 500, ordenados):");
        resultadoCompleto.forEach(r -> System.out.println("   • " + r));
    }

    // Método auxiliar para criar lista de produtos
    private static List<Produto> criarListaProdutos() {
        List<Produto> produtos = new ArrayList<>();

        // Eletrônicos
        produtos.add(new Produto("Notebook Gamer", 4500.00, "Eletrônicos"));
        produtos.add(new Produto("Smartphone Premium", 3200.00, "Eletrônicos"));
        produtos.add(new Produto("Tablet", 1200.00, "Eletrônicos"));
        produtos.add(new Produto("Smart TV 55\"", 2800.00, "Eletrônicos"));
        produtos.add(new Produto("Fone Bluetooth", 350.00, "Eletrônicos"));
        produtos.add(new Produto("Console de Videogame", 2500.00, "Eletrônicos"));
        produtos.add(new Produto("Câmera Digital", 1800.00, "Eletrônicos"));

        // Livros
        produtos.add(new Produto("Clean Code", 89.90, "Livros"));
        produtos.add(new Produto("Design Patterns", 120.00, "Livros"));
        produtos.add(new Produto("Effective Java", 95.50, "Livros"));
        produtos.add(new Produto("Head First Java", 78.00, "Livros"));

        // Móveis
        produtos.add(new Produto("Cadeira Gamer", 1500.00, "Móveis"));
        produtos.add(new Produto("Mesa de Escritório", 800.00, "Móveis"));
        produtos.add(new Produto("Estante", 450.00, "Móveis"));
        produtos.add(new Produto("Sofá", 2200.00, "Móveis"));

        // Esportes
        produtos.add(new Produto("Bicicleta MTB", 1800.00, "Esportes"));
        produtos.add(new Produto("Tênis Corrida", 450.00, "Esportes"));
        produtos.add(new Produto("Esteira", 2500.00, "Esportes"));
        produtos.add(new Produto("Halteres", 150.00, "Esportes"));

        return produtos;
    }
}
