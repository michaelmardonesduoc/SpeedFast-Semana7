package modelo;

// Repartidor que retira y entrega pedidos desde la zona de carga compartida.
public class Repartidor implements Runnable {

    private String nombre;
    private ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run() {
        Pedido pedido;

        // Retira pedidos hasta que la zona quede vacia (retirarPedido devuelve null).
        while ((pedido = zonaDeCarga.retirarPedido()) != null) {

            System.out.println("[Repartidor - " + nombre + "] Retirando pedido #" + pedido.getIdPedido() + "...");
            pedido.setEstado(EstadoPedido.EN_REPARTO);
            System.out.println("[Repartidor - " + nombre + "] Estado: " + pedido.getEstado());

            // Simula el tiempo de entrega
            try {
                int pausa = (int) (Math.random() * 2000) + 500; // entre 500 y 2500 ms
                Thread.sleep(pausa);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println("[Repartidor - " + nombre + "] Entregando pedido #" + pedido.getIdPedido() + "...");
            pedido.setEstado(EstadoPedido.ENTREGADO);
            System.out.println("[Repartidor - " + nombre + "] Estado: " + pedido.getEstado());
            System.out.println();
        }
    }
}