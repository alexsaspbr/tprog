package exercicios_stream.exercicio5;

import java.math.BigDecimal;

public class Produto {

    private String nome;
    private BigDecimal preco;
    private String categoria;

    public Produto(String nome, BigDecimal preco, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }


    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
