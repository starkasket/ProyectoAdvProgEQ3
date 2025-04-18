/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mx.edu.itses.progadv.proyectofinal.mvc.views.principal;

import com.sun.tools.javac.Main;
import mx.edu.itses.progadv.proyectofinal.mvc.functions.ColoresTema;
import mx.edu.itses.progadv.proyectofinal.mvc.functions.EfectosComponentes;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import mx.edu.itses.progadv.proyectofinal.mvc.controllers.EmpleadoController;
import mx.edu.itses.progadv.proyectofinal.mvc.controllers.LibroController;
import mx.edu.itses.progadv.proyectofinal.mvc.models.Empleado;
import mx.edu.itses.progadv.proyectofinal.mvc.models.Libro;
import mx.edu.itses.progadv.proyectofinal.mvc.views.empleado.EmpleadoView;
import mx.edu.itses.progadv.proyectofinal.mvc.views.libro.LibroView;

/**
 *
 * @author Administrador
 */
public class Principal extends javax.swing.JFrame implements MouseListener, EfectosComponentes {

    /**
     * Creates new form Sistema
     */
    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/logo.png"));
        lblLogo.setIcon(icon);

        jplEmpleados.addMouseListener(this);
        jplClientes.addMouseListener(this);
        jplLibros.addMouseListener(this);
        jplPedidos.addMouseListener(this);
        jplVentas.addMouseListener(this);
        jplSalir.addMouseListener(this);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jplBackground = new javax.swing.JPanel();
        jplLogo = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jplHeader = new javax.swing.JPanel();
        jplSalir = new javax.swing.JPanel();
        lblSalir = new javax.swing.JLabel();
        jplSideMenu = new javax.swing.JPanel();
        jplEmpleados = new javax.swing.JPanel();
        lblEmpleados = new javax.swing.JLabel();
        jplLibros = new javax.swing.JPanel();
        lblProductos = new javax.swing.JLabel();
        jplClientes = new javax.swing.JPanel();
        lblClientes = new javax.swing.JLabel();
        jplPedidos = new javax.swing.JPanel();
        lblProductos1 = new javax.swing.JLabel();
        jplVentas = new javax.swing.JPanel();
        lblVentas = new javax.swing.JLabel();
        jplContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jplBackground.setBackground(new java.awt.Color(255, 255, 255));
        jplBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jplLogoLayout = new javax.swing.GroupLayout(jplLogo);
        jplLogo.setLayout(jplLogoLayout);
        jplLogoLayout.setHorizontalGroup(
            jplLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jplLogoLayout.setVerticalGroup(
            jplLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jplBackground.add(jplLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 120));

        jplHeader.setBackground(new java.awt.Color(0, 60, 92));
        jplHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jplSalir.setBackground(new java.awt.Color(0, 60, 92));
        jplSalir.setName("jplSalir"); // NOI18N
        jplSalir.setLayout(new java.awt.BorderLayout());

        lblSalir.setBackground(new java.awt.Color(255, 255, 255));
        lblSalir.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblSalir.setForeground(new java.awt.Color(255, 255, 255));
        lblSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSalir.setText("SALIR");
        jplSalir.add(lblSalir, java.awt.BorderLayout.CENTER);

        jplHeader.add(jplSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 15, 60, 30));

