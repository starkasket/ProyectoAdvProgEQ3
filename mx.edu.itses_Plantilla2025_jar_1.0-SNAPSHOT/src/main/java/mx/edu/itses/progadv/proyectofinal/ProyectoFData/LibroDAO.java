/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.edu.itses.progadv.proyectofinal.ProyectoFData;


import java.util.List;
import java.util.Map;
import mx.edu.itses.progadv.proyectofinal.ProyectoFModelo.Libro;


/**
 *
 * @author Administrador
 */
public interface LibroDAO {
    
    public List<Libro> select();
    
    public int insert(Libro libro);
    
    public Libro read(String id);
    
    public int update(Libro libro);
    
    public int delete(String id);
    
    public Map<String,String> editoriales();
    
}
