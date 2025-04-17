/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.progadv.proyectofinal.ProyectoFData;

import mx.edu.itses.progadv.proyectofinal.mvc.data.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.edu.itses.progadv.proyectofinal.ProyectoFModelo.Libro;
import mx.edu.itses.progadv.proyectofinal.mvc.models.Empleado;
import static mx.edu.itses.progadv.proyectofinal.mvc.data.Conexion.*;
import mx.edu.itses.progadv.proyectofinal.mvc.functions.Padvf;

/**
 *
 * @author Administrador
 */
public class LibroDAOJDBC implements LibroDAO {

    private static final String SQL_SELECT = "SELECT t1.id,t1.nombre,t1.apellidos,t2.departamento FROM empleados AS t1 LEFT JOIN departamentos AS t2 ON t2.id =t1.departamento";
    private static final String SQL_INSERT = "INSERT INTO empleados(id,nombre,apellidos,departamento) VALUES(?,?,?,?)";
    private static final String SQL_READ = "SELECT * FROM empleados WHERE id=?";
    private static final String SQL_UPDATE = "UPDATE empleados SET nombre=?, apellidos=?,departamento=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM empleados WHERE id=?";
    private static final String SQL_SELECT_DEPARTAMENTOS = "SELECT id,departamento FROM departamentos";

    public LibroDAOJDBC() {
    }

    @Override
    public List<Libro> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Libro> libros= new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String nombre_del_libro_a_solicitar = rs.getString("nombre");
                String editorial = rs.getString("editoriales");
                String cliente_que_solicita = rs.getString("Cliente que solicita");
                int cantidad_solicitada = rs.getInt("Cantidad solicitada");
                String estado_Solicitud = rs.getString("Estado de solicitud");
                Libro libro = new Libro(id, nombre_del_libro_a_solicitar, cliente_que_solicita, cantidad_solicitada, estado_Solicitud);
                libros.add(libro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }

        return libros;

    }

    @Override
    public int insert(Libro libro) {
        /*
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
        */
        return 0;
    }

  
    @Override
    public Libro read(String id) {
          /*
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
        */
          return null;
    }

 
    @Override
    public int update(Libro libro) {
           /*
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
*/
           return 0;
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
    public Map<String, String> editoriales() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Map<String, String> editoriales = new HashMap<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_DEPARTAMENTOS);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String editorial = rs.getString("editorial");
                editoriales.put(id,editorial);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }

        return editoriales;
    }
}
