package stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static List<Produto> paginar(List<Produto> lista, int pagina, int tamanhoPagina) {
        return lista.stream()
                .skip((long) (pagina - 1) * tamanhoPagina)
                .limit(tamanhoPagina)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            produtos.add(new Produto("SKU" + i, "Produto " + i, BigDecimal.valueOf(i * 10)));
        }

        System.out.println("Página 1 (tamanho 3):");
        paginar(produtos, 1, 3).forEach(System.out::println);

        System.out.println("\n Página 2 (tamanho 3):");
        paginar(produtos, 2, 3).forEach(System.out::println);

        System.out.println("\n Página 4 (tamanho 3):");
        paginar(produtos, 4, 3).forEach(System.out::println);
    }
}
