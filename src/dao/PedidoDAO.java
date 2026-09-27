package dao;

import modelo.Pedido;
import modelo.PedidoComida;
import modelo.PedidoEncomienda;
import modelo.PedidoExpress;
import modelo.EstadoPedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Operaciones de base de datos para los pedidos.
public class PedidoDAO {

    // Inserta un pedido en la base de datos usando PreparedStatement.
    public void guardar(Pedido pedido) {
        String sql = "INSERT INTO pedido (direccion, tipo, estado) VALUES (?, ?, ?)";
        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, pedido.getDireccionEntrega());
            ps.setString(2, obtenerTipo(pedido));
            ps.setString(3, pedido.getEstado().toString());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al guardar pedido: " + e.getMessage());
        }
    }

    // Devuelve todos los pedidos almacenados usando ResultSet.
    public List<Pedido> listarTodos() {
        List<Pedido> lista = new ArrayList<>();
        String sql = "SELECT id, direccion, tipo, estado FROM pedido";

        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String direccion = rs.getString("direccion");
                String tipo = rs.getString("tipo");
                String estado = rs.getString("estado");

                Pedido pedido;
                switch (tipo) {
                    case "COMIDA" -> pedido = new PedidoComida(id, direccion, 0);
                    case "ENCOMIENDA" -> pedido = new PedidoEncomienda(id, direccion, 0);
                    default -> pedido = new PedidoExpress(id, direccion, 0);
                }
                pedido.setEstado(EstadoPedido.valueOf(estado));
                lista.add(pedido);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar pedidos: " + e.getMessage());
        }
        return lista;
    }

    // Deriva el tipo (COMIDA, ENCOMIENDA, EXPRESS) desde la subclase del pedido.
    private String obtenerTipo(Pedido pedido) {
        String clase = pedido.getClass().getSimpleName(); // PedidoComida
        return clase.replace("Pedido", "").toUpperCase();  // COMIDA
    }
}