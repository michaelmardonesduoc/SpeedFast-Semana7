package modelo;

import java.util.ArrayList;

// Controlador que gestiona el despacho, cancelación e historial de pedidos.
// Implementa las tres interfaces del sistema.
public class ControladorDeEnvios implements Despachable, Cancelable, Rastreable {

    // Lista donde se guarda el historial de entregas realizadas
    private ArrayList<String> historial = new ArrayList<>();

    // Despacha un pedido y lo agrega al historial
    @Override
    public void despachar() {
        System.out.println("Pedido despachado correctamente.");
    }

    // Cancela un pedido
    @Override
    public void cancelar() {
        System.out.println("Pedido cancelado exitosamente.");
    }

    // Muestra el historial de entregas
    @Override
    public void verHistorial() {
        System.out.println("Historial de entregas:");
        if (historial.isEmpty()) {
            System.out.println("No hay entregas registradas.");
        } else {
            for (String entrega : historial) {
                System.out.println("- " + entrega);
            }
        }
    }

    // Metodo para agregar una entrega al historial
    public void agregarAlHistorial(String entrega) {
        historial.add(entrega);
    }
}