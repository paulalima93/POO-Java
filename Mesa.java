import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private int numero;
    private List<Pedido> pedidos;

    public Mesa(int numero) {
        this.numero = numero;
        this.pedidos = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
    
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public double calcularTotalMesa() {
        double total = 0;
        for (Pedido pedido : pedidos) {
            total += pedido.calcularTotal();
        }
        return total;
    }

    public String listarPedidosDaMesa() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mesa ").append(numero).append(":\n");
        for (Pedido pedido : pedidos) {
            sb.append(pedido.listarItens()).append("\n");
        }
        sb.append("Total da Mesa: R$ ").append(calcularTotalMesa());
        return sb.toString();
    }
}
