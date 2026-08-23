package speedfast;

// Pedido de encomienda
public class PedidoEncomienda extends Pedido {

    // Constructor
    public PedidoEncomienda(int idPedido, String direccionEntrega, int distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    // Fórmula: 20 min + 1.5 min por km (ajustado a entero)
    @Override
    public int calcularTiempoEntrega() {
        double tiempo = 20 + (1.5 * getDistanciaKm());
        return (int) tiempo;
    }
}