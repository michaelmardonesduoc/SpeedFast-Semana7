package vista;

import dao.EntregaDAO;
import dao.PedidoDAO;
import dao.RepartidorDAO;
import modelo.Entrega;
import modelo.Pedido;
import modelo.Repartidor;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

// Ventana principal con la navegacion del sistema.
public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        setTitle("SpeedFast - Gestión de Entregas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titulo = new JLabel("Sistema de Gestión SpeedFast", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(titulo, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridLayout(3, 1, 10, 10));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 40, 30, 40));

        JButton btnRegistrar = new JButton("Registrar Pedido");
        JButton btnListar = new JButton("Listar Pedidos");
        JButton btnAsignar = new JButton("Asignar Repartidor / Iniciar Entrega");

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnListar);
        panelBotones.add(btnAsignar);
        add(panelBotones, BorderLayout.CENTER);

        btnRegistrar.addActionListener(e -> new VentanaRegistroPedido());
        btnListar.addActionListener(e -> new VentanaListaPedidos());
        btnAsignar.addActionListener(e -> asignarEntrega());

        setVisible(true);
    }

    // Pide un repartidor, lo guarda y registra una entrega para el primer pedido.
    private void asignarEntrega() {
        PedidoDAO pedidoDAO = new PedidoDAO();
        RepartidorDAO repartidorDAO = new RepartidorDAO();
        EntregaDAO entregaDAO = new EntregaDAO();

        List<Pedido> pedidos = pedidoDAO.listarTodos();
        if (pedidos.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No hay pedidos registrados para asignar.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nombre = JOptionPane.showInputDialog(this,
                "Nombre del repartidor que realizará la entrega:");
        if (nombre == null || nombre.trim().isEmpty()) {
            return;
        }

        // Guarda el repartidor en la base de datos
        repartidorDAO.guardar(new Repartidor(nombre.trim()));

        // Recupera el repartidor recien insertado (el ultimo de la lista)
        List<Repartidor> repartidores = repartidorDAO.listarTodos();
        Repartidor repartidor = repartidores.get(repartidores.size() - 1);

        // Toma el primer pedido y registra la entrega
        Pedido pedido = pedidos.get(0);
        Entrega entrega = new Entrega(
                pedido.getIdPedido(),
                repartidor.getId(),
                LocalDate.now(),
                LocalTime.now());
        entregaDAO.guardar(entrega);

        JOptionPane.showMessageDialog(this,
                "Entrega registrada en la base de datos:\n" +
                        "Pedido #" + pedido.getIdPedido() +
                        " asignado a " + repartidor.getNombre(),
                "Entrega registrada", JOptionPane.INFORMATION_MESSAGE);
    }
}