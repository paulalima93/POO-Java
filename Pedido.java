import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Pedido {
    private List<ItemDoPedido> itens;

    public Pedido() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemDoPedido item) {
        itens.add(item);
    }
    
    
    public List<ItemDoPedido> getItens() {
        return itens;
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemDoPedido item : itens) {
            total += item.getValor();
        }
        return total;
    }
    

    public String listarItens() {
        StringBuilder sb = new StringBuilder();
        for (ItemDoPedido item : itens) {
            sb.append(item.detalhes()).append("\n");
        }
        sb.append("Total do Pedido: R$ ").append(calcularTotal());
        return sb.toString();
    }
}
