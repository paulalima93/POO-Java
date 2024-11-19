public class Participante {
    private String nome;
    private String tipoIngresso;

    public Participante(String nome, String tipoIngresso) {
        this.nome = nome;
        this.tipoIngresso = tipoIngresso;
    }

    public String getNome() {
        return nome;
    }

    public String getTipoIngresso() {
        return tipoIngresso;
    }
}
