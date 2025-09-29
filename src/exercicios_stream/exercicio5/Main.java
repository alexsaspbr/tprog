package exercicios_stream.exercicio5;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Produto> produtos = Arrays.asList(
                new Produto("Smartphone X", new BigDecimal("1200"), "Eletrônicos"),
                new Produto("Notebook Y", new BigDecimal("3500"), "Eletrônicos"),
                new Produto("Fone Z", new BigDecimal("150"), "Eletrônicos"),
                new Produto("TV 4K", new BigDecimal("2800"), "Eletrônicos"),
                new Produto("Cadeira Gamer", new BigDecimal("800"), "Móveis"),
                new Produto("Mesa Escritório", new BigDecimal("400"), "Móveis"),
                new Produto("Geladeira", new BigDecimal("2500"), "Eletrodomésticos"),
                new Produto("Micro-ondas", new BigDecimal("700"), "Eletrodomésticos")
        );

        // Pipeline completo
        List<String> resultadoFinal = produtos.stream()
                .filter(p -> p.getCategoria().equals("Eletrônicos") && p.getPreco().compareTo(new BigDecimal("500")) > 0)
                // filtra apenas produtos da categoria "Eletrônicos" com preço maior que 500
                .sorted(Comparator.comparing(Produto::getPreco).reversed())
                // ordena os produtos filtrados pelo preço em ordem decrescente
                .limit(2)
                // pega apenas os 2 primeiros produtos (os mais caros)
                .map(Produto::getNome)
                // transforma cada Produto em seu nome (String)
                .toList();
                // coleta o resultado em uma lista de nomes (List<String>)

        System.out.println("Top 2 eletrônicos mais caros:");
        resultadoFinal.forEach(System.out::println);
    }
}
