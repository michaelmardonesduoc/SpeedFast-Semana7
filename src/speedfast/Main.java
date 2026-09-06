package speedfast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Clase principal, simula varios repartidores entregando en paralelo
public class Main {

    public static void main(String[] args) {

        System.out.println("===== SISTEMA DE REPARTO SPEEDFAST =====");
        System.out.println("Iniciando entregas en paralelo...\n");

        // Se crean algunos pedidos
        Pedido pedido1 = new PedidoComida(101, "Av. Italia 456", 4);
        Pedido pedido2 = new PedidoEncomienda(102, "Av. Santa Rosa 567", 7);
        Pedido pedido3 = new PedidoExpress(103, "Av. Apoquindo 1500", 3);
        Pedido pedido4 = new PedidoComida(104, "Av. Grecia 789", 5);
        Pedido pedido5 = new PedidoEncomienda(105, "Av. Matta 321", 6);
        Pedido pedido6 = new PedidoExpress(106, "Av. Vicuña 654", 8);

        // Se crean los repartidores y se les asignan pedidos
        Repartidor camila = new Repartidor("Camila");
        camila.agregarPedido(pedido1);
        camila.agregarPedido(pedido2);

        Repartidor luis = new Repartidor("Luis");
        luis.agregarPedido(pedido3);
        luis.agregarPedido(pedido4);

        Repartidor daniela = new Repartidor("Daniela");
        daniela.agregarPedido(pedido5);
        daniela.agregarPedido(pedido6);

        // Se crea el ExecutorService que ejecutará los repartidores en paralelo
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Se lanzan los tres repartidores como hilos
        executor.execute(camila);
        executor.execute(luis);
        executor.execute(daniela);

        // Se cierra el executor (no acepta más tareas, pero termina las actuales)
        executor.shutdown();
    }
}