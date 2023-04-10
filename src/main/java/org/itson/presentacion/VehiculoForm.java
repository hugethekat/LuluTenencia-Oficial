/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.presentacion;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import org.itson.daos.AutomovilDAO;
import org.itson.daos.LicenciaDAO;
import org.itson.daos.PersonaDAO;
import org.itson.daos.VehiculoDAO;
import org.itson.dominio.Automovil;
import org.itson.dominio.Persona;
import org.itson.interfaces.IAutomovilDAO;
import org.itson.interfaces.ILicenciaDAO;
import org.itson.interfaces.IPersonaDAO;
import org.itson.interfaces.IVehiculoDAO;

/**
 *Clase que contiene la pantalla donde se registrarán los vehiculos
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
public class VehiculoForm extends javax.swing.JFrame {

    IPersonaDAO daoP = new PersonaDAO();
    ILicenciaDAO daoL = new LicenciaDAO();
    IAutomovilDAO daoA = new AutomovilDAO();
    IVehiculoDAO daoV = new VehiculoDAO();

    private String rfc;

    /**
     * Constructor que crea un VehiculoForm y recibe un rfc para llenar los campos de la persona que 
     * registrará un vehiculo
     * @param rfc rfc de la persona
     */
    public VehiculoForm(String rfc) {
        this.rfc = rfc;
        initComponents();
        lblLulu.setVisible(false);
        txtfRfc.setText(rfc);
        buscar(rfc);
    }

    /**
     * Constructor de VehiculoForm por omisión
     */
    public VehiculoForm() {
        initComponents();
    }

    /**
     * Método que busca una persona por su rfc para llenar labels con sus datos
     * @param rfc identificador de persona que se utiliza para buscar a una persona
     */
    public void buscar(String rfc) {
        Persona persona = new Persona();
        persona = daoP.consultar(rfc);
        this.lblNombre.setText(persona.getNombres() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno());
        this.lblTelefono.setText(persona.getTelefono());
        lblLulu.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtfRfc = new javax.swing.JTextField();
        txtfMarca = new javax.swing.JTextField();
        txtfSerie = new javax.swing.JTextField();
        txtfLinea = new javax.swing.JTextField();
        txtfModelo = new javax.swing.JTextField();
        txtfColor = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblLulu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de vehículos");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        jLabel1.setText("Registrar Vehículo");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel2.setText("RFC");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel4.setText("No. Serie");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel5.setText("Marca");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel6.setText("Línea");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel7.setText("Color");

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel8.setText("Modelo");

        txtfRfc.setEditable(false);
        txtfRfc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfRfcKeyTyped(evt);
            }
        });

        txtfMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfMarcaKeyTyped(evt);
            }
        });

        txtfSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfSerieKeyTyped(evt);
            }
        });

        txtfLinea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfLineaKeyTyped(evt);
            }
        });

        txtfModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfModeloKeyTyped(evt);
            }
        });

        txtfColor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfColorKeyTyped(evt);
            }
        });

        btnRegistrar.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        btnRegistrar.setText("Registrar vehículo");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnMenu.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnMenu.setText("Regresar al menú");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        lblTelefono.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        lblLulu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/lulu.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfColor, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(237, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(btnMenu)
                        .addGap(31, 31, 31))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtfRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGap(164, 164, 164))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblLulu, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtfRfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblLulu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtfSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtfLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtfColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtfModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Acción que al presionar el botón btnMenu te mande al form del Menu
     * @param evt evento que desencadena la acción
     */
    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        MenuForm mf = new MenuForm();
        mf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMenuActionPerformed

    /**
     * Acción que al presionar el botón de registrar te registre un vehículo con los datos obtenidos de los 
     * campos de texto
     * @param evt evento que desencadena la acción
     */
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String rfc = this.txtfRfc.getText();
        String no_serie = this.txtfSerie.getText();
        String marca = this.txtfMarca.getText();
        String linea = this.txtfLinea.getText();
        String color = this.txtfColor.getText();
        String modelo = this.txtfModelo.getText();

        if (daoL.consultarLicencia(rfc)) {
            Persona persona = daoP.consultar(rfc);
            Automovil automovil = new Automovil();
            if(daoV.buscar(no_serie)==null){
            automovil.setNoSerie(no_serie);
            automovil.setColor(color);
            automovil.setMarca(marca);
            automovil.setLinea(linea);
            automovil.setModelo(modelo);
            automovil.setPersona(persona);
            daoA.registrarAutomovil(automovil);
            PlacaForm pf = new PlacaForm(rfc, no_serie);
            pf.setVisible(true);
            System.out.println(rfc);
            System.out.println(no_serie);
            this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "El número de serie ya se encuentra registrado.", "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se pudo registrar el vehículo ya que la licencia de la persona está vencida", "Licencia no válida", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    /**
     * Evento que hace que no se puedan ingresar espacios y que las letras que se ingrenen en el campo
     * de texto se hagan mayúsculas en el campo de texto de rfc
     * @param evt evento que desencadena la acción
     */
    private void txtfRfcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfRfcKeyTyped
        // TODO add your handling code here:
        if (txtfRfc.getText().length() >= 50) {
            evt.consume();
        }
        final char keyChar = evt.getKeyChar();
        if (!(Character.isLetterOrDigit(keyChar) || (keyChar == KeyEvent.VK_BACK_SPACE) || keyChar == KeyEvent.VK_DELETE)) {
            evt.consume();
        } else if (Character.isLowerCase(keyChar)) {
            evt.setKeyChar(Character.toUpperCase(keyChar));
        }
    }//GEN-LAST:event_txtfRfcKeyTyped

    /**
     * Evento que hace que no se puedan ingresar espacios y que las letras que se ingrenen en el campo
     * de texto se hagan mayúsculas en el campo de texto de numero de serie
     * @param evt evento que desencadena la acción
     */
    private void txtfSerieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfSerieKeyTyped
        // TODO add your handling code here:
        if (txtfSerie.getText().length() >= 50) {
            evt.consume();
        }
        final char keyChar = evt.getKeyChar();
        if (!(Character.isLetterOrDigit(keyChar) || (keyChar == KeyEvent.VK_BACK_SPACE) || keyChar == KeyEvent.VK_DELETE)) {
            evt.consume();
        } else if (Character.isLowerCase(keyChar)) {
            evt.setKeyChar(Character.toUpperCase(keyChar));
        }
    }//GEN-LAST:event_txtfSerieKeyTyped

    /**
     * Evento que hace que no se puedan ingresar espacios y que las letras que se ingrenen en el campo
     * de texto se hagan mayúsculas en el campo de texto de marca
     * @param evt evento que desencadena la acción
     */
    private void txtfMarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfMarcaKeyTyped
        // TODO add your handling code here:
        if (txtfMarca.getText().length() >= 50) {
            evt.consume();
        }
        final char keyChar = evt.getKeyChar();
        if (!(Character.isLetterOrDigit(keyChar) || (keyChar == KeyEvent.VK_BACK_SPACE) || keyChar == KeyEvent.VK_DELETE)) {
            evt.consume();
        } else if (Character.isLowerCase(keyChar)) {
            evt.setKeyChar(Character.toUpperCase(keyChar));
        }
    }//GEN-LAST:event_txtfMarcaKeyTyped

    /**
     * Evento que hace que no se puedan ingresar espacios y que las letras que se ingrenen en el campo
     * de texto se hagan mayúsculas en el campo de texto de línea
     * @param evt evento que desencadena la acción
     */
    private void txtfLineaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfLineaKeyTyped
        // TODO add your handling code here:
        if (txtfLinea.getText().length() >= 50) {
            evt.consume();
        }
        final char keyChar = evt.getKeyChar();
        if (!(Character.isLetterOrDigit(keyChar) || (keyChar == KeyEvent.VK_BACK_SPACE) || keyChar == KeyEvent.VK_DELETE)) {
            evt.consume();
        } else if (Character.isLowerCase(keyChar)) {
            evt.setKeyChar(Character.toUpperCase(keyChar));
        }
    }//GEN-LAST:event_txtfLineaKeyTyped

    /**
     * Evento que hace que no se puedan ingresar espacios y que las letras que se ingrenen en el campo
     * de texto se hagan mayúsculas en el campo de texto de color
     * @param evt evento que desencadena la acción
     */
    private void txtfColorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfColorKeyTyped
        // TODO add your handling code here:
        if (txtfColor.getText().length() >= 50) {
            evt.consume();
        }
        final char keyChar = evt.getKeyChar();
        if (!(Character.isLetterOrDigit(keyChar) || (keyChar == KeyEvent.VK_BACK_SPACE) || keyChar == KeyEvent.VK_DELETE)) {
            evt.consume();
        } else if (Character.isLowerCase(keyChar)) {
            evt.setKeyChar(Character.toUpperCase(keyChar));
        }
    }//GEN-LAST:event_txtfColorKeyTyped

    /**
     * Evento que hace que no se puedan ingresar espacios y que las letras que se ingrenen en el campo
     * de texto se hagan mayúsculas en el campo de texto de modelo
     * @param evt evento que desencadena la acción
     */
    private void txtfModeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfModeloKeyTyped
        // TODO add your handling code here:
        if (txtfModelo.getText().length() >= 4) {
            evt.consume();
        }
        final char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar) || (keyChar == KeyEvent.VK_BACK_SPACE) || keyChar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtfModeloKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLulu;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTextField txtfColor;
    private javax.swing.JTextField txtfLinea;
    private javax.swing.JTextField txtfMarca;
    private javax.swing.JTextField txtfModelo;
    private javax.swing.JTextField txtfRfc;
    private javax.swing.JTextField txtfSerie;
    // End of variables declaration//GEN-END:variables
}
