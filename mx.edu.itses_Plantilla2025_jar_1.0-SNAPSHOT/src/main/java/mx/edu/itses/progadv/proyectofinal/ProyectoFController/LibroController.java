/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.progadv.proyectofinal.ProyectoFController;

import java.sql.*;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import mx.edu.itses.progadv.proyectofinal.ProyectoFData.Conexion;
import mx.edu.itses.progadv.proyectofinal.ProyectoFData.LibroDAOJDBC;
import mx.edu.itses.progadv.proyectofinal.ProyectoFModels.Libro;
import mx.edu.itses.progadv.proyectofinal.ProyectoFView.LibroView;

/**
 *
 * @author mar_6
 */
public class LibroController {
    
    private static Libro model;
    private static LibroView view;
    
    
    // constructor

    public LibroController(Libro model, LibroView view) {
        this.model = model;
        this.view = view;
    }
    
 //Metdod de vista del curde Falta definir  (vista)
    
    public void CRUDElibro(){
            
    //    view.CRUDElibro(model);
     // CUANDO SE CREA POR PRIMERA VEZ EL FORMULARIO HAY QUE INVOCAR EL MÉTODO INDEX DESPUES
        // DE QUE EL FORMULARIO ESTA VISIBLE
        // VER EL FORMULARIO CRUDEmpleado LINEA 76 ejemplo del profe ivan
            //index();
    }
  
 
     //Metodo de creacion(Dar alta) solo actualice el Map agregando como 2 parametro sun constructor con las dos variables en el DAOJDBC y el String id
  public static void createLibro() {
    LibroDAOJDBC LibroDao = new LibroDAOJDBC();
    Map<String, Libro> editoriales = LibroDao.editoriales();

    for (Map.Entry<String, Libro> editorial : editoriales.entrySet()) {
        System.out.println("ID: " + editorial.getKey());
        System.out.println("Editorial: " + editorial.getValue().getEditorial());
        System.out.println("Estado de Solicitud: " + editorial.getValue().getEstado_Solicitud());
      
    }


    // view.createLibro(editoriales);
}
  
  //Metdo read
  public static void readLibro(){
      /*
         model = findModel(view.getTableRow());
        view.readLibro(model);
      */
  }
  
  //Metodo para actualizar
  public static void updateLibro(){
      //Metodos no implementados falta vista
   //   model = findModel(view.getTableRow());
  //     view.updateEmpleado(model);
  }
   
  //Metodo para guardar
  
  public static void guardarLibro(String id, String nombre_del_libro_a_solicitar, String editorial, String Cliente_que_solicita, int cantidad_solicitada, String estado_Solicitud){
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
  
  //Metodo para mostrar
      public static void mostrarLibro() {
        String libro = "Nombre: " + model.getNombre_del_libro_a_solicitar() + " "  + "\n Editorial: " + model.getEditorial() + " " + "\nCliente:" + model.getCliente_que_solicita() + " " + "\n Cantidad:" + model.getCantidad_solicitada() + " " + "\n Estado de su solicitud:" + model.getEstado_Solicitud() ;
        JOptionPane.showMessageDialog(null, libro);
    }
   // Metdo de eliminar
      
       public static void deleteLibro() {
/*
           Error linea 107  debido al metodo getTableRow no implementado en view
           
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
*/
    }
    
    
    
    //Metodo index
      public static void index() {
        LibroDAOJDBC LibroDao = new LibroDAOJDBC();

        List<Libro> libros = LibroDao.select();
        //view.updateTable(libros);
    }
    
  
    //Metdo find model
     public static Libro findModel(String id) {
        Connection conn = null;
        Libro model = null;
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
