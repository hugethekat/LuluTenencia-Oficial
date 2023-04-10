/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.presentacion;

import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.itson.daos.PersonaDAO;
import org.itson.daos.TramiteDAO;
import org.itson.dominio.Licencia;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;
import org.itson.dominio.Tramite;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IPersonaDAO;
import org.itson.interfaces.ITramiteDAO;
import org.itson.utils.ConfiguracionPaginado;

/**
 * 2da parte del form de consutar trámites
 *
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
public class ConsultaTramites2Form extends javax.swing.JFrame {

    /**
     * Se crea un objeto de tipo PersonaDAO
     */
    IPersonaDAO daoP = new PersonaDAO();
    /**
     * Se crea un objeto de tipo TramiteDAO
     */
    ITramiteDAO daoT = new TramiteDAO();
    /**
     * Se crea un objeto de tipo ConfiguracionPaginado
     */
    private final ConfiguracionPaginado configPaginado;

    /**
     * Constructor que crea un ConsultaTramites2Form que obtiene el rfc de la
     * persona seleccionada en el formulario anterior para poder cargar los
     * campos de texto con sus datos
     *
     * @param rfc identificador de la persona a buscar
     * @throws PersistenciaException si ocurre un error.
     */
    public ConsultaTramites2Form(String rfc) throws PersistenciaException {
        Persona persona = daoP.consultar(rfc);
        initComponents();
        this.cargarTextField(persona);
        setLocationRelativeTo(null);
        this.configPaginado = new ConfiguracionPaginado(0, 3);
        this.cargarTabla();
    }

    /**
     * Método que carga los campos de texto de la persona previamente
     * seleccionada
     *
     * @param persona persona a la cual se le obtienen los datos
     */
    public void cargarTextField(Persona persona) {
        this.txtfRfc.setText(persona.getRfc());
        this.txtfNombre.setText(persona.getNombres() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno());
        this.txtfTelefono.setText(persona.getTelefono());
        Integer anio = persona.getFechaNacimiento().getYear();
        this.txtfAnioNac.setText(anio.toString());
    }

    /**
     * Método que carga la tabla con los tramites consultados de la obtenida en
     * el constructor
     */
    public void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) this.tblTramites.getModel();
        modelo.setRowCount(0);
        List<Tramite> tramitesBusqueda = daoT.consultarTramites(this.txtfRfc.getText(), configPaginado);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (Tramite tramite : tramitesBusqueda) {
            if (tramite instanceof Placa) {
                Object[] fila = {"Placa", dateFormat.format(tramite.getFechaExpedicion()), tramite.getCosto()};
                modelo.addRow(fila);
            } else if (tramite instanceof Licencia) {
                Object[] fila = {"Licencia", dateFormat.format(tramite.getFechaExpedicion()), tramite.getCosto()};
                modelo.addRow(fila);
            }
        }
    }

    /**
     * Método que hace avanza la página actual de la tabla
     */
    private void avanzarPagina() {
        this.configPaginado.avanzarPagina();
        this.cargarTabla();
    }

    /**
     * Método que hace retroceder la página actual de la tabla
     */
    private void retrocederPagina() {
        this.configPaginado.retrocederPagina();
        this.cargarTabla();
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
        txtfAnioNac = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtfNombre = new javax.swing.JTextField();
        txtfRfc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtfTelefono = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTramites = new javax.swing.JTable();
        btnMenu = new javax.swing.JButton();
        cbxElementosPágina = new javax.swing.JComboBox<>();
        btnAvanzar = new javax.swing.JButton();
        btnRetroceder = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        txtfAnioNac.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel4.setText("Año de nacimiento");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel3.setText("Nombre");

        txtfNombre.setEditable(false);

        txtfRfc.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel2.setText("RFC");

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        jLabel1.setText("Consultar trámites");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel5.setText("Teléfono");

        txtfTelefono.setEditable(false);

        tblTramites.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo trámite", "Fecha expedición", "Costo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTramites);

        btnMenu.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        btnMenu.setText("Regresar al menú");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        cbxElementosPágina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "5", "10" }));
        cbxElementosPágina.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxElementosPáginaItemStateChanged(evt);
            }
        });

        btnAvanzar.setText("---->");
        btnAvanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarActionPerformed(evt);
            }
        });

        btnRetroceder.setText("<----");
        btnRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        btnSalir.setText("Regresar a la Consulta");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtfRfc)
                                    .addComponent(txtfNombre)
                                    .addComponent(txtfAnioNac, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                    .addComponent(txtfTelefono))
                                .addGap(29, 29, 29))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnRetroceder)
                                .addGap(176, 176, 176)
                                .addComponent(cbxElementosPágina, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(154, 154, 154)
                                .addComponent(btnAvanzar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(btnSalir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btnMenu)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtfRfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfAnioNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAvanzar)
                    .addComponent(btnRetroceder)
                    .addComponent(cbxElementosPágina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Acción que te manda de regreso al menú principal
     *
     * @param evt evento que desencadena la acción
     */
    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        MenuForm mf = new MenuForm();
        mf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMenuActionPerformed

    /**
     * Acción que cambia la manera de paginar la tabla
     *
     * @param evt evento que desencadena la acción
     */
    private void cbxElementosPáginaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxElementosPáginaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int elementoPorPagina = Integer.parseInt(evt.getItem().toString());
            this.configPaginado.setElementosPagina(elementoPorPagina);
            this.cargarTabla();
        }
    }//GEN-LAST:event_cbxElementosPáginaItemStateChanged

    /**
     * Acción que hace retroceder la página de la tabla
     *
     * @param evt evento que desencadena la acción
     */
    private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
        retrocederPagina();
    }//GEN-LAST:event_btnRetrocederActionPerformed

    /**
     * Acción que hace avanzar la página de la tabla
     *
     * @param evt evento que desencadena la acción
     */
    private void btnAvanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarActionPerformed
        avanzarPagina();
    }//GEN-LAST:event_btnAvanzarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        ConsultaTramites1Form cf = new ConsultaTramites1Form();
        cf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvanzar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxElementosPágina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTramites;
    private javax.swing.JTextField txtfAnioNac;
    private javax.swing.JTextField txtfNombre;
    private javax.swing.JTextField txtfRfc;
    private javax.swing.JTextField txtfTelefono;
    // End of variables declaration//GEN-END:variables
}
