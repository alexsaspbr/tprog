public class Main {
    public static void main(String[] args) {
        List<Produto> produtos = Arrays.asList(
            new Produto("Notebook", 3500, "Eletrônicos"),
            new Produto("Geladeira", 2000, "Eletrodomésticos"),
            new Produto("Celular", 2500, "Eletrônicos"),
            new Produto("TV", 1800, "Eletrônicos"),
            new Produto("Camiseta", 100, "Vestuário"),
            new Produto("Fone de Ouvido", 300, "Eletrônicos"),
            new Produto("Cafeteira", 450, "Eletrodomésticos")
        );

        // Filtrar eletrônicos acima de 500
        List<Produto> eletronicosCaros = produtos.stream()
            .filter(p -> p.getCategoria().equalsIgnoreCase("Eletrônicos") && p.getPreco() > 500)
            .collect(Collectors.toList());

        System.out.println("Eletrônicos acima de 500:");
        eletronicosCaros.forEach(System.out::println);

        // Ordenar por preço decrescente
        List<Produto> ordenadosDesc = eletronicosCaros.stream()
            .sorted(Comparator.comparingDouble(Produto::getPreco).reversed())
            .collect(Collectors.toList());

        System.out.println("\nOrdenados por preço (desc):");
        ordenadosDesc.forEach(System.out::println);

        // Agrupar por categoria
        Map<String, List<Produto>> agrupados = produtos.stream()
            .collect(Collectors.groupingBy(Produto::getCategoria));

        System.out.println("\nAgrupados por categoria:");
        agrupados.forEach((cat, lista) -> {
            System.out.println(cat + ": " + lista);
        });

        // Top 2 mais caros de eletrônicos
        List<String> topEletronicos = produtos.stream()
            .filter(p -> p.getCategoria().equalsIgnoreCase("Eletrônicos"))
            .sorted(Comparator.comparingDouble(Produto::getPreco).reversed())
            .limit(2)
            .map(Produto::getNome)
            .collect(Collectors.toList());

        System.out.println("\nTop 2 eletrônicos mais caros:");
        topEletronicos.forEach(System.out::println);
    }
}