/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.progadv.proyectofinal.mvc.views.peticiones;

import mx.edu.itses.progadv.proyectofinal.mvc.views.empleado.*;
import com.formdev.flatlaf.FlatLightLaf;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mx.edu.itses.progadv.proyectofinal.mvc.controllers.EmpleadoController;
import mx.edu.itses.progadv.proyectofinal.mvc.controllers.PeticionController;
import mx.edu.itses.progadv.proyectofinal.mvc.models.Empleado;
import mx.edu.itses.progadv.proyectofinal.mvc.models.Peticion;

/**
 *
 * @author Administrador
 */
public class PeticionView {
    
    private static CRUDPeticion vistaCRUD;

    public void CRUDPeticion(Peticion model) {
        FlatLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               vistaCRUD = new CRUDPeticion(model);
               vistaCRUD.setVisible(true);
            }
        });
        
    }

    public void createPeticion(Map<String,String> editoriales, Map<String,String> estados, Map<String,String> clientes, Map<String,String> empleados) {
        FlatLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createFormPeticion(editoriales, estados, clientes, empleados).setVisible(true);
            }
        });
    }

    public void readPeticion(Peticion model) {
        FlatLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new readFormPeticion(model).setVisible(true);
            }
        });

    }
    
    
    public void updatePeticion(Peticion model) {
        
        FlatLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateFormPeticion(model).setVisible(true);
            }
        });

    }

    public static void guardarPeticion(String id,String nombre, String editorial, String clienteSolicitando, int cantidadSolicitada, String estadoSolicitud, String empleado) {
        PeticionController.guardarPeticion(id, nombre, editorial, clienteSolicitando, cantidadSolicitada, estadoSolicitud, empleado);
    }
    
    public static void mensaje(String message){
        JOptionPane.showMessageDialog(null,message);
    }
    
   public void updateTable(List<Peticion> peticiones){
       vistaCRUD.updateTabla(peticiones);
   }
   
   public String getTableRow(){
       return vistaCRUD.getTableRow();
   }

}
