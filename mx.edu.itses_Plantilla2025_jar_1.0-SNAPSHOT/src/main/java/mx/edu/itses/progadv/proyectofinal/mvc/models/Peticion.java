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

    @Override
    public String toString() {
        return "Peticion{" + "id=" + id + ", nombre=" + nombre + ", editorial=" + editorial + ", clienteSolicitando=" + clienteSolicitando + ", cantidadSolicitada=" + cantidadSolicitada + ", estadoSolicitud=" + estadoSolicitud + '}';
    }

   
 public Peticion() {
         this.id = "";
         this.nombre = "";
         this.editorial = "";
         this.clienteSolicitando = "";
         this.cantidadSolicitada = 0;
         this.estadoSolicitud = "";
     }
 
     public Peticion(String id, String nombre, String editorial, String clienteSolicitando, int cantidadSolicitada, String estadoSolicitud) {
         this.id = id;
         this.nombre = nombre;
         this.editorial = editorial;
         this.clienteSolicitando = clienteSolicitando;
         this.cantidadSolicitada = cantidadSolicitada;
         this.estadoSolicitud = estadoSolicitud;
     }
 
     public Peticion(String nombre, String editorial, String clienteSolicitando, int cantidadSolicitada, String estadoSolicitud) {
         this.nombre = nombre;
         this.editorial = editorial;
         this.clienteSolicitando = clienteSolicitando;
         this.cantidadSolicitada = cantidadSolicitada;
         this.estadoSolicitud = estadoSolicitud;
     }
     
       public Peticion(String editorial, String estadoSolicitud) {
          this.editorial = editorial;
          this.estadoSolicitud = estadoSolicitud;
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
      
      //metodo emptyModel
     
      
     public void emptyModel(){
        this.id = "";
         this.nombre = "";
         this.editorial = "";
         this.clienteSolicitando = "";
         this.cantidadSolicitada = 0;
         this.estadoSolicitud = "";
     }

}
