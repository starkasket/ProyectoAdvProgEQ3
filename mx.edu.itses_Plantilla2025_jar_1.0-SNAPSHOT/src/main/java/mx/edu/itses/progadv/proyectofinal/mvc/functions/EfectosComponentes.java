/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.edu.itses.progadv.proyectofinal.mvc.functions;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;

/**
 *
 * @author Administrador
 */
public interface EfectosComponentes {
    
    default public void mouseIn(Component elemento){
        elemento.setBackground(new Color(208,208,208));
        elemento.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    default public void mouseOut(Component elemento,Color rgb){
        elemento.setBackground(rgb);
    }
    
}
