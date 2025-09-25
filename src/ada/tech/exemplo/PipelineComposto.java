package ada.tech.exemplo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PipelineComposto {
  public static <list> void main(String[] args) {
    System.out.println("Pipeline Composto");

    ArrayList<Produto> produtos = new ArrayList<>(List.of(
      new Produto("PC", 7500.00, "Eletrônicos"),
      new Produto("Smartphone", 5000.00, "Eletrônicos"),
      new Produto("Impressora", 800.00, "Eletrônicos"),
      new Produto("Mesa", 300.00, "Móveis"),
      new Produto("Cadeira", 150.00, "Móveis"),
      new Produto("Caderno", 20.00, "Papelaria"),
      new Produto("Borracha", 3.00, "Papelaria")
    )
    );

    Predicate<Produto> preço = p -> p.getPreco() > 500.00;
    Predicate<Produto> categoria = p -> p.getCategoria().equals("Eletrônicos");

    Map<String, List<Produto>> produtosAgrupados = produtos.stream()
      .filter(preço.and(categoria)).sorted((p1, p2) -> p2.getPreco().compareTo(p1.getPreco()))
.limit(2)
      .collect(Collectors.groupingBy(Produto::getCategoria));

    System.out.println(produtosAgrupados);

  }

}
