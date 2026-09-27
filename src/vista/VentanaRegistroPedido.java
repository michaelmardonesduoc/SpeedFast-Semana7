package vista;

import dao.PedidoDAO;
import modelo.Pedido;
import modelo.PedidoComida;
import modelo.PedidoEncomienda;
import modelo.PedidoExpress;

import javax.swing.*;
import java.awt.*;

// Formulario para registrar un pedido en la base de datos.
public class VentanaRegistroPedido extends JFrame {

    private final JTextField campoDireccion = new JTextField();
    private final JComboBox<String> comboTipo =
            new JComboBox<>(new String[]{"Comida", "Encomienda", "Express"});

    private final PedidoDAO pedidoDAO = new PedidoDAO();

    public VentanaRegistroPedido() {
        setTitle("Registrar Pedido");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panel.add(new JLabel("Dirección:"));
        panel.add(campoDireccion);
        panel.add(new JLabel("Tipo:"));
        panel.add(comboTipo);

        JButton btnGuardar = new JButton("Guardar");
        panel.add(new JLabel());
        panel.add(btnGuardar);

        add(panel);

        btnGuardar.addActionListener(e -> guardarPedido());

        setVisible(true);
    }

    private void guardarPedido() {
        String direccion = campoDireccion.getText().trim();

        // Validacion: la direccion no puede estar vacia
        if (direccion.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "La dirección es obligatoria.",
                    "Error de validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crea el pedido segun el tipo elegido (el ID lo asigna la base de datos)
        String tipo = (String) comboTipo.getSelectedItem();
        Pedido pedido;
        switch (tipo) {
            case "Comida" -> pedido = new PedidoComida(0, direccion, 0);
            case "Encomienda" -> pedido = new PedidoEncomienda(0, direccion, 0);
            default -> pedido = new PedidoExpress(0, direccion, 0);
        }

        pedidoDAO.guardar(pedido);

        JOptionPane.showMessageDialog(this,
                "Pedido registrado correctamente en la base de datos.",
                "Confirmación", JOptionPane.INFORMATION_MESSAGE);

        dispose();
    }
}