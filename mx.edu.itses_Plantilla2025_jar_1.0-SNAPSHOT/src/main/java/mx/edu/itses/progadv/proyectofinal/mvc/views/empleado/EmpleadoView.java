/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.progadv.proyectofinal.mvc.views.empleado;

import com.formdev.flatlaf.FlatLightLaf;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mx.edu.itses.progadv.proyectofinal.mvc.controllers.EmpleadoController;
import mx.edu.itses.progadv.proyectofinal.mvc.models.Empleado;

/**
 *
 * @author Administrador
 */
public class EmpleadoView {
    
    private static CRUDEmpleado vistaCRUD;

    public void CRUDEmpleado(Empleado model) {
        FlatLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               vistaCRUD = new CRUDEmpleado(model);
               vistaCRUD.setVisible(true);
            }
        });
        
    }

    public void createEmpleado(Map<String,String> departamentos ) {
        FlatLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createForm(departamentos).setVisible(true);
            }
        });
    }

    public void readEmpleado(Empleado model) {
        FlatLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new readForm(model).setVisible(true);
            }
        });

    }
    
    
    public void updateEmpleado(Empleado model) {
        
        FlatLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateForm(model).setVisible(true);
            }
        });

    }

    public static void guardarEmpleado(String id,String nombre, String apellidos, String departamento) {

        EmpleadoController.guardarEmpleado(id, nombre, apellidos, departamento);

    }
    
    public static void mensaje(String message){
        JOptionPane.showMessageDialog(null,message);
    }
    
   public void updateTable(List<Empleado> empleados){
       vistaCRUD.updateTabla(empleados);
   }
   
   public String getTableRow(){
       return vistaCRUD.getTableRow();
   }

}
