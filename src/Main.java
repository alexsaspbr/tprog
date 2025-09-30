import ada.tech.exemplo.Produto;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Produto> produtos = Arrays.asList(
            new Produto("Notebook", 3500, "Eletrônicos"),
            new Produto("Smartphone", 2500, "Eletrônicos"),
            new Produto("Fone de Ouvido", 300, "Eletrônicos"),
            new Produto("Geladeira", 2000, "Eletrodomésticos"),
            new Produto("TV", 1800, "Eletrônicos"),
            new Produto("Liquidificador", 150, "Eletrodomésticos")
        );

        // 1. Filtrar eletrônicos com preço > 500 e ordenar decrescente
        List<Produto> eletronicosCaros = produtos.stream()
            .filter(p -> p.getCategoria().equals("Eletrônicos") && p.getPreco() > 500)
            .sorted(Comparator.comparingDouble(Produto::getPreco).reversed())
            .collect(Collectors.toList());

        // 2. Agrupar por categoria
        Map<String, List<Produto>> agrupadoPorCategoria = produtos.stream()
            .collect(Collectors.groupingBy(Produto::getCategoria));

        // 3. Top 2 nomes dos eletrônicos mais caros
        List<String> top2Eletronicos = eletronicosCaros.stream()
            .limit(2)
            .map(Produto::getNome)
            .collect(Collectors.toList());

        // 4. Exibir resultados
        System.out.println("Eletrônicos com preço acima de 500 (ordenados):");
        eletronicosCaros.forEach(System.out::println);

        System.out.println("\nProdutos agrupados por categoria:");
        agrupadoPorCategoria.forEach((cat, lista) -> {
            System.out.println(cat + ": " + lista);
        });

        System.out.println("\nTop 2 eletrônicos mais caros:");
        top2Eletronicos.forEach(System.out::println);
    }
}

