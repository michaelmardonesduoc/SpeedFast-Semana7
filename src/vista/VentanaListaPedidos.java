package vista;

import modelo.ControladorPedidos;
import modelo.Pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

// Muestra los pedidos en una tabla.
public class VentanaListaPedidos extends JFrame {

    public VentanaListaPedidos(ControladorPedidos controlador) {

        setTitle("Lista de Pedidos");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Columnas de la tabla
        String[] columnas = {"ID", "Dirección", "Distancia (km)", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // Llena la tabla con los pedidos actuales
        for (Pedido pedido : controlador.getPedidos()) {
            Object[] fila = {
                    pedido.getIdPedido(),
                    pedido.getDireccionEntrega(),
                    pedido.getDistanciaKm(),
                    pedido.getEstado()
            };
            modelo.addRow(fila);
        }

        JTable tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla); // barra de desplazamiento

        add(scroll, BorderLayout.CENTER);

        setVisible(true);
    }
}