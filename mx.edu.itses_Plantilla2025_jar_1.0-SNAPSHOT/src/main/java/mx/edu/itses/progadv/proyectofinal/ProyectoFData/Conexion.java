package mx.edu.itses.progadv.proyectofinal.ProyectoFData;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.*;

/**
 *
 * @author Administrador
 */
public class Conexion {

    //modificar lo necesario para la base de datos
    private static final String JDBC_URL = "jdbc:postgresql://127.0.0.1:5432/testlibreria_db";
    private static final String JDBC_USERNAME = "jmtg";
    private static final String JDBC_PASSWORD = "postgres";

    public static Connection getConnection() throws SQLException {
        Connection conexion = null;

        conexion = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);

        return conexion;
    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement stmt) {
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
