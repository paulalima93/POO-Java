public class Evento {
    private String nome;
    private String ingresso;
    private double valorIngresso;
    private String data;
    private int totalParticipantes;

    public Evento(String nome, String ingresso, double valorIngresso, String data) {
        this.nome = nome;
        this.ingresso = ingresso;
        this.valorIngresso = valorIngresso;
        this.data = data;
        this.totalParticipantes = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getIngresso() {
        return ingresso;
    }

    public double getValorIngresso() {
        return valorIngresso;
    }

    public String getData() {
        return data;
    }

    public int getTotalParticipantes() {
        return totalParticipantes;
    }

    public void adicionarParticipantes(int quantidade) {
        this.totalParticipantes += quantidade;
    }

    public double calcularReceita() {
        return totalParticipantes * valorIngresso;
    }
}
