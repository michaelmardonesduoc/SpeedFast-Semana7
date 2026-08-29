package speedfast;

// Clase principal, simula el sistema completo de SpeedFast
public class Main {

    public static void main(String[] args) {

        System.out.println("===== SISTEMA DE REPARTO SPEEDFAST =====\n");

        // Se crea un pedido de cada tipo (con su distancia en km)
        Pedido pedido1 = new PedidoComida(101, "Av. Italia 456", 4);
        Pedido pedido2 = new PedidoEncomienda(102, "Av. Santa Rosa 567", 7);
        Pedido pedido3 = new PedidoExpress(103, "Av. Apoquindo 1500", 3);

        // Se crea el controlador que maneja despacho, cancelación e historial
        ControladorDeEnvios controlador = new ControladorDeEnvios();

        // ===== PEDIDO 1: se procesa completo =====
        pedido1.mostrarResumen();
        pedido1.asignarRepartidor();                 // asignación automática (sobrescrita)
        pedido1.asignarRepartidor("Luis Díaz");      // asignación manual (sobrecargada)
        System.out.println("Tiempo estimado: " + pedido1.calcularTiempoEntrega() + " minutos");
        controlador.despachar();
        controlador.agregarAlHistorial("PedidoComida #101 - entregado por Luis Díaz");
        System.out.println();

        // ===== PEDIDO 2: se procesa completo =====
        pedido2.mostrarResumen();
        pedido2.asignarRepartidor();
        pedido2.asignarRepartidor("Daniela Tapia");
        System.out.println("Tiempo estimado: " + pedido2.calcularTiempoEntrega() + " minutos");
        controlador.despachar();
        controlador.agregarAlHistorial("PedidoEncomienda #102 - entregado por Daniela Tapia");
        System.out.println();

        // ===== PEDIDO 3: se cancela =====
        System.out.println("Cancelando Pedido Express #103...");
        controlador.cancelar();
        System.out.println();

        // ===== Se muestra el historial de entregas =====
        controlador.verHistorial();

        System.out.println("\n===== FIN DEL PROCESO =====");
    }
}