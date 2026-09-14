package speedfast;

// Clase abstracta, base de todos los pedidos
public abstract class Pedido {

    // Atributos comunes
    private int idPedido;
    private String direccionEntrega;
    private int distanciaKm;
    private EstadoPedido estado;

    // Constructor
    public Pedido(int idPedido, String direccionEntrega, int distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.estado = EstadoPedido.PENDIENTE;
    }

    // Getters y setters
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public int getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(int distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    // Muestra los datos del pedido
    public void mostrarResumen() {
        System.out.println(getClass().getSimpleName() + " #" + idPedido);
        System.out.println("Dirección: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
    }

    // Metodo abstracto, cada subclase calcula su tiempo
    public abstract int calcularTiempoEntrega();

    // Metodo generico, cada subclase lo sobrescribe
    public void asignarRepartidor() {
        System.out.println("Asignando un repartidor al pedido #" + idPedido + ".");
    }

    // Metodo sobrecargado, recibe el nombre del repartidor
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Repartidor asignado: " + nombreRepartidor);
    }
}