        jplBackground.add(jplHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 1000, 60));

        jplSideMenu.setBackground(new java.awt.Color(0, 60, 92));
        jplSideMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jplEmpleados.setBackground(new java.awt.Color(0, 60, 92));
        jplEmpleados.setName("jplEmpleados"); // NOI18N
        jplEmpleados.setLayout(new java.awt.BorderLayout());

        lblEmpleados.setBackground(new java.awt.Color(0, 60, 92));
        lblEmpleados.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        lblEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        lblEmpleados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmpleados.setText("Empleados");
        jplEmpleados.add(lblEmpleados, java.awt.BorderLayout.CENTER);

        jplSideMenu.add(jplEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 200, 30));

        jplLibros.setBackground(new java.awt.Color(0, 60, 92));
        jplLibros.setName("jplLibros"); // NOI18N
        jplLibros.setLayout(new java.awt.BorderLayout());

        lblProductos.setBackground(new java.awt.Color(0, 60, 92));
        lblProductos.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        lblProductos.setForeground(new java.awt.Color(255, 255, 255));
        lblProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProductos.setText("Libros");
        jplLibros.add(lblProductos, java.awt.BorderLayout.CENTER);

        jplSideMenu.add(jplLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 200, 30));

        jplClientes.setBackground(new java.awt.Color(0, 60, 92));
        jplClientes.setName("jplClientes"); // NOI18N
        jplClientes.setLayout(new java.awt.BorderLayout());

        lblClientes.setBackground(new java.awt.Color(0, 60, 92));
        lblClientes.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        lblClientes.setForeground(new java.awt.Color(255, 255, 255));
        lblClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClientes.setText("Clientes");
        jplClientes.add(lblClientes, java.awt.BorderLayout.CENTER);

        jplSideMenu.add(jplClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 200, 30));

        jplPedidos.setBackground(new java.awt.Color(0, 60, 92));
        jplPedidos.setName("jplLibros"); // NOI18N
        jplPedidos.setLayout(new java.awt.BorderLayout());

        lblProductos1.setBackground(new java.awt.Color(0, 60, 92));
        lblProductos1.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        lblProductos1.setForeground(new java.awt.Color(255, 255, 255));
        lblProductos1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProductos1.setText("Pedidos");
        jplPedidos.add(lblProductos1, java.awt.BorderLayout.CENTER);

        jplSideMenu.add(jplPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 200, 30));

        jplVentas.setBackground(new java.awt.Color(0, 60, 92));
        jplVentas.setName("jplVentas"); // NOI18N
        jplVentas.setLayout(new java.awt.BorderLayout());

        lblVentas.setBackground(new java.awt.Color(0, 60, 92));
        lblVentas.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        lblVentas.setForeground(new java.awt.Color(255, 255, 255));
        lblVentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVentas.setText("Ventas");
        jplVentas.add(lblVentas, java.awt.BorderLayout.CENTER);

        jplSideMenu.add(jplVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 30));

        jplBackground.add(jplSideMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 200, 580));

        javax.swing.GroupLayout jplContentLayout = new javax.swing.GroupLayout(jplContent);
        jplContent.setLayout(jplContentLayout);
        jplContentLayout.setHorizontalGroup(
            jplContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jplContentLayout.setVerticalGroup(
            jplContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        jplBackground.add(jplContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 1000, 640));

        getContentPane().add(jplBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jplBackground;
    private javax.swing.JPanel jplClientes;
    public static javax.swing.JPanel jplContent;
    private javax.swing.JPanel jplEmpleados;
    private javax.swing.JPanel jplHeader;
    private javax.swing.JPanel jplLibros;
    private javax.swing.JPanel jplLogo;
    private javax.swing.JPanel jplPedidos;
    private javax.swing.JPanel jplSalir;
    private javax.swing.JPanel jplSideMenu;
    private javax.swing.JPanel jplVentas;
    private javax.swing.JLabel lblClientes;
    private javax.swing.JLabel lblEmpleados;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblProductos;
    private javax.swing.JLabel lblProductos1;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JLabel lblVentas;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {

        switch (e.getComponent().getName()) {
            case "jplEmpleados":
                EmpleadoController  empleadocontroller = new EmpleadoController(new Empleado(),new EmpleadoView());
                //NOTA: REVISAR LLAMADA A MÉTODO EN EL CONTROLADOR
                empleadocontroller.CRUDEmpleado();
                break;
            case "jplClientes":
                System.out.println("CODIFICAR EL CONTROLADOR CLIENTES AQUI");
                break;
            case "jplLibros":
                 LibroController  librocontroller = new LibroController(new Libro(),new LibroView());
                //NOTA: REVISAR LLAMADA A MÉTODO EN EL CONTROLADOR
                librocontroller.CRUDLibro();
                break;
            case "jplPedidos":
                System.out.println("CODIFICAR EL CONTROLADOR PEDIDOS AQUI");
                break;
            case "jplVentas":
                System.out.println("CODIFICAR EL CONTROLADOR VENTAS AQUI");

                break;
            case "jplSalir":
                System.exit(0);
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.mouseIn(e.getComponent());

    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.mouseOut(e.getComponent(), ColoresTema.PANEL_BLUE.getColor());
    }

}
