package speedfast;

import java.util.ArrayList;

// Representa un repartidor que entrega sus pedidos.
// Implementa Runnable para poder ejecutarse como un hilo.
public class Repartidor implements Runnable {

    // Atributos
    private String nombre;
    private ArrayList<Pedido> pedidosAsignados;

    // Constructor
    public Repartidor(String nombre) {
        this.nombre = nombre;
        this.pedidosAsignados = new ArrayList<>();
    }

    // Agrega un pedido a la lista del repartidor
    public void agregarPedido(Pedido pedido) {
        pedidosAsignados.add(pedido);
    }

    // Metodo que se ejecuta cuando el hilo arranca.
    // Recorre los pedidos y simula la entrega de cada uno.
    @Override
    public void run() {
        for (Pedido pedido : pedidosAsignados) {
            System.out.println("[Repartidor: " + nombre + "] Entregando " +
                    pedido.getClass().getSimpleName() + " #" + pedido.getIdPedido() + "...");

            // Simula el tiempo de entrega con una pausa aleatoria
            try {
                int pausa = (int) (Math.random() * 2000) + 500; // entre 500 y 2500 ms
                Thread.sleep(pausa);
            } catch (InterruptedException e) {
                System.out.println("La entrega de " + nombre + " fue interrumpida.");
            }

            System.out.println("[Repartidor: " + nombre + "] Pedido #" + pedido.getIdPedido() + " entregado.");
        }
    }
}