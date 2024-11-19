public class ItemDoPedido {
    private String nome;
    private double valor;

    public ItemDoPedido(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public String detalhes() {
        return nome + " - R$ " + valor;
    }
}
