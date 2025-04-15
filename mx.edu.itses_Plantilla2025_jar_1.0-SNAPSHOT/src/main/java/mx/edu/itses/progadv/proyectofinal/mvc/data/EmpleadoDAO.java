/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.edu.itses.progadv.proyectofinal.mvc.data;

import java.util.List;
import java.util.Map;
import mx.edu.itses.progadv.proyectofinal.mvc.models.Empleado;

/**
 *
 * @author Administrador
 */
public interface EmpleadoDAO {
    
    public List<Empleado> select();
    
    public int insert(Empleado empleado);
    
    public Empleado read(String id);
    
    public int update(Empleado empleado);
    
    public int delete(String id);
    
    public Map<String,String> departamentos();
    
}
