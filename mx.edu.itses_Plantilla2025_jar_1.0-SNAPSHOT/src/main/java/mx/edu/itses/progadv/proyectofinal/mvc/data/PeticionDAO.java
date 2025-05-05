/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.edu.itses.progadv.proyectofinal.mvc.data;

import java.util.List;
import java.util.Map;
import mx.edu.itses.progadv.proyectofinal.mvc.models.Empleado;
import mx.edu.itses.progadv.proyectofinal.mvc.models.Peticion;

/**
 *
 * @author Administrador
 */
public interface PeticionDAO {
    
    public List<Peticion> select();
    
    public int insert(Peticion peticion);
    
    public Peticion read(String id);
    
    public int update(Peticion peticion);
    
    public int delete(String id);
   
    //Se cambió el mapeado a que las llaves y valores sean String
    public Map<String,String> editoriales();
    public Map<String,String> estados();
    public Map<String,String> clientes();
    public Map<String,String> empleados();
    
}
