package speedfast;

// Clase principal
public class Main {

    public static void main(String[] args) {

        // Se crea un pedido de cada tipo (con su distancia en km)
        Pedido pedido1 = new PedidoComida(1, "Av. Italia 456", 4);
        Pedido pedido2 = new PedidoEncomienda(2, "Av. Independencia 123", 6);
        Pedido pedido3 = new PedidoExpress(3, "Av. Apoquindo 1500", 7);

        // Se guardan en un arreglo de tipo Pedido
        Pedido[] pedidos = { pedido1, pedido2, pedido3 };

        // Se recorre el arreglo mostrando los datos y el tiempo de cada uno
        for (Pedido pedido : pedidos) {
            pedido.mostrarResumen();
            System.out.println("Tiempo estimado de entrega: " + pedido.calcularTiempoEntrega() + " minutos");
            System.out.println();
        }
    }
}