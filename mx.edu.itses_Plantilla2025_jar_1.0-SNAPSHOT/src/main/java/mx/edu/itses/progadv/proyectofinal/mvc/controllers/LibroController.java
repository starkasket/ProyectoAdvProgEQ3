/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.progadv.proyectofinal.mvc.controllers;


import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mx.edu.itses.progadv.proyectofinal.mvc.models.Libro;
import mx.edu.itses.progadv.proyectofinal.mvc.views.libro.LibroView;

/**
 *
 * @author Administrador
 */
public class LibroController {

    private static Libro model;
    private static LibroView view;

    public LibroController(Libro model, LibroView view) {
        this.model = model;
        this.view = view;
    } 

    public void CRUDLibro(){
        view.CRUDLibro();
        
    }
    
    public static void createLibro(){
        view.createLibro(model.getCategorias(),model.getEditoriales());
    }
    
    public static void readLibro(){
        view.readLibro(model);
        
    }
    
   public static void updateLibro(){
        view.updateLibro(model);
        
    }
    
    public static void guardarLibro(String titulo, String categoria, String editorial,int anio_publicacion,int numero_paginas) {
    
        model.setTitulo(titulo);
        model.setCategoria(categoria);
        model.setEditorial(editorial);
        model.setAnio_publicacion(anio_publicacion);
        model.setNumero_paginas(numero_paginas);
        System.out.println(model);
    }
    
    
    /*public static void mostrarLibro(){
        String empleado = "Nombre: " + model.getNombre() + " " + model.getApellidos() + "\n Departamento: " +model.getDepartamento();
        JOptionPane.showMessageDialog(null, empleado);
    }*/
    
    public static void deleteLibro(){        
       
        int respuesta = JOptionPane.showConfirmDialog(null,  "¿Estás seguro de eliminar el registro?", "Eliminar libro",JOptionPane.YES_NO_OPTION );
        if(respuesta==0){
            model.emptyModel();
        }
       
    }
    
        
}
