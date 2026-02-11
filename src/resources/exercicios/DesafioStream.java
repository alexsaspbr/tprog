package resources.exercicios;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DesafioStream {

    public static void main(String[] args) {
        List<Produto> produtos = List.of(
                new Produto("Smartphone X", 1200.00, "Eletrônicos"),
                new Produto("Notebook A", 3500.00, "Eletrônicos"),
                new Produto("Mouse Pad", 50.00, "Acessórios"),
                new Produto("Câmera Digital", 650.00, "Eletrônicos"),
                new Produto("Teclado Mecânico", 450.00, "Eletrônicos"),
                new Produto("Livro Java", 80.00, "Livros"),
                new Produto("Smartwatch", 700.00, "Eletrônicos"),
                new Produto("Fone de Ouvido", 550.00, "Eletrônicos")
        );

        List<Produto> eletronicosFiltrados = produtos.stream()
                .filter(p -> "Eletrônicos".equals(p.getCategoria()))
                .filter(p -> p.getPreco() > 500)
                .sorted(Comparator.comparing(Produto::getPreco).reversed())
                .toList();

        Map<String, List<Produto>> produtosPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria));

        List<String> top2NomesMaisCaros = eletronicosFiltrados.stream()
                .limit(2)
                .map(Produto::getNome)
                .toList();


        System.out.println("--- 1. Produtos eletronicos Filtrados e Ordenados (> R$ 500) ---");
        eletronicosFiltrados.forEach(System.out::println);

        System.out.println("\n-- 2. Agrupamento Total por Categoria ---");
        System.out.println(produtosPorCategoria);

        System.out.println("\n--- 3. TOP 2 Nomes de Eletronicos Mais Caros (a partir da lista filtrada) --");
        System.out.println(top2NomesMaisCaros);
    }
}
