/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.progadv.proyectofinal.mvc.controllers;

import java.sql.*;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import mx.edu.itses.progadv.proyectofinal.mvc.data.Conexion;
import mx.edu.itses.progadv.proyectofinal.mvc.data.LibroDAOJDBC;
import mx.edu.itses.progadv.proyectofinal.mvc.models.LibroPeticiones;
import mx.edu.itses.progadv.proyectofinal.mvc.views.libro.LibroPeticionesView;

/**
 *
 * @author juras
 */
public class LibroPeticionesController {
  private static LibroPeticiones model;
  private static LibroPeticionesView view;

    public LibroPeticionesController(LibroPeticiones model, LibroPeticionesView view) {
    this.model = model;
    this.view = view;
    }
    
    public void CRUDPeticiones(){
    view.CRUDPeticiones(model);
    //index();
    }
    
    public static void createLibroPeticiones(){
     LibroDAOJDBC LibroDao = new LibroDAOJDBC();
     Map<String, LibroPeticiones> editoriales = LibroDao.editoriales();
     Map<String, LibroPeticiones> estado = LibroDao.estados();
    
      for (Map.Entry<String, LibroPeticiones> editorial : editoriales.entrySet()) {
         System.out.println("ID: " + editorial.getKey());
         System.out.println("Editorial: " + editorial.getValue().getEditorial());
         System.out.println("Estado de Solicitud: " + editorial.getValue().getEstado_Solicitud());
    }
      
      
      
  view.createFormPeticion(estado, editoriales);
  //view.createLibro(editoriales);
  
}
    
      public static void readLibroPeticiones(){
       
          model = findModel(view.getTableRow());
         view.readFormPeticion(model);
       
   }
      
   public static void updateLibroPetciones(){
       //Metodos no implementados falta vista
      model = findModel(view.getTableRow());
      view.updateLibroPeticion(model);
   }
   
 
   public static void guardarLibroPeticiones(String id, String nombre_del_libro_a_solicitar, String editorial, String Cliente_que_solicita, int cantidad_solicitada, String estado_Solicitud){
       model.setId(id);
       model.setNombre_del_libro_a_solicitar(nombre_del_libro_a_solicitar);
       model.setEditorial(editorial);
       model.setCliente_que_solicita(Cliente_que_solicita);
       model.setCantidad_solicitada(cantidad_solicitada);
       model.setEstado_Solicitud(estado_Solicitud);
       LibroDAOJDBC LibroDao = new LibroDAOJDBC();
        if (id.equals("")) {
             int registrosinsertados = LibroDao.insert(model);
             System.out.println("Se insertó :" + registrosinsertados);
         }else{
             int registrosmodificados = LibroDao.update(model);
             System.out.println("Se modifico :" + registrosmodificados);
         }
 
         index();
   }   
    
         public static void mostrarLibroPeticiones() {
         String libro = "Nombre: " + model.getNombre_del_libro_a_solicitar() + " "  + "\n Editorial: " + model.getEditorial() + " " + "\nCliente:" + model.getCliente_que_solicita() + " " + "\n Cantidad:" + model.getCantidad_solicitada() + " " + "\n Estado de su solicitud:" + model.getEstado_Solicitud() ;
         JOptionPane.showMessageDialog(null, libro);
     }
         
          public static void deleteLibroPeticiones() {
 
            
         int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar el registro?", "Eliminar empleado", JOptionPane.YES_NO_OPTION);
         if (respuesta == 0) {
             String id = view.getTableRow();
             LibroDAOJDBC libroDao = new LibroDAOJDBC();
             int deleterow = libroDao.delete(id);
             if(deleterow==1){
                 index();
                 System.out.println("Registros eliminados: "+ deleterow);
             }            
         }
 
     }
    
          public static void index() {
         LibroDAOJDBC LibroDao = new LibroDAOJDBC();
 
         List<LibroPeticiones> libros = LibroDao.select();
         view.updateTable(libros);
     }
 
 
     //Metdo find model
      public static LibroPeticiones findModel(String id) {
         Connection conn = null;
         LibroPeticiones model = null;
         try {
             conn = Conexion.getConnection();
             LibroDAOJDBC LibroDaoJDB = new LibroDAOJDBC();
             model = LibroDaoJDB.read(id);
 
         } catch (SQLException ex) {
             ex.printStackTrace(System.out);
         } finally {
             Conexion.close(conn);
         }
 
         return model;
     }
}