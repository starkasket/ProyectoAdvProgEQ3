/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.progadv.proyectofinal.mvc.models;

/**
 *
 * @author juras
 */
public class LibroPeticiones {
   private String id;
     private String nombre_del_libro_a_solicitar;
     private String editorial;
     private String Cliente_que_solicita;
     private int cantidad_solicitada;
     private String estado_Solicitud;
 
     /*Constructores 
     1.vacio, 
     2.con todos los parametros,
     3.Excepto el prametro id.
     4. solo con id, ediorial y estado_solicitud
     */
 
     public LibroPeticiones() {
         this.id = "";
         this.nombre_del_libro_a_solicitar = "";
         this.editorial = "";
         this.Cliente_que_solicita = "";
         this.cantidad_solicitada = 0;
         this.estado_Solicitud = "";
     }
 
     public LibroPeticiones(String id, String nombre_del_libro_a_solicitar, String editorial, String Cliente_que_solicita, int cantidad_solicitada, String estado_Solicitud) {
         this.id = id;
         this.nombre_del_libro_a_solicitar = nombre_del_libro_a_solicitar;
         this.editorial = editorial;
         this.Cliente_que_solicita = Cliente_que_solicita;
         this.cantidad_solicitada = cantidad_solicitada;
         this.estado_Solicitud = estado_Solicitud;
     }
 
     public LibroPeticiones(String nombre_del_libro_a_solicitar, String editorial, String Cliente_que_solicita, int cantidad_solicitada, String estado_Solicitud) {
         this.nombre_del_libro_a_solicitar = nombre_del_libro_a_solicitar;
         this.editorial = editorial;
         this.Cliente_que_solicita = Cliente_que_solicita;
         this.cantidad_solicitada = cantidad_solicitada;
         this.estado_Solicitud = estado_Solicitud;
     }
 
     public LibroPeticiones(String editorial, String estado_Solicitud) {
         this.editorial = editorial;
         this.estado_Solicitud = estado_Solicitud;
     }
     
    
 
   //  Getters y setters
 
     public String getId() {
         return id;
     }
 
     public void setId(String id) {
         this.id = id;
     }
 
     public String getNombre_del_libro_a_solicitar() {
         return nombre_del_libro_a_solicitar;
     }
 
     public void setNombre_del_libro_a_solicitar(String nombre_del_libro_a_solicitar) {
         this.nombre_del_libro_a_solicitar = nombre_del_libro_a_solicitar;
     }
 
     public String getEditorial() {
         return editorial;
     }
 
     public void setEditorial(String editorial) {
         this.editorial = editorial;
     }
 
     public String getCliente_que_solicita() {
         return Cliente_que_solicita;
     }
 
     public void setCliente_que_solicita(String Cliente_que_solicita) {
         this.Cliente_que_solicita = Cliente_que_solicita;
     }
 
     public int getCantidad_solicitada() {
         return cantidad_solicitada;
     }
 
     public void setCantidad_solicitada(int cantidad_solicitada) {
         this.cantidad_solicitada = cantidad_solicitada;
     }
 
     public String getEstado_Solicitud() {
         return estado_Solicitud;
     }
 
     public void setEstado_Solicitud(String estado_Solicitud) {
         this.estado_Solicitud = estado_Solicitud;
     }
 
 // Lista de editorial
 // Lista de editorial y estados de solicitud
 
      public String[] getEditoriales() {
         String editoriales[] = {"Cambridge University Press", "Oxford University Press", "Routledge", 
             "Srpinger","Elsevier","Peter Lang","Thomson Reuters","Blackwell","De Gruyter","McGraw Hill"};
         return editoriales;
     }
 
      public String[] getEstadoSolicitud(){
          String estados[] = {"Nuevo", "En revision", "Autorizado","Solicitado al provedor", "Entregado"};
                  return estados;
          }
      
      
      //metodo emptyModel
 
 
     public void emptyModel(){
        this.id = "";
         this.nombre_del_libro_a_solicitar = "";
         this.editorial = "";
         this.Cliente_que_solicita = "";
         this.cantidad_solicitada = 0;
         this.estado_Solicitud = "";
     }
 
     //Metodo toString
 
     @Override
     public String toString() {
         return  "id : " + id + ", nombre_del_libro_a_solicitar :" + nombre_del_libro_a_solicitar + ", editorial :" + editorial + ", Cliente_que_solicita :" + Cliente_que_solicita + ", cantidad_solicitada :" + cantidad_solicitada + ", estado_Solicitud :" + estado_Solicitud;
     }
 
 
 
 
 } 

