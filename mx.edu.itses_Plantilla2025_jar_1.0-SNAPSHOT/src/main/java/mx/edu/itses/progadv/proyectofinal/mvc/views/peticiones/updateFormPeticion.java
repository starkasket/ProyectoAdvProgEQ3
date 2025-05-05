/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mx.edu.itses.progadv.proyectofinal.mvc.views.peticiones;

import mx.edu.itses.progadv.proyectofinal.mvc.views.empleado.*;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.JOptionPane;
import mx.edu.itses.progadv.proyectofinal.mvc.data.PeticionDAOJDBC;
import mx.edu.itses.progadv.proyectofinal.mvc.models.Empleado;

import mx.edu.itses.progadv.proyectofinal.mvc.models.Peticion;

/**
 *
 * @author Administrador
 */
public class updateFormPeticion extends javax.swing.JFrame {

    /**
     * Creates new form Ejemplo5
     *
     * @param model
     */
    public updateFormPeticion(Peticion model) {
        initComponents();
        this.setLocationRelativeTo(null);
        // Instanciación del DAO de peticiones
        PeticionDAOJDBC peticionDao = new PeticionDAOJDBC();

        //Instanciación de dos mapeados para las editoriales y los estados
        Map<String, String> editoriales = peticionDao.editoriales();
        Map<String, String> estados = peticionDao.estados();
       
        Map<String, String> clienteSolicitando = peticionDao.clientes();
        Map<String, String> empleados = peticionDao.empleados();

        txtNombre.setText(model.getNombre());
        txtCantidadSolicitada.setText(String.valueOf(model.getCantidadSolicitada()));

        // Cambio en el comportamiento del llenado de ambas combobox's 
        // Ahora al abrir el formulario se selecciona automáticamente el valor que tenía anterirormente
        int indice = 0;
        for (Map.Entry<String, String> editorial : editoriales.entrySet()) {
            cmbEditoriales.addItem(editorial.getValue());
            if (editorial.getKey().equals(model.getEditorial())) {
                cmbEditoriales.setSelectedIndex(indice);
            }
            indice++;
        }
        indice = 0;
        for (Map.Entry<String, String> estado : estados.entrySet()) {
            cmbEstado.addItem(estado.getValue());
            if (estado.getKey().equals(model.getEstadoSolicitud())) {
                cmbEstado.setSelectedIndex(indice);
            }
            indice++;
        }
        indice = 0;
        for (Map.Entry<String, String> cliente : clienteSolicitando.entrySet()) {
            cmbClientes.addItem(cliente.getValue());
            if (cliente.getKey().equals(model.getClienteSolicitando())) {
                cmbClientes.setSelectedIndex(indice);
            }
            indice++;
        }
        indice = 0;
        for (Map.Entry<String, String> empleado : empleados.entrySet()) {
            cmbEmpleados.addItem(empleado.getValue());
            if (empleado.getKey().equals(model.getEmpleado())) {
                cmbEmpleados.setSelectedIndex(indice);
            }
            indice++;
        }

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Para un funcionamiento óptimo, se añadieron dos Strings 
                // que serán igualados a la llave del valor seleccionado
                // con el fin de que se desplieguen de buena manera los nuevos valores en la tabla
                String id_editorial = "";

                for (Map.Entry<String, String> editorial : editoriales.entrySet()) {
                    if (editorial.getValue().equals(cmbEditoriales.getSelectedItem().toString())) {
                        id_editorial = editorial.getKey();
                        break;
                    }
                }
                String id_estado = "";
                for (Map.Entry<String, String> estado : estados.entrySet()) {
                    if (estado.getValue().equals(cmbEstado.getSelectedItem().toString())) {
                        id_estado = estado.getKey();
                        break;
                    }
                }
                
                
                String id_cliente = "";

                for (Map.Entry<String, String> cliente : clienteSolicitando.entrySet()) {
                    if (cliente.getValue().equals(cmbClientes.getSelectedItem().toString())) {
                        id_cliente = cliente.getKey();
                        break;
                    }
                }
                String id_empleado = "";
                for (Map.Entry<String, String> empleado : empleados.entrySet()) {
                    if (empleado.getValue().equals(cmbEmpleados.getSelectedItem().toString())) {
                        id_empleado = empleado.getKey();
                        break;
                    }
                }

                PeticionView.guardarPeticion(model.getId(), txtNombre.getText(),
                        id_editorial, id_cliente,
                        Integer.parseInt(txtCantidadSolicitada.getText()), id_estado, id_empleado);

                dispose();
                PeticionView.mensaje("Se modifico la peticion del libro correctamente.");
            }

        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jplPrincipal = new javax.swing.JPanel();
        jplTítulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jplFormulario = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        cmbEditoriales = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCantidadSolicitada = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        cmbClientes = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbEmpleados = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jplPrincipal.setPreferredSize(new java.awt.Dimension(360, 360));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Modificar solicitud");
        jplTítulo.add(jLabel1);

        btnGuardar.setText("Guardar");

        javax.swing.GroupLayout jplFormularioLayout = new javax.swing.GroupLayout(jplFormulario);
        jplFormulario.setLayout(jplFormularioLayout);
        jplFormularioLayout.setHorizontalGroup(
            jplFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplFormularioLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jplFormularioLayout.setVerticalGroup(
            jplFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplFormularioLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnGuardar)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jLabel2.setText("Nombre");

        jLabel4.setText("Editorial");

        jLabel7.setText("Cliente solicitante");

        jLabel5.setText("Cantidad solicitada");

        jLabel6.setText("Estado");

        jLabel3.setText("Empleado");

        javax.swing.GroupLayout jplPrincipalLayout = new javax.swing.GroupLayout(jplPrincipal);
        jplPrincipal.setLayout(jplPrincipalLayout);
        jplPrincipalLayout.setHorizontalGroup(
            jplPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplPrincipalLayout.createSequentialGroup()
                .addGroup(jplPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jplPrincipalLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jplFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jplPrincipalLayout.createSequentialGroup()
                        .addGroup(jplPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jplPrincipalLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(jplPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jplPrincipalLayout.createSequentialGroup()
                                        .addGroup(jplPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel2))
                                        .addGap(75, 75, 75)
                                        .addGroup(jplPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbEditoriales, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtNombre)))
                                    .addGroup(jplPrincipalLayout.createSequentialGroup()
                                        .addGroup(jplPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(18, 18, 18)
                                        .addGroup(jplPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jplPrincipalLayout.createSequentialGroup()
                                                .addGroup(jplPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtCantidadSolicitada)
                                                    .addComponent(cmbEstado, 0, 148, Short.MAX_VALUE)
                                                    .addComponent(cmbEmpleados, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(cmbClientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(jplPrincipalLayout.createSequentialGroup()
                                .addContainerGap(37, Short.MAX_VALUE)
                                .addComponent(jplTítulo, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32)))
                .addContainerGap())
        );
        jplPrincipalLayout.setVerticalGroup(
            jplPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jplTítulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jplPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jplPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbEditoriales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jplPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(17, 17, 17)
                .addGroup(jplPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCantidadSolicitada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jplPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jplPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jplFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jplPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jplPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbClientes;
    private javax.swing.JComboBox<String> cmbEditoriales;
    private javax.swing.JComboBox<String> cmbEmpleados;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jplFormulario;
    private javax.swing.JPanel jplPrincipal;
    private javax.swing.JPanel jplTítulo;
    private javax.swing.JTextField txtCantidadSolicitada;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
