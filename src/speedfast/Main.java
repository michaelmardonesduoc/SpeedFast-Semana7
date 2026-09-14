package speedfast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // 1. Zona de carga compartida
        ZonaDeCarga zona = new ZonaDeCarga();

        // 2. Crea los pedidos con tus subclases.
        //    Si tus subclases piden datos extra, usa tus lineas originales
        //    (solo manten los nombres pedido1, pedido2, ...).
        Pedido pedido1 = new PedidoComida(101, "Santiago Centro", 5);
        Pedido pedido2 = new PedidoEncomienda(102, "Providencia", 8);
        Pedido pedido3 = new PedidoExpress(103, "Ñuñoa", 3);
        Pedido pedido4 = new PedidoComida(104, "Recoleta", 6);
        Pedido pedido5 = new PedidoEncomienda(105, "Las Condes", 10);

        // Se agregan a la zona compartida
        zona.agregarPedido(pedido1);
        zona.agregarPedido(pedido2);
        zona.agregarPedido(pedido3);
        zona.agregarPedido(pedido4);
        zona.agregarPedido(pedido5);
        System.out.println();

        // 3. Tres repartidores compartiendo la misma zona
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(new Repartidor("Juan", zona));
        executor.execute(new Repartidor("Camila", zona));
        executor.execute(new Repartidor("Pedro", zona));

        // 4. Esperar a que terminen todos
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        // 5. Mensaje final
        System.out.println("[Zona de carga vacía]");
        System.out.println();
        System.out.println("Todos los pedidos han sido entregados correctamente");
    }
}