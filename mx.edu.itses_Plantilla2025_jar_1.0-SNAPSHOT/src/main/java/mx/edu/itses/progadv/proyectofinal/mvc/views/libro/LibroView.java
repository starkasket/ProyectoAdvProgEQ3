/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.progadv.proyectofinal.mvc.views.libro;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mx.edu.itses.progadv.proyectofinal.mvc.controllers.LibroController;
import mx.edu.itses.progadv.proyectofinal.mvc.models.Libro;

/**
 *
 * @author Administrador
 */
public class LibroView {
    

    public void CRUDLibro() {
        FlatLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new CRUDLibro().setVisible(true);
            }
        });
    }

    public void createLibro(String categorias[],String editoriales[]) {
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createForm(categorias,editoriales).setVisible(true);
            }
        });
    }

    public void readLibro(Libro model) {
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new readForm(model).setVisible(true);
            }
        });

    }
    
    
    public void updateLibro(Libro model) {
        
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateForm(model).setVisible(true);
            }
        });

    }

    public static void guardarLibro(String titulo, String categoria, String editorial,int anio_publicacion,int numero_paginas) {

        LibroController.guardarLibro(titulo,categoria,editorial,anio_publicacion,numero_paginas);

    }
    
    public static void mensaje(String message){
        JOptionPane.showMessageDialog(null,message);
    }
    
   /*public void updateTable(Libro model){
       vistaCRUD.updateTabla(model);
   }
   
   public void getTableRow(Libro model){
       vistaCRUD.getTableRow(model);
   }*/

}
