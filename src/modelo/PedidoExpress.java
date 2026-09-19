package modelo;

// Pedido express
public class PedidoExpress extends Pedido {

    // Constructor
    public PedidoExpress(int idPedido, String direccionEntrega, int distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    // Fórmula: 10 min base, si es mayor a 5 km se suman 5 min
    @Override
    public int calcularTiempoEntrega() {
        int tiempo = 10;
        if (getDistanciaKm() > 5) {
            tiempo = tiempo + 5;
        }
        return tiempo;
    }
}