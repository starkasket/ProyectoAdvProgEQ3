/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.progadv.proyectofinal.mvc.controllers;

import java.sql.*;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mx.edu.itses.progadv.proyectofinal.mvc.data.Conexion;
import mx.edu.itses.progadv.proyectofinal.mvc.data.PeticionDAOJDBC;
import mx.edu.itses.progadv.proyectofinal.mvc.models.Peticion;
import mx.edu.itses.progadv.proyectofinal.mvc.views.peticiones.PeticionView;

/**
 *
 * @author Administrador
 */public class PeticionController {

    private static Peticion model;
    private static PeticionView view;

    public PeticionController(Peticion model, PeticionView view) {
        this.model = model;
        this.view = view;
    }

    public void CRUDPeticion() {
        view.CRUDPeticion(model);
        //IMPORTANTE
        // CUANDO SE CREA POR PRIMERA VEZ EL FORMULARIO HAY QUE INVOCAR EL MÉTODO INDEX DESPUES
        // DE QUE EL FORMULARIO ESTA VISIBLE
        // VER EL FORMULARIO CRUDPeticion LINEA 76
        //index();

    }

    // Crea una petición de libro 
    public static void createPeticion() {
        PeticionDAOJDBC peticionDao = new PeticionDAOJDBC();
        Map<String, String> editoriales = peticionDao.editoriales();
        for (Map.Entry<String, String> editorial : editoriales.entrySet()) {
            System.out.println("ID:" + editorial.getKey());
            System.out.println("Valor:" + editorial.getValue());
        }
        Map<String, String> estados = peticionDao.estados();
        for (Map.Entry<String, String> estado : estados.entrySet()) {
            System.out.println("ID:" + estado.getKey());
            System.out.println("Valor:" + estado.getValue());
        }
        Map<String, String> clienteSolicitando = peticionDao.clientes();
        for (Map.Entry<String, String> cliente : clienteSolicitando.entrySet()) {
            System.out.println("ID:" + cliente.getKey());
            System.out.println("Valor:" + cliente.getValue());
        }
        Map<String, String> empleados = peticionDao.empleados();
        for (Map.Entry<String, String> empleado : empleados.entrySet()) {
            System.out.println("ID:" + empleado.getKey());
            System.out.println("Valor:" + empleado.getValue());
        }
        view.createPeticion(editoriales, estados, clienteSolicitando, empleados);
    }

    //Método de lectura de la petición seleccionada
    public static void readPeticion() {
        model = findModel(view.getTableRow());
        view.readPeticion(model);

    }

    //Método para actualizar la petición seleccionada
    public static void updatePeticion() {
        //view.getTableRow(model);
        model = findModel(view.getTableRow());
        view.updatePeticion(model);

    }

    //Método para guardar una petición creada
    public static void guardarPeticion(String id, String editorial, String clienteSolicitando, String nombreLibro, int cantidadSolicitada, String estadoSolicitud, String empleado) {
        model.setId(id);
        model.setNombre(nombreLibro);
        model.setEditorial(editorial);
        model.setClienteSolicitando(clienteSolicitando);
        model.setCantidadSolicitada(cantidadSolicitada);
        model.setEstadoSolicitud(estadoSolicitud);
        model.setEmpleado(empleado);
        
        PeticionDAOJDBC peticionDao = new PeticionDAOJDBC();
        if (id.equals("")) {
            int registrosinsertados = peticionDao.insert(model);
            System.out.println("Se insertó :" + registrosinsertados);
        } else {
            int registrosmodificados = peticionDao.update(model);
            System.out.println("Se modifico :" + registrosmodificados);
        }

        index();
        //view.updateTable(model);
    }

    //Metodo para mostrar la petición (deprecated)
    public static void mostrarPeticion() {
     
         String peticion = "Nombre: " + model.getNombre() + " "  + "\n Editorial: " + model.getEditorial() + " " + "\nCliente:" + model.getClienteSolicitando() + " " + "\n Cantidad:" + model.getCantidadSolicitada() + " " + "\n Estado de su solicitud:" + model.getEstadoSolicitud() ;
        
        JOptionPane.showMessageDialog(null, peticion);
    }

    // Método con el cual se elimina la petición seleccionada
    public static void deletePeticion() {

        int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar el registro?", "Eliminar peticion", JOptionPane.YES_NO_OPTION);
        if (respuesta == 0) {
            String id = view.getTableRow();
            PeticionDAOJDBC peticionDao = new PeticionDAOJDBC();
            int deleterow = peticionDao.delete(id);
            if (deleterow == 1) {
                index();
                System.out.println("Registros eliminados: " + deleterow);
            }
        }

    }

    // Método para rellenar la tabla
    public static void index() {
        PeticionDAOJDBC peticionDao = new PeticionDAOJDBC();

        List<Peticion> peticiones = peticionDao.select();
        
        view.updateTable(peticiones);
    }
    
    
// Método para poder 'encontrar' el modelo que se usará
    public static Peticion findModel(String id) {
        Connection conn = null;
        Peticion model = null;
        try {
            conn = Conexion.getConnection();
            PeticionDAOJDBC peticionDaoJDB = new PeticionDAOJDBC();
            model = peticionDaoJDB.read(id);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
        }

        return model;
    }

}
