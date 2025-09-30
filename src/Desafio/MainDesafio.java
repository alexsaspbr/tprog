package Desafio;

import java.util.*;
import java.util.stream.Collectors;


public class MainDesafio {
    public static void main(String[] args){
        List<Produto> produtos = Arrays.asList(
                new Produto("Notebook", 3500, "Eletrônicos"),
                new Produto("Smartphone", 2500, "Eletrônicos"),
                new Produto("Mouse", 150, "Eletrônicos"),
                new Produto("Geladeira", 2000, "Eletrodomésticos"),
                new Produto("TV", 1800, "Eletrônicos"),
                new Produto("Camiseta", 80, "Vestuário"),
                new Produto("Fone Bluetooth", 600, "Eletrônicos"),
                new Produto("Liquidificador", 300, "Eletrodomésticos")
        );

        // 1️⃣ Filtrar eletrônicos acima de 500
        List<Produto> eletronicosCaros = produtos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase("Eletrônicos"))
                .filter(p -> p.getPreco() > 500)
                .collect(Collectors.toList());

        System.out.println("Eletrônicos acima de 500:");
        eletronicosCaros.forEach(System.out::println);

        // 2️⃣ Ordenar por preço decrescente
        List<Produto> ordenados = eletronicosCaros.stream()
                .sorted(Comparator.comparingDouble(Produto::getPreco).reversed())
                .collect(Collectors.toList());

        System.out.println("\nOrdenados por preço (decrescente):");
        ordenados.forEach(System.out::println);

        // 3️⃣ Agrupar por categoria
        Map<String, List<Produto>> agrupados = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria));

        System.out.println("\nProdutos agrupados por categoria:");
        agrupados.forEach((cat, lista) -> {
            System.out.println(cat + " => " + lista);
        });

        // 4️⃣ Dentro de Eletrônicos, pegar apenas os 2 mais caros (nomes)
        List<String> top2Eletronicos = produtos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase("Eletrônicos"))
                .sorted(Comparator.comparingDouble(Produto::getPreco).reversed())
                .limit(2)
                .map(Produto::getNome)
                .collect(Collectors.toList());

        System.out.println("\nTop 2 Eletrônicos mais caros:");
        top2Eletronicos.forEach(System.out::println);
    }
}
