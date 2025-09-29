package exercicios.desafio;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Produto> produtos = Arrays.asList(
                new Produto("Notebook Gamer", 5500, "Eletrônico"),
                new Produto("Geladeira", 7000, "Eletrodomésticos"),
                new Produto("Iphone 17", 12000, "Eletrônico"),
                new Produto("Headset", 650, "Eletrônico"),
                new Produto("Monitor 48", 4999, "Eletrônico"),
                new Produto("Tênis", 1600, "Calçado"),
                new Produto("Micro-ondas", 700, "Eletrodomésticos"),
                new Produto("Máquina de Lavar", 2500, "Eletrodomésticos"),
                new Produto("Bota de Couro", 500, "Calçado"),
                new Produto("Chinelo", 50, "Calçado"),
                new Produto("Jaqueta de Couro", 450, "Vestuário"),
                new Produto("Calça Jeans", 180, "Vestuário"),
                new Produto("Camiseta Polo", 250, "Vestuário")
        );

        List<Produto> eletronicosMaisCaro = produtos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase("Eletrônico") && p.getPreco() > 500)
                .collect(Collectors.toList());

        System.out.println("Eletrônico acima de 500: ");
        eletronicosMaisCaro.forEach(System.out::println);

        List<Produto> ordenacaoDecrescente = produtos.stream()
                .sorted(Comparator.comparingDouble(Produto::getPreco).reversed())
                .collect(Collectors.toList());

        System.out.println("\nOrdenado por preço ordem decrecente: ");
        ordenacaoDecrescente.forEach(System.out::println);

        Map<String, List<Produto>> agrupamento = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria));

        System.out.println("\nProdutos agrupados por categoria: ");
        agrupamento.forEach((cat, lista) -> {
            System.out.println(cat + ": " + lista);
        });

        List<String> top2Nomes = produtos.stream()
                .filter(p -> p.getCategoria().equals("Eletrônico"))
                .sorted(Comparator.comparingDouble(Produto::getPreco).reversed())
                .limit(2)
                .map(Produto::getNome)
                .collect(Collectors.toList());

        System.out.println("\nTop 2 produtos mais caro de Eletrônico: : ");
        top2Nomes.forEach(System.out::println);
    }
}

