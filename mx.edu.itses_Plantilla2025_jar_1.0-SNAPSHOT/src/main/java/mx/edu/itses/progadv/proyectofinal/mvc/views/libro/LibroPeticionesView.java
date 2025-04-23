/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.progadv.proyectofinal.mvc.views.libro;

import com.formdev.flatlaf.FlatLightLaf;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import mx.edu.itses.progadv.proyectofinal.mvc.controllers.LibroPeticionesController;
import mx.edu.itses.progadv.proyectofinal.mvc.models.Empleado;
import mx.edu.itses.progadv.proyectofinal.mvc.models.LibroPeticiones;

/**
 *
 * @author Administrador
 */
public class LibroPeticionesView {
    
    private static CRUDPeticiones vistaCRUD;

    public void CRUDPeticiones(LibroPeticiones model) {
        FlatLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               vistaCRUD = new CRUDPeticiones(model);
               vistaCRUD.setVisible(true);
            }
        });
        
    }

    public void createFormPeticion(Map<String, LibroPeticiones> estado_Solicitud, Map<String, LibroPeticiones> editoriales) {
        FlatLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createFormPeticion(estado_Solicitud, editoriales).setVisible(true);
            }
        });
    }

    public void readFormPeticion(LibroPeticiones model) {
        FlatLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new readFormPeticion(model).setVisible(true);
            }
        });

    }
    
    
    public void updateLibroPeticion(LibroPeticiones model) {
        
        FlatLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateFormPeticion(model).setVisible(true);
            }
        });

    }
    
    
    
    public static void guardarLibroPeticiones(String id, String nombre_del_libro_a_solicitar, String editorial, String Cliente_que_solicita, int cantidad_solicitada, String estado_Solicitud) {

        LibroPeticionesController.guardarLibroPeticiones(id, nombre_del_libro_a_solicitar, editorial, Cliente_que_solicita, cantidad_solicitada,estado_Solicitud);

    }
    
    public static void mensaje(String message){
        JOptionPane.showMessageDialog(null,message);
    }
    
   public void updateTable(List<LibroPeticiones> peticiones){
       vistaCRUD.updateTabla(peticiones);
   }
   
   public String getTableRow(){
       return vistaCRUD.getTableRow();
   }

}
