/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.edu.itses.progadv.proyectofinal.mvc.data;

import java.util.List;
import java.util.Map;
import mx.edu.itses.progadv.proyectofinal.mvc.models.Libro;
import mx.edu.itses.progadv.proyectofinal.mvc.models.LibroPeticiones;

/**
 *
 * @author juras
 */
public interface LibroDAO {
  public List<LibroPeticiones> select();
 
     public int insert(LibroPeticiones libro);
 
     public LibroPeticiones read(String id);
 
     public int update(LibroPeticiones libro);
 
     public int delete(String id);
 
     public Map<String,LibroPeticiones> editoriales(); 
     
     public Map<String, LibroPeticiones> estados();
     
}
