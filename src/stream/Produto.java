package stream;

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


    @Override
    public String toString() {
        return "Produto{" +
                "sku='" + sku + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                '}';
    }
}
