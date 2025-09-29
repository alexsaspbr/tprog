import ada.tech.desafiostream.*;
import java.util.*;
import java.util.stream.Collectors;

public class PipelineProdutos {
public static void main(String[] args) {
        // Criando lista de produtos
        List<Produto> produtos = Arrays.asList(
            new Produto("Notebook", 2500.00, "Eletrônicos"),
            new Produto("Smartphone", 1200.00, "Eletrônicos"),
            new Produto("Tablet", 800.00, "Eletrônicos"),
            new Produto("Fone de Ouvido", 300.00, "Eletrônicos"),
            new Produto("TV 4K", 3500.00, "Eletrônicos"),
            new Produto("Mouse", 150.00, "Eletrônicos"),
            new Produto("Camiseta", 50.00, "Vestuário"),
            new Produto("Tênis", 250.00, "Calçados"),
            new Produto("Monitor", 900.00, "Eletrônicos"),
            new Produto("Teclado", 400.00, "Eletrônicos")
        );
        
        // Pipeline composto
        List<String> resultado = produtos.stream()
            // 1. Filtrar apenas produtos da categoria "Eletrônicos" com preço acima de 500
            .filter(p -> "Eletrônicos".equals(p.getCategoria()) && p.getPreco() > 500)
            // 2. Ordenar os produtos pelo preço em ordem decrescente
            .sorted((p1, p2) -> Double.compare(p2.getPreco(), p1.getPreco()))
            // 3. Agrupar os produtos por categoria
            .collect(Collectors.groupingBy(Produto::getCategoria))
            // 4. Dentro da categoria "Eletrônicos", extrair apenas os nomes dos produtos mais caros (top 2)
            .getOrDefault("Eletrônicos", new ArrayList<>())
            .stream()
            .limit(2) // Pegar apenas os 2 primeiros (mais caros)
            .map(Produto::getNome) // Extrair apenas os nomes
            .collect(Collectors.toList());
        
        // Exibir o resultado final
        System.out.println("Top 2 produtos mais caros da categoria Eletrônicos (preço > 500):");
        resultado.forEach(System.out::println);
        
        // Versão alternativa mostrando todo o processo passo a passo:
        System.out.println("\n--- Processo Detalhado ---");
        
        // Passo 1: Filtrar
        List<Produto> filtrados = produtos.stream()
            .filter(p -> "Eletrônicos".equals(p.getCategoria()) && p.getPreco() > 500)
            .collect(Collectors.toList());
        System.out.println("1. Produtos Eletrônicos com preço > 500:");
        filtrados.forEach(System.out::println);
        
        // Passo 2: Ordenar
        List<Produto> ordenados = filtrados.stream()
            .sorted((p1, p2) -> Double.compare(p2.getPreco(), p1.getPreco()))
            .collect(Collectors.toList());
        System.out.println("\n2. Produtos ordenados por preço (decrescente):");
        ordenados.forEach(System.out::println);
        
        // Passo 3: Agrupar
        Map<String, List<Produto>> agrupados = ordenados.stream()
            .collect(Collectors.groupingBy(Produto::getCategoria));
        System.out.println("\n3. Produtos agrupados por categoria:");
        agrupados.forEach((categoria, lista) -> {
            System.out.println("Categoria: " + categoria);
            lista.forEach(p -> System.out.println("  - " + p.getNome() + ": R$ " + p.getPreco()));
        });
        
        // Passo 4: Extrair top 2 nomes
        List<String> top2Nomes = agrupados.getOrDefault("Eletrônicos", new ArrayList<>())
            .stream()
            .limit(2)
            .map(Produto::getNome)
            .collect(Collectors.toList());
        System.out.println("\n4. Top 2 produtos mais caros (apenas nomes):");
        top2Nomes.forEach(System.out::println);
    }
}
