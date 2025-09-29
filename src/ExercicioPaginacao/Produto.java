package ExercicioPaginacao;

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

    public String getSku() {
        return sku;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
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
