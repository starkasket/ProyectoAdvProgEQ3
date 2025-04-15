/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.progadv.proyectofinal.mvc.functions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 *
 * @author Administrador
 */
public class Padvf {
    private static final String CARACTERES ="QWERTYUIOPASDFGHJKLÑZXCVBNMqwertyuiopasdfghjklñzxcvbnm1234567890";
    private static final int LONGITUD = 8;
    
    public static String IDGenerator(){
        String id;
        Random r =  new Random();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        
        id = dtf.format(now);
        for(int i=0; i< LONGITUD;i++){
            int index = r.nextInt(CARACTERES.length());
            id +=CARACTERES.charAt(index);
        }
        
        return id;
    }
    
}
