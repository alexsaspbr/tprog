package Stream.Desafio;

import java.util.*;
import java.util.stream.Collectors;

public class PipelinesExtras {

    public static void produtoMaisCaroPorCategoria(List<Produto> produtos) {
        Map<String, Optional<Produto>> maisCaro = produtos.stream()
                .collect(Collectors.groupingBy(
                        Produto::getCategoria,
                        Collectors.maxBy(Comparator.comparing(Produto::getPreco))
                ));

        System.out.println("🏆 Produto mais caro por categoria:");
        maisCaro.forEach((cat, prod) ->
                prod.ifPresent(p -> System.out.println("   " + cat + ": " + p))
        );
    }

    // Pipeline para calcular valor total por categoria
    public static void valorTotalPorCategoria(List<Produto> produtos) {
        Map<String, Double> totais = produtos.stream()
                .collect(Collectors.groupingBy(
                        Produto::getCategoria,
                        Collectors.summingDouble(Produto::getPreco)
                ));

        System.out.println("💰 Valor total por categoria:");
        totais.forEach((cat, total) ->
                System.out.printf("   %s: R$ %.2f%n", cat, total)
        );
    }

    // Pipeline para estatísticas gerais
    public static void estatisticasGerais(List<Produto> produtos) {
        DoubleSummaryStatistics stats = produtos.stream()
                .mapToDouble(Produto::getPreco)
                .summaryStatistics();

        System.out.println("📊 Estatísticas Gerais:");
        System.out.printf("   • Total de produtos: %d%n", stats.getCount());
        System.out.printf("   • Preço médio: R$ %.2f%n", stats.getAverage());
        System.out.printf("   • Preço mínimo: R$ %.2f%n", stats.getMin());
        System.out.printf("   • Preço máximo: R$ %.2f%n", stats.getMax());
        System.out.printf("   • Soma total: R$ %.2f%n", stats.getSum());
    }

}
