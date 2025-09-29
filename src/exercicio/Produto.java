package exercicio;

import java.math.BigDecimal;

public class Produto {
    private String sku;
    private String descricao;
    private BigDecimal valor;

    public Produto(String sku, String descricao, BigDecimal valor) {
        this.sku = sku;
        this.descricao = descricao;
        this.valor = valor;
    }

//    public String getSku() {
//        return sku;
//    }
//
//    public String getDescricao() {
//        return descricao;
//    }
//
//    public BigDecimal getValor() {
//        return valor;
//    }
//
//
//    public void List<Produto> paginar(List<Produto> lista, int pagina, int tamanhoPagina) throws IllegalAccessException {
//        if (pagina < 1 || tamanhoPagina < 1) {
//            throw new IllegalAccessException("Página e tamanho devem ser maiores quue zero");
//
//            return lista.stream()
//                    .skip((long) (pagina - 1) * tamanhoPagina)
//                    .limit(tamanhoPagina)
//                    .collect(Collectors.toList());
//        }
//
//    }

    @Override
    public String toString() {
        return "Produto{" +
                "sku='" + sku + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                '}';
    }
}
