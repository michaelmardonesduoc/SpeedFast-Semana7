package vista;

import dao.PedidoDAO;
import modelo.Pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

// Muestra en una tabla los pedidos leidos desde la base de datos.
public class VentanaListaPedidos extends JFrame {

    public VentanaListaPedidos() {
        setTitle("Lista de Pedidos");
        setSize(550, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnas = {"ID", "Dirección", "Tipo", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // Consulta los pedidos guardados en la base de datos
        PedidoDAO pedidoDAO = new PedidoDAO();
        List<Pedido> pedidos = pedidoDAO.listarTodos();

        for (Pedido pedido : pedidos) {
            String tipo = pedido.getClass().getSimpleName().replace("Pedido", "");
            Object[] fila = {
                    pedido.getIdPedido(),
                    pedido.getDireccionEntrega(),
                    tipo,
                    pedido.getEstado()
            };
            modelo.addRow(fila);
        }

        JTable tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);

        setVisible(true);
    }
}