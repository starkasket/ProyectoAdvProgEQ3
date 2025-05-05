/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.progadv.proyectofinal.mvc.models;

/**
 *
 * @author Administrador
 */
public class Peticion {
    private String id;
    private String nombre;
    private String editorial;
    private String clienteSolicitando;
    private int cantidadSolicitada;
    private String estadoSolicitud;
    private String empleado;

    @Override
    public String toString() {
        return "Peticion{" + "id=" + id + ", nombre=" + nombre + ", editorial=" + editorial + ", clienteSolicitando=" + clienteSolicitando + ", cantidadSolicitada=" + cantidadSolicitada + ", estadoSolicitud=" + estadoSolicitud + ", empleado=" + empleado + '}';
    }

   
 public Peticion() {
         this.id = "";
         this.nombre = "";
         this.editorial = "";
         this.clienteSolicitando = "";
         this.cantidadSolicitada = 0;
         this.estadoSolicitud = "";
         this.empleado = "";
     }
 
     public Peticion(String id, String nombre, String editorial, String clienteSolicitando, int cantidadSolicitada, String estadoSolicitud, String empleado) {
         this.id = id;
         this.nombre = nombre;
         this.editorial = editorial;
         this.clienteSolicitando = clienteSolicitando;
         this.cantidadSolicitada = cantidadSolicitada;
         this.estadoSolicitud = estadoSolicitud;
         this.empleado = empleado;
     }
 
     public Peticion(String nombre, String editorial, String clienteSolicitando, int cantidadSolicitada, String estadoSolicitud, String empleado) {
         this.nombre = nombre;
         this.editorial = editorial;
         this.clienteSolicitando = clienteSolicitando;
         this.cantidadSolicitada = cantidadSolicitada;
         this.estadoSolicitud = estadoSolicitud;
         this.empleado = empleado;
     }
     
       public Peticion(String editorial, String estadoSolicitud, String clienteSolicitando, String empleado) {
          this.editorial = editorial;
          this.estadoSolicitud = estadoSolicitud;
          this.clienteSolicitando = clienteSolicitando;
          this.empleado = empleado;
      }
     
   //  Getters & setters

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

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getClienteSolicitando() {
        return clienteSolicitando;
    }

    public void setClienteSolicitando(String clienteSolicitando) {
        this.clienteSolicitando = clienteSolicitando;
    }

    public int getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public void setCantidadSolicitada(int cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }
    
    
             

     
 // Lista de editorial
     
      public String[] getEditoriales() {
         String editoriales[] = {"Cambridge University Press", "Oxford University Press", "Routledge", 
             "Srpinger","Elsevier","Peter Lang","Thomson Reuters","Blackwell","De Gruyter","McGraw Hill"};
         return editoriales;
     }
      
 // Lista de estados
     
      public String[] getEstados() {
         String estados[] = {"Nuevo", "En revisión", "Autorizado", 
             "Solicitado al proveedor","Entregado"};
         return estados;
     }
      
  // Lista de empleados   
      
      public String[] getEmpleados() {
         String empleados[] = {"Empleado 1", "Empleado 2", "Empleado 3", 
             "Empleado 4","Empleado 5"};
         return empleados;
     }
      
   // Lista de clientes   
      
      public String[] getClientes() {
         String clientes[] = {"Cliente 1", "Cliente 2", "CLiente 3", 
             "Cliente 4","CLiente 5"};
         return clientes;
     }
      
      //metodo emptyModel
     
      
     public void emptyModel(){
        this.id = "";
         this.nombre = "";
         this.editorial = "";
         this.clienteSolicitando = "";
         this.cantidadSolicitada = 0;
         this.estadoSolicitud = "";
         this.empleado = "";
     }

}
