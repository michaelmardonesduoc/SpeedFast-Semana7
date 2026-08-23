package speedfast;

// Pedido de comida
public class PedidoComida extends Pedido {

    // Constructor
    public PedidoComida(int idPedido, String direccionEntrega, int distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    // Fórmula: 15 min + 2 min por km
    @Override
    public int calcularTiempoEntrega() {
        return 15 + (2 * getDistanciaKm());
    }
}