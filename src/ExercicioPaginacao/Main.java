package ExercicioPaginacao;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Produto> produtos = Arrays.asList(
                new Produto("SKU001", "Smartphone Galaxy S23", new BigDecimal("2999.99")),
                new Produto("SKU002", "Notebook Dell Inspiron", new BigDecimal("3499.90")),
                new Produto("SKU003", "Mouse gamer, RGB", new BigDecimal("159.90")),
                new Produto("SKU004", "Teclado Mecânico", new BigDecimal("299.99")),
                new Produto("SKU005", "Monitor 24 polegadas", new BigDecimal("899.00")),
                new Produto("SKU006", "Headset Bluetooth", new BigDecimal("249.90")),
                new Produto("SKU007", "Tablet iPad Air", new BigDecimal("4299.00")),
                new Produto("SKU008", "Webcam Full HD", new BigDecimal("189.90")),
                new Produto("SKU009", "Impressora Multifuncional", new BigDecimal("799.90")),
                new Produto("SKU010", "Roteador Wi-Fi 6", new BigDecimal("399.99"))
        );

        System.out.println("=== SISTEMA DE PRODUTOS ===\n");
        System.out.println("Total de produtos: " + produtos.size() + "\n");

        System.out.println("--- Página 1 tamanho: 3 ---");
        List<Produto> pagina1 = PaginacaoService.paginar(produtos, 1, 3);
        exibirProdutos(pagina1);

        System.out.println("\n--- Página 2 (tamanho: 3) ---");
        List<Produto> pagina2 = PaginacaoService.paginar(produtos, 2, 3);
        exibirProdutos(pagina2);

        System.out.println("\n--- Página 3 (tamanho: 3) ---");
        List<Produto> pagina3 = PaginacaoService.paginar(produtos, 3, 3);
        exibirProdutos(pagina3);

        System.out.println("\n--- Página 4 (tamanho: 3) ---");
        List<Produto> pagina4 = PaginacaoService.paginar(produtos, 4, 3);
        exibirProdutos(pagina4);

        System.out.println("\n--- Página 1 tamanho: 5 ---");
        List<Produto> paginaGrande = PaginacaoService.paginar(produtos, 1, 5);
        exibirProdutos(paginaGrande);

        System.out.println("\n--- Página 5 (tamanho: 3) - Página Vazia ---");
        List<Produto> paginaVazia = PaginacaoService.paginar(produtos, 5, 3);
        if (paginaVazia.isEmpty()) {
            System.out.println("Nenhum produto encontrado nesta página!");
        } else {
            exibirProdutos(paginaVazia);
        }

        System.out.println("\n=== INFORMAÇÕES DE PAGINAÇÃO ===");
        int tamanhoPagina = 3;
        int totalPaginas = (int) Math.ceil((double) produtos.size() / tamanhoPagina);
        System.out.println("Total de Produtos: " + produtos.size());
        System.out.println("Tamanho da página: " + tamanhoPagina);
        System.out.println("Total de paginas: " + totalPaginas);

    }

    private static void exibirProdutos(List<Produto> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado!");
        } else  {
            produtos.forEach(produto ->  System.out.println("* " + produto));
        }
    }
}
