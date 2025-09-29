import java.util.Objects;

public class Produto {
    private String nome;
    private double preco;
    private String categoria;

    public Produto(String nome, double preco, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    // Getters
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public String getCategoria() { return categoria; }

    @Override
    public String toString() {
        return String.format("Produto{nome='%s', preco=%.2f, categoria='%s'}",
                nome, preco, categoria);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Double.compare(produto.preco, preco) == 0 &&
                Objects.equals(nome, produto.nome) &&
                Objects.equals(categoria, produto.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, preco, categoria);
    }
}