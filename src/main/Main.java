package main;

import modelo.ControladorPedidos;
import vista.VentanaPrincipal;

public class Main {

    public static void main(String[] args) {
        // Controlador compartido: una sola lista para toda la aplicacion
        ControladorPedidos controlador = new ControladorPedidos();

        // Arranca la interfaz grafica
        new VentanaPrincipal(controlador);
    }
}