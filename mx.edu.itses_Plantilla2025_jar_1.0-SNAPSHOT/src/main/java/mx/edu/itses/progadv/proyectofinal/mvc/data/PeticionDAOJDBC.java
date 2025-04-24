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
import mx.edu.itses.progadv.proyectofinal.mvc.models.Peticion;

/**
 *
 * @author Administrador
 */
public class PeticionDAOJDBC implements PeticionDAO {

    private static final String SQL_SELECT = "SELECT t1.id,t1.libro, t2.nombre_cliente, t4.editorial, t1.cantidad, t5.estado FROM solicitudes AS t1 LEFT JOIN clientes AS t2 ON t2.nombre_cliente =t1.id_clientes LEFT JOIN editoriales AS t4 ON t4.id =t1.id_editoriales LEFT JOIN estados_solicitud AS t5 ON t5.id = t1.id_estados_solicitud";
    private static final String SQL_INSERT = "INSERT INTO solicitudes(id,id_clientes,libro, id_editoriales, cantidad, id_estados_solicitud) VALUES(?,?,?,?,?,?)";
    private static final String SQL_READ = "SELECT * FROM solicitudes WHERE id=?";
    private static final String SQL_UPDATE = "UPDATE solicitudes SET libro=?, id_editoriales=?,id_clientes=?, cantidad=?, id_estados_solicitud=?  WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM solicitudes WHERE id=?";
    private static final String SQL_SELECT_EDITORIALES = "SELECT id,editorial FROM editoriales";
    private static final String SQL_SELECT_ESTADOS = "SELECT id,estado FROM estados_solicitud";

    public PeticionDAOJDBC() {
    }

    
    // Se conecta a la base de datos y  obtienen los valores que se encuentran dentro de la base 
    // de datos y se añaden a una nueva lista que ´la contendrá
    
    // El nombre entre comillas (e.g. 'nombre_cliente') es el nombre que tiene la columna en la base de datos
    @Override
    public List<Peticion> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Peticion> peticiones = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String libro = rs.getString("libro");
                String editorial = rs.getString("editorial");
                String clienteSolicitando = rs.getString("nombre_cliente");
                int cantidadSolicitada = rs.getInt("cantidad");
                String estadoSolicitud = rs.getString("estado");
                Peticion peticion = new Peticion(id, libro, editorial, clienteSolicitando, cantidadSolicitada, estadoSolicitud);
                peticiones.add(peticion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }

        return peticiones;

    }

    //Se conecta a la base de datos y se inserta los valores que se encuentran en la petición
    @Override
    public int insert(Peticion peticion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int newregistry = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, Padvf.IDGenerator());
            stmt.setString(2, peticion.getNombre());
            stmt.setString(3, peticion.getEditorial());
            stmt.setString(4, peticion.getClienteSolicitando());
            stmt.setInt(5, peticion.getCantidadSolicitada());
            stmt.setString(6, peticion.getEstadoSolicitud());
            
            newregistry = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }

        return newregistry;
    }

    //Obtiene los valores de la petición seleccionada 
    
    @Override
    public Peticion read(String id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Peticion model = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_READ);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idPeticion = rs.getString("id");
                String nombre = rs.getString("libro");
                String editorial = rs.getString("id_editoriales");
                 String clienteSolicitando = rs.getString("id_clientes");
                int cantidadSolicitada = rs.getInt("cantidad");
                String estadoSolicitud = rs.getString("id_estados_solicitud");
                model = new Peticion(id, nombre, editorial, clienteSolicitando, cantidadSolicitada, estadoSolicitud);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        if (model == null) {
            model = new Peticion("ID no encontrado", "", "", "", 0, "");
        }
        return model;
    }

    
    // Actualiza los valores de la petición
    @Override
    public int update(Peticion peticion) {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int updateregistry = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, peticion.getEditorial());
            stmt.setString(2, peticion.getClienteSolicitando());
            stmt.setString(3, peticion.getNombre());
            stmt.setInt(4, peticion.getCantidadSolicitada());
            stmt.setString(5, peticion.getEstadoSolicitud());
            stmt.setString(6, peticion.getId());
            updateregistry = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }

        return updateregistry;
    }

    

    // Elimina la petición
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

    // Método para el mapeado de las editoriales (que se encuentran en otra tabla)
    @Override
    public Map<String, String> editoriales() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Map<String, String> editoriales = new HashMap<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_EDITORIALES);
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
    
      // Método para el mapeado de los estados (que se encuentran en otra tabla)
    @Override
    public Map<String, String> estados() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Map<String, String> estados = new HashMap<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ESTADOS);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String estado = rs.getString("estado");
                estados.put(id,estado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }

        return estados;
    }
}
