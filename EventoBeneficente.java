public class EventoBeneficente {
    private String nome;
    private int quantidadeMarmitas;
    private Medico medicoPresente;
    private ItemDoPedido pratoEscolhido;
    private double valorTotalDoacao;

    public EventoBeneficente(String nome, int quantidadeMarmitas, Medico medicoPresente, ItemDoPedido pratoEscolhido) {
        this.nome = nome;
        this.quantidadeMarmitas = quantidadeMarmitas;
        this.medicoPresente = medicoPresente;
        this.pratoEscolhido = pratoEscolhido;
        this.valorTotalDoacao = pratoEscolhido.getValor() * quantidadeMarmitas;
    }

    public void mostrarDetalhes() {
        System.out.println("=== Evento Beneficente ===");
        System.out.println("Nome: " + nome);
        System.out.println("Médico Presente: " + medicoPresente.getNome() + " - Especialidade: " + medicoPresente.getEspecialidade());
        System.out.println("Prato Escolhido: " + pratoEscolhido.getNome() + " - Valor por marmita: R$ " + pratoEscolhido.getValor());
        System.out.println("Quantidade de Marmitas: " + quantidadeMarmitas);
        System.out.println("Valor Total da Doação: R$ " + valorTotalDoacao);
    }
}
