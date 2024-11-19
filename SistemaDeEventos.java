import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class SistemaDeEventos {
    private List<Evento> eventos;

    public SistemaDeEventos() {
        this.eventos = new ArrayList<>();
    }

    public void registrarEvento(String nome, String ingresso, double valorIngresso, String data) {
        Evento evento = new Evento(nome, ingresso, valorIngresso, data);
        eventos.add(evento);
        System.out.println("Evento registrado com sucesso.");
    }

    public void registrarParticipantes(String nomeEvento, String tipoIngresso, int quantidade) {
        Evento evento = buscarEvento(nomeEvento);
        if (evento == null) {
            System.out.println("Evento não encontrado.");
            return;
        }

        evento.adicionarParticipantes(quantidade);
        System.out.println("Participantes registrados com sucesso.");
    }

    public void verificarLotacao(String nomeEvento) {
        Evento evento = buscarEvento(nomeEvento);
        if (evento == null) {
            System.out.println("Evento não encontrado.");
            return;
        }
        double receita = evento.calcularReceita();
        System.out.println("A lotação do evento " + evento.getNome() + " gerou uma receita de: R$ " + receita);
    }
    
    public void verificarEventos() {
        System.out.print(" Relatorio de eventos: "); 
        
        for (Evento evento: eventos) {
            System.out.println(": " + evento.getNome() + " gerou uma receita de: R$ " + evento.calcularReceita());   
        }
    }

    private Evento buscarEvento(String nome) {
        for (Evento evento : eventos) {
            if (evento.getNome().equalsIgnoreCase(nome)) {
                return evento;
            }
        }
        return null;
    }
}
