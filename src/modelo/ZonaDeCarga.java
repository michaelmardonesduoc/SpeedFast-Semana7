package modelo;

import java.util.LinkedList;
import java.util.Queue;

// Recurso compartido: aqui llegan los pedidos y los repartidores los retiran.
public class ZonaDeCarga {

    private final Queue<Pedido> pedidosPendientes;

    public ZonaDeCarga() {
        this.pedidosPendientes = new LinkedList<>();
        System.out.println("[Zona de carga inicializada]");
        System.out.println();
    }

    // synchronized: solo un hilo agrega a la vez
    public synchronized void agregarPedido(Pedido p) {
        pedidosPendientes.add(p);
        System.out.println("Pedido #" + p.getIdPedido() + " agregado. Destino: " + p.getDireccionEntrega());
    }

    // synchronized: evita que dos repartidores retiren el mismo pedido.
    // Devuelve null cuando ya no quedan pedidos.
    public synchronized Pedido retirarPedido() {
        return pedidosPendientes.poll();
    }
}