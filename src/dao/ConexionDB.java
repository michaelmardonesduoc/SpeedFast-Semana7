package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Gestiona la conexion con la base de datos MySQL.
public class ConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/speedfast_db";
    private static final String USER = "root";
    private static final String PASSWORD = "kjkszpj2003MY";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}