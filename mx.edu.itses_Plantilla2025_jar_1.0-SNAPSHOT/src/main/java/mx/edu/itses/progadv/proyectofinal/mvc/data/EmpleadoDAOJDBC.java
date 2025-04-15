/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.progadv.proyectofinal.mvc.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.edu.itses.progadv.proyectofinal.mvc.models.Empleado;
import static mx.edu.itses.progadv.proyectofinal.mvc.data.Conexion.*;
import mx.edu.itses.progadv.proyectofinal.mvc.functions.Padvf;

/**
 *
 * @author Administrador
 */
public class EmpleadoDAOJDBC implements EmpleadoDAO {

    private static final String SQL_SELECT = "SELECT t1.id,t1.nombre,t1.apellidos,t2.departamento FROM empleados AS t1 LEFT JOIN departamentos AS t2 ON t2.id =t1.departamento";
    private static final String SQL_INSERT = "INSERT INTO empleados(id,nombre,apellidos,departamento) VALUES(?,?,?,?)";
    private static final String SQL_READ = "SELECT * FROM empleados WHERE id=?";
    private static final String SQL_UPDATE = "UPDATE empleados SET nombre=?, apellidos=?,departamento=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM empleados WHERE id=?";
    private static final String SQL_SELECT_DEPARTAMENTOS = "SELECT id,departamento FROM departamentos";

    public EmpleadoDAOJDBC() {
    }

    @Override
    public List<Empleado> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Empleado> empleados = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String departamento = rs.getString("departamento");
                Empleado empleado = new Empleado(id, nombre, apellidos, departamento);
                empleados.add(empleado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }

        return empleados;

    }

    @Override
    public int insert(Empleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int newregistry = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, Padvf.IDGenerator());
            stmt.setString(2, empleado.getNombre());
            stmt.setString(3, empleado.getApellidos());
            stmt.setString(4, empleado.getDepartamento());
            newregistry = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }

        return newregistry;
    }

    @Override
    public Empleado read(String id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empleado model = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_READ);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idEmpleado = rs.getString("id");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String departamento = rs.getString("departamento");
                model = new Empleado(id, nombre, apellidos, departamento);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        if (model == null) {
            model = new Empleado("ID no encontrado", "", "", "");
        }
        return model;
    }

    @Override
    public int update(Empleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int updateregistry = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getApellidos());
            stmt.setString(3, empleado.getDepartamento());
            stmt.setString(4, empleado.getId());
            updateregistry = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }

        return updateregistry;
    }

    @Override
    public int delete(String id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int deleterow = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, id);
            deleterow = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return deleterow;
    }

    @Override
    public Map<String, String> departamentos() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Map<String, String> departamentos = new HashMap<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_DEPARTAMENTOS);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String departamento = rs.getString("departamento");
                departamentos.put(id,departamento);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }

        return departamentos;
    }
}
