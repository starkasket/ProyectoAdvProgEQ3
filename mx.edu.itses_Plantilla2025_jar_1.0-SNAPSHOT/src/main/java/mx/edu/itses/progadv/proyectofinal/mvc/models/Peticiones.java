/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.progadv.proyectofinal.mvc.models;

/**
 *
 * @author Administrador
 */
public class Peticiones {
    private String id;
    private String nombre;
    private String apellidos;
    private String departamento;

    public Peticiones() {
        nombre = "";
        apellidos = "";
        departamento = "";
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", departamento=" + departamento + '}';
    }

    public Peticiones(String nombre, String apellidos, String departamento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.departamento = departamento;
    }

    
    
    public Peticiones(String id, String nombre, String apellidos, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.departamento = departamento;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String[] getDepartamentos() {
        String departamentos[] = {"Administración", "Finanzas", "Ingeniería", 
            "Recursos Humanos","IT"};
        return departamentos;
    }
    
    public void emptyModel(){
        this.nombre ="";
        this.apellidos ="";
        this.departamento="";
    }

}
