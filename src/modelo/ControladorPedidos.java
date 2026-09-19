package modelo;

import java.util.ArrayList;
import java.util.List;

// Guarda la lista de pedidos en memoria y la comparte entre las ventanas.
public class ControladorPedidos {

    private final List<Pedido> pedidos;

    public ControladorPedidos() {
        this.pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}