package vista;

import modelo.ControladorPedidos;
import modelo.Pedido;
import modelo.PedidoComida;
import modelo.PedidoEncomienda;
import modelo.PedidoExpress;

import javax.swing.*;
import java.awt.*;

// Formulario para registrar un nuevo pedido.
public class VentanaRegistroPedido extends JFrame {

    private final ControladorPedidos controlador;

    private final JTextField campoId = new JTextField();
    private final JTextField campoDireccion = new JTextField();
    private final JTextField campoDistancia = new JTextField();
    private final JComboBox<String> comboTipo =
            new JComboBox<>(new String[]{"Comida", "Encomienda", "Express"});

    public VentanaRegistroPedido(ControladorPedidos controlador) {
        this.controlador = controlador;

        setTitle("Registrar Pedido");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // solo cierra esta ventana
        setLocationRelativeTo(null);

        // Panel con etiquetas y campos en cuadricula
        JPanel panel = new JPanel(new GridLayout(5, 2, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panel.add(new JLabel("ID:"));
        panel.add(campoId);
        panel.add(new JLabel("Dirección:"));
        panel.add(campoDireccion);
        panel.add(new JLabel("Distancia (km):"));
        panel.add(campoDistancia);
        panel.add(new JLabel("Tipo:"));
        panel.add(comboTipo);

        JButton btnGuardar = new JButton("Guardar");
        panel.add(new JLabel()); // celda vacia para alinear
        panel.add(btnGuardar);

        add(panel);

        btnGuardar.addActionListener(e -> guardarPedido());

        setVisible(true);
    }

    private void guardarPedido() {
        String textoId = campoId.getText().trim();
        String direccion = campoDireccion.getText().trim();
        String textoDistancia = campoDistancia.getText().trim();

        // Validacion: campos vacios
        if (textoId.isEmpty() || direccion.isEmpty() || textoDistancia.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Todos los campos son obligatorios.",
                    "Error de validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validacion: ID y distancia deben ser numeros
        int id;
        int distancia;
        try {
            id = Integer.parseInt(textoId);
            distancia = Integer.parseInt(textoDistancia);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "El ID y la distancia deben ser números enteros.",
                    "Error de validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crea el pedido segun el tipo elegido
        String tipo = (String) comboTipo.getSelectedItem();
        Pedido pedido;
        switch (tipo) {
            case "Comida" -> pedido = new PedidoComida(id, direccion, distancia);
            case "Encomienda" -> pedido = new PedidoEncomienda(id, direccion, distancia);
            default -> pedido = new PedidoExpress(id, direccion, distancia);
        }

        controlador.agregarPedido(pedido);

        JOptionPane.showMessageDialog(this,
                "Pedido #" + id + " registrado correctamente.",
                "Confirmación", JOptionPane.INFORMATION_MESSAGE);

        dispose(); // cierra el formulario al guardar
    }
}