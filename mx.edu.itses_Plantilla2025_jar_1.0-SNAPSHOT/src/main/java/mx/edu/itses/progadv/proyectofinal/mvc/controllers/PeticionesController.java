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
import mx.edu.itses.progadv.proyectofinal.mvc.data.EmpleadoDAOJDBC;
import mx.edu.itses.progadv.proyectofinal.mvc.models.Empleado;
import mx.edu.itses.progadv.proyectofinal.mvc.views.empleado.EmpleadoView;

/**
 *
 * @author Administrador
 */
public class PeticionesController {

    private static Empleado model;
    private static EmpleadoView view;

    public PeticionesController(Empleado model, EmpleadoView view) {
        this.model = model;
        this.view = view;
    }

    public void CRUDEmpleado() {
        view.CRUDEmpleado(model);
        //IMPORTANTE
        // CUANDO SE CREA POR PRIMERA VEZ EL FORMULARIO HAY QUE INVOCAR EL MÉTODO INDEX DESPUES
        // DE QUE EL FORMULARIO ESTA VISIBLE
        // VER EL FORMULARIO CRUDEmpleado LINEA 76
        //index();

    }

    public static void createEmpleado() {
        EmpleadoDAOJDBC empleadoDao = new EmpleadoDAOJDBC();
        Map<String,String> departamentos = empleadoDao.departamentos();
        for(Map.Entry<String,String> departamento: departamentos.entrySet()){
            System.out.println("ID:" +departamento.getKey());
            System.out.println("Valor:" +departamento.getValue());
        }
        view.createEmpleado(departamentos);
    }

    public static void readEmpleado() {
        model = findModel(view.getTableRow());
        view.readEmpleado(model);

    }

    public static void updateEmpleado() {
        //view.getTableRow(model);
        model = findModel(view.getTableRow());
        view.updateEmpleado(model);

    }

    public static void guardarEmpleado(String id, String nombre, String apellidos, String departamento) {
        model.setId(id);
        model.setNombre(nombre);
        model.setApellidos(apellidos);
        model.setDepartamento(departamento);
        EmpleadoDAOJDBC empleadoDao = new EmpleadoDAOJDBC();
        if (id.equals("")) {
            int registrosinsertados = empleadoDao.insert(model);
            System.out.println("Se insertó :" + registrosinsertados);
        }else{
            int registrosmodificados = empleadoDao.update(model);
            System.out.println("Se modifico :" + registrosmodificados);
        }

        index();
        //view.updateTable(model);
    }

    public static void mostrarEmpleado() {
        String empleado = "Nombre: " + model.getNombre() + " " + model.getApellidos() + "\n Departamento: " + model.getDepartamento();
        JOptionPane.showMessageDialog(null, empleado);
    }

    public static void deleteEmpleado() {

        int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar el registro?", "Eliminar empleado", JOptionPane.YES_NO_OPTION);
        if (respuesta == 0) {
            String id = view.getTableRow();
            EmpleadoDAOJDBC empleadoDao = new EmpleadoDAOJDBC();
            int deleterow = empleadoDao.delete(id);
            if(deleterow==1){
                index();
                System.out.println("Registros eliminados: "+ deleterow);
            }            
        }

    }

    public static void index() {
        EmpleadoDAOJDBC empleadoDao = new EmpleadoDAOJDBC();

        List<Empleado> empleados = empleadoDao.select();
        view.updateTable(empleados);
    }

    public static Empleado findModel(String id) {
        Connection conn = null;
        Empleado model = null;
        try {
            conn = Conexion.getConnection();
            EmpleadoDAOJDBC empleadoDaoJDB = new EmpleadoDAOJDBC();
            model = empleadoDaoJDB.read(id);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
        }

        return model;
    }

}
