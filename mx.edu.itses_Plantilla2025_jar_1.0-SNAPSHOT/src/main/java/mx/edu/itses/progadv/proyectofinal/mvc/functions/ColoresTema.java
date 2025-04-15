/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package mx.edu.itses.progadv.proyectofinal.mvc.functions;

import java.awt.Color;

/**
 *
 * @author Administrador
 */
public enum ColoresTema {
      
    PRIMARY_BUTTON(new Color(31,145,243)),
    SUCCESS_BUTTON(new Color(43,152,43)),
    INFO_BUTTON(new Color(0,176,228)),
    WARNING_BUTTON(new Color(255,150,0)),
    DANGER_BUTTON(new Color(251,72,58)),
    BLACK_BUTTON(new Color(0,0,0)),
    BROWN_BUTTON(new Color(121,85,72)),
    GREY_BUTTON(new Color(158,158,158)),
    BLUEGREY_BUTTON(new Color(96,125,139)),
    CLOSE_BUTTON(new Color(255,0,51)),
    ORANGE_BUTTON(new Color(51,122,183)),
    WHITE_BUTTON(new Color(255,255,255)),
    BACKGROUND_BUTTON(new Color(208,208,208)),
    PANEL_BLUE(new Color(0,60,92));
    
    private Color rgb;
    
    private ColoresTema(Color rgb){
        this.rgb = rgb;
    }
    
    public Color getColor(){
        return this.rgb;
    }
    
    
}
