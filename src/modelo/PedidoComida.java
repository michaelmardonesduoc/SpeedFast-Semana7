package modelo;

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

    // Sobrescritura: repartidor con mochila térmica
    @Override
    public void asignarRepartidor() {
        System.out.println("Asignando repartidor con mochila térmica para el pedido #" + getIdPedido() + ".");
    }
}