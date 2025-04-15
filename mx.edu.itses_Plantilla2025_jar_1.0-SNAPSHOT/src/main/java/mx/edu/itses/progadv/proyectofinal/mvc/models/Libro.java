/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.progadv.proyectofinal.mvc.models;

/**
 *
 * @author Administrador
 */
public class Libro {
    private String titulo;
    private String categoria;
    private String editorial;
    private int anio_publicacion;
    private int numero_paginas;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnio_publicacion() {
        return anio_publicacion;
    }

    public void setAnio_publicacion(int anio_publicacion) {
        this.anio_publicacion = anio_publicacion;
    }

    public int getNumero_paginas() {
        return numero_paginas;
    }

    public void setNumero_paginas(int numero_paginas) {
        this.numero_paginas = numero_paginas;
    }
       
    

    public String[] getCategorias() {
        String categorias[] = {"Científico", "Literatura", "Consulta y referencia", 
            "Artísticos","Divulgativos","Viaje","Biografías","Libros de texto","Recreativos"};
        return categorias;
    }
    
    public String[] getEditoriales() {
        String editoriales[] = {"Cambridge University Press", "Oxford University Press", "Routledge", 
            "Srpinger","Elsevier","Peter Lang","Thomson Reuters","Blackwell","De Gruyter","McGraw Hill"};
        return editoriales;
    }
    
    public void emptyModel(){
        titulo = "";
        categoria = "";
        editorial = "";
        anio_publicacion = 0;
        numero_paginas = 0;
    }

}
