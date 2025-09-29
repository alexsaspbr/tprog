package ada.tech.desafiostream;

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
}