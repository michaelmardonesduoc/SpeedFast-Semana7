package vista;

import modelo.ControladorPedidos;

import javax.swing.*;
import java.awt.*;

// Ventana principal con los botones de navegacion.
public class VentanaPrincipal extends JFrame {

    private final ControladorPedidos controlador;

    public VentanaPrincipal(ControladorPedidos controlador) {
        this.controlador = controlador;

        setTitle("SpeedFast - Gestión de Entregas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // centra la ventana en la pantalla

        // Titulo arriba
        JLabel titulo = new JLabel("Sistema de Gestión SpeedFast", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(titulo, BorderLayout.NORTH);

        // Panel central con los botones, uno debajo del otro
        JPanel panelBotones = new JPanel(new GridLayout(3, 1, 10, 10));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 40, 30, 40));

        JButton btnRegistrar = new JButton("Registrar Pedido");
        JButton btnListar = new JButton("Listar Pedidos");
        JButton btnAsignar = new JButton("Asignar Repartidor / Iniciar Entrega");

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnListar);
        panelBotones.add(btnAsignar);
        add(panelBotones, BorderLayout.CENTER);

        // Acciones de los botones
        btnRegistrar.addActionListener(e -> new VentanaRegistroPedido(controlador));

        btnListar.addActionListener(e -> new VentanaListaPedidos(controlador));

        btnAsignar.addActionListener(e -> asignarRepartidor());

        setVisible(true);
    }

    // Toma el primer pedido pendiente y simula el inicio de la entrega
    private void asignarRepartidor() {
        if (controlador.getPedidos().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No hay pedidos registrados para asignar.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        StringBuilder mensaje = new StringBuilder("Repartidores asignados. Iniciando entregas:\n\n");
        for (var pedido : controlador.getPedidos()) {
            mensaje.append("Pedido #").append(pedido.getIdPedido())
                    .append(" -> ").append(pedido.getDireccionEntrega())
                    .append(" (EN_REPARTO)\n");
        }

        JOptionPane.showMessageDialog(this, mensaje.toString(),
                "Asignación de entregas", JOptionPane.INFORMATION_MESSAGE);
    }
}