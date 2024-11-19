import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class SistemaDeRestaurante {
    private List<ItemDoPedido> cardapio;
    private Map<Integer, Mesa> mesas;

    public SistemaDeRestaurante() {
        this.cardapio = new ArrayList<>();
        this.mesas = new HashMap<>();
    }

    public void adicionarItemAoCardapio(String nome, double valor) {
        ItemDoPedido item = new ItemDoPedido(nome, valor);
        cardapio.add(item);
        System.out.println("Item adicionado ao cardápio com sucesso.");
    }

    public void exibirCardapio() {
        System.out.println("=== Cardápio ===");
        for (int i = 0; i < cardapio.size(); i++) {
            System.out.println((i + 1) + ". " + cardapio.get(i).detalhes());
        }
    }

    public void registrarPedido(int numeroMesa, Pedido pedido) {
        if (!mesas.containsKey(numeroMesa)) {
            mesas.put(numeroMesa, new Mesa(numeroMesa));
        }
        mesas.get(numeroMesa).adicionarPedido(pedido);
        System.out.println("Pedido registrado na mesa " + numeroMesa);
    }

    public void checarMesas() {
        if (mesas.isEmpty()) {
            System.out.println("Nenhuma mesa fez pedidos.");
            return;
        }
        System.out.println("=== Mesas com Pedidos ===");
        for (Mesa mesa : mesas.values()) {
            System.out.println(mesa.listarPedidosDaMesa());
        }
    }

    
    public void getItemMaisPedido() {
        List<ItemDoPedido> todosItens = new ArrayList<>();
        
        
        for (Mesa mesa : mesas.values()) {
            for (Pedido pedido : mesa.getPedidos()) { 
                todosItens.addAll(pedido.getItens());  
            }
        }

       
        if (todosItens.isEmpty()) {
            System.out.println("Nenhum pedido foi feito.");
            return;
        }

        
        ItemDoPedido itemMaisFrequente = null;
        int maxFrequencia = 0;

        for (ItemDoPedido item : todosItens) {
            int frequencia = Collections.frequency(todosItens, item);
            if (frequencia > maxFrequencia) {
                maxFrequencia = frequencia;
                itemMaisFrequente = item;
            }
        }

        System.out.println("O Prato Mais Pedido no Restaurante é: " + itemMaisFrequente.detalhes());
        
    }

    public ItemDoPedido getItemDoCardapio(int indice) {
        if (indice < 0 || indice >= cardapio.size()) {
            return null;
        }
        return cardapio.get(indice);
    }
}
