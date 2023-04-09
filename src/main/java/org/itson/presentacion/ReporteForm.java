/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.presentacion;

import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.itson.daos.TramiteDAO;
import org.itson.dominio.Licencia;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;
import org.itson.dominio.ReporteDTO;
import org.itson.dominio.Tramite;
import org.itson.interfaces.ITramiteDAO;
import org.itson.utils.ConfiguracionPaginado;

/**
 *Clase que contiene la pantalla en donde se consultaran los tramites dependiendo de la
 * busqueda que se haga, también genera un reporte de los seleccionados en la tabla
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
public class ReporteForm extends javax.swing.JFrame {

    LocalDate fechaActual = LocalDate.now();
    LocalDate minFecha = LocalDate.of(1900, 01, 01);
    ITramiteDAO dao = new TramiteDAO();
    private final ConfiguracionPaginado configPaginado;

    /**
     * Constructor que crea un ReporteForm que asigna un rango limite a los calendarios que no pase de 
     * la fecha actual y asigna el paginado de la tabla, a parte de crear un objeto de tipo ReporteDTO
     */
    public ReporteForm() {
        initComponents();
        calendar1.getSettings().setDateRangeLimits(minFecha, fechaActual);
        calendar2.getSettings().setDateRangeLimits(minFecha, fechaActual);
        this.configPaginado = new ConfiguracionPaginado(0, 3);
        ReporteDTO parametros;
    }

    /**
     * Método que crea un reporte usando JasperReports y lo llena con los elementos que se encuentran en
     * la tabla
     */
    public void previewJasper() {
        ArrayList listaReporte = new ArrayList();

        for (int i = 0; i < this.tblPersonas.getRowCount(); i++) {
            ReporteDTO reporte = new ReporteDTO(
                    this.tblPersonas.getValueAt(i, 0).toString(),
                    this.tblPersonas.getValueAt(i, 1).toString(),
                    this.tblPersonas.getValueAt(i, 2).toString(),
                    this.tblPersonas.getValueAt(i, 3).toString()
            );
            listaReporte.add(reporte);
            System.out.println(this.tblPersonas.getValueAt(i, 1));
        }

        JasperReport jr = null;
        try {
            jr = (JasperReport) JRLoader.loadObjectFromFile("Lulutenencia.jasper");
            HashMap parametro = new HashMap();
            parametro.put("logo", "/org.itson.utils/lulu.png");

            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, new JRBeanCollectionDataSource(listaReporte));

            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(ReporteForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que carga la tabla de los tramites realizados dependiendo de los parametros obtenidos
     * @param parametros parametros obtenidos para realizar la consulta con base en ellos
     */
    public void cargarTabla(ReporteDTO parametros) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) this.tblPersonas.getModel();
            modelo.setRowCount(0);

            if (this.cbxTipo.getSelectedItem().equals("Selecciona Trámite")) {
                JOptionPane.showMessageDialog(null, "Ingresa un tipo de trámite.", "Alerta", JOptionPane.ERROR_MESSAGE);
            } else {
                List<Tramite> TramiteBusqueda = dao.buscarTramites(parametros, configPaginado);
                for (Tramite tramite : TramiteBusqueda) {
                    Persona persona = tramite.getPersona();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String fechaFormateada = dateFormat.format(tramite.getFechaExpedicion());
                    if (tramite instanceof Placa && this.cbxTipo.getSelectedItem().equals("Placa")) {
                        Object[] fila = {persona.getNombres() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno(), "Placa", fechaFormateada, tramite.getCosto()};
                        modelo.addRow(fila);
                    } else if (tramite instanceof Licencia && this.cbxTipo.getSelectedItem().equals("Licencia")) {
                        Object[] fila = {persona.getNombres() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno(), "Licencia", fechaFormateada, tramite.getCosto()};
                        modelo.addRow(fila);
                    } else if (this.cbxTipo.getSelectedItem().equals("Ambos")) {
                        Object[] fila = {persona.getNombres() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno(), tramite.getClass().getSimpleName(), fechaFormateada, tramite.getCosto()};
                        modelo.addRow(fila);
                    }
                }
            }

            this.tblPersonas.setModel(modelo);
        } catch (NoResultException ex) {
            Logger.getLogger(ConsultaTramites1Form.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que hace que se avance la página de la tabla
     * @param parametros se necesita para cargar la tabla
     */
    private void avanzarPagina(ReporteDTO parametros) {
        this.configPaginado.avanzarPagina();
        this.cargarTabla(parametros);
    }

    /**
     * Método que hace que se retroceda la página 
     * @param parametros se necesita para cargar la tabla
     */
    private void retrocederPagina(ReporteDTO parametros) {
        this.configPaginado.retrocederPagina();
        this.cargarTabla(parametros);
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
        jLabel3 = new javax.swing.JLabel();
        txtfNombre = new javax.swing.JTextField();
        calendar1 = new com.github.lgooddatepicker.components.DatePicker();
        calendar2 = new com.github.lgooddatepicker.components.DatePicker();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonas = new javax.swing.JTable();
        btnConsultar = new javax.swing.JButton();
        btnReporte = new javax.swing.JToggleButton();
        btnMenu = new javax.swing.JButton();
        cbxTipo = new javax.swing.JComboBox<>();
        btnRetroceder = new javax.swing.JButton();
        cbxElementosPágina = new javax.swing.JComboBox<>();
        btnAvanzar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setText("Reporte");
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N

        jLabel2.setText("Nombre");
        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        jLabel3.setText("Tipo de trámite");
        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        txtfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfNombreKeyTyped(evt);
            }
        });

        jLabel4.setText("Inicio periodo");
        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        jLabel5.setText("Fin periodo");
        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        tblPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Tipo de trámite", "Fecha expedición", "Costo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPersonas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblPersonas);
        if (tblPersonas.getColumnModel().getColumnCount() > 0) {
            tblPersonas.getColumnModel().getColumn(0).setResizable(false);
            tblPersonas.getColumnModel().getColumn(1).setResizable(false);
            tblPersonas.getColumnModel().getColumn(2).setResizable(false);
            tblPersonas.getColumnModel().getColumn(3).setResizable(false);
        }

        btnConsultar.setText("Consultar");
        btnConsultar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnReporte.setText("Generar reporte");
        btnReporte.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        btnMenu.setText("Regresar al menú");
        btnMenu.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona Trámite", "Licencia", "Placa", "Ambos" }));

        btnRetroceder.setText("<----");
        btnRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtfNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(cbxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel4)
                                .addGap(36, 36, 36))
                            .addComponent(calendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(182, 182, 182)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(48, 48, 48))
                            .addComponent(calendar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(122, 122, 122))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(323, 323, 323))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(btnRetroceder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbxElementosPágina, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175)
                .addComponent(btnAvanzar)
                .addGap(104, 104, 104))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calendar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAvanzar)
                    .addComponent(btnRetroceder)
                    .addComponent(cbxElementosPágina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que te lleva al menú
     * @param evt evento que desencadena la acción 
     */
    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        MenuForm menu = new MenuForm();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMenuActionPerformed

    /**
     * Acción que al pulsar el botón de generar reporte, genera el reporte solicitado
     * @param evt evento que desencadena la acción
     */
    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        this.previewJasper();
    }//GEN-LAST:event_btnReporteActionPerformed

    /**
     * Acción que consulta los tramites dependiendo de lo recibido en los textos y los calendarios
     * @param evt evento que desencadena la acción
     */
    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        String nombre = null, tipo = null;

        nombre = this.txtfNombre.getText();

        LocalDate ca1 = null, ca2 = null;
        if (this.calendar1.getDate() != null) {
            ca1 = this.calendar1.getDate();
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese fecha de inicio de periodo", "Alerta", JOptionPane.ERROR_MESSAGE);
        }

        if (this.calendar2.getDate() != null) {
            if (this.calendar2.getDate().isAfter(ca1)) {
                ca2 = this.calendar2.getDate();
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese una fehca después de la inicial", "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese fecha de fin de periodo", "Alerta", JOptionPane.ERROR_MESSAGE);
        }

        if (cbxTipo.getSelectedItem().equals("Licencia")) {
            tipo = "Licencia";
        } else if (cbxTipo.getSelectedItem().equals("Placa")) {
            tipo = "Placa";
        } else if (cbxTipo.getSelectedItem().equals("Ambos")) {
            tipo = "Todo";
        }

        ReporteDTO parametros = new ReporteDTO(nombre, tipo, ca1, ca2);

        this.cargarTabla(parametros);
    }//GEN-LAST:event_btnConsultarActionPerformed

    /**
     * Acción que hace retroceder el paginado de la tabla
     * @param evt evento que desencadena la acción
     */
    private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
        // TODO add your handling code here:
        String nombre = null, tipo = null;

        nombre = this.txtfNombre.getText();

        LocalDate ca1 = null, ca2 = null;
        if (!this.calendar1.getDate().equals("")) {
            ca1 = this.calendar1.getDate();
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese fecha de inicio de periodo", "Alerta", JOptionPane.ERROR_MESSAGE);
        }

        if (!this.calendar2.getDate().equals("")) {
            if (this.calendar2.getDate().isAfter(ca1)) {
                ca2 = this.calendar2.getDate();
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese una fehca después de la inicial", "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese fecha de fin de periodo", "Alerta", JOptionPane.ERROR_MESSAGE);
        }

        if (cbxTipo.getSelectedItem().equals("Licencia")) {
            tipo = "Licencia";
        } else if (cbxTipo.getSelectedItem().equals("Placa")) {
            tipo = "Placa";
        } else if (cbxTipo.getSelectedItem().equals("Todo :)")) {
            tipo = "Todo";
        } else {
            JOptionPane.showMessageDialog(null, "Elija un tipo de trámite", "Alerta", JOptionPane.ERROR_MESSAGE);
        }

        ReporteDTO parametros = new ReporteDTO(nombre, tipo, ca1, ca2);
        retrocederPagina(parametros);
    }//GEN-LAST:event_btnRetrocederActionPerformed

    /**
     * Acción que revisa si cambio un elemento de la combobox y te lleva a esa pagina
     * @param evt evento que desencadena la acción
     */
    private void cbxElementosPáginaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxElementosPáginaItemStateChanged
        String nombre = null, tipo = null;
        nombre = this.txtfNombre.getText();

        LocalDate ca1 = null, ca2 = null;
        if (!this.calendar1.getDate().equals("")) {
            ca1 = this.calendar1.getDate();
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese fecha de inicio de periodo", "Alerta", JOptionPane.ERROR_MESSAGE);
        }

        if (!this.calendar2.getDate().equals("")) {
            if (this.calendar2.getDate().isAfter(ca1)) {
                ca2 = this.calendar2.getDate();
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese una fehca después de la inicial", "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese fecha de fin de periodo", "Alerta", JOptionPane.ERROR_MESSAGE);
        }

        if (cbxTipo.getSelectedItem().equals("Licencia")) {
            tipo = "Licencia";
        } else if (cbxTipo.getSelectedItem().equals("Placa")) {
            tipo = "Placa";
        } else if (cbxTipo.getSelectedItem().equals("Todo :)")) {
            tipo = "Todo";
        } else {
            JOptionPane.showMessageDialog(null, "Elija un tipo de trámite", "Alerta", JOptionPane.ERROR_MESSAGE);
        }

        ReporteDTO parametros = new ReporteDTO(nombre, tipo, ca1, ca2);
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int elementoPorPagina = Integer.parseInt(evt.getItem().toString());
            this.configPaginado.setElementosPagina(elementoPorPagina);
            this.cargarTabla(parametros);
        }
    }//GEN-LAST:event_cbxElementosPáginaItemStateChanged

    /**
     * Acción que hace avanzar el paginado de la tabla
     * @param evt evento que desencadena la acción 
     */
    private void btnAvanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarActionPerformed
        String nombre = null, tipo = null;
        nombre = this.txtfNombre.getText();

        LocalDate ca1 = null, ca2 = null;
        if (!this.calendar1.getDate().equals("")) {
            ca1 = this.calendar1.getDate();
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese fecha de inicio de periodo", "Alerta", JOptionPane.ERROR_MESSAGE);
        }

        if (!this.calendar2.getDate().equals("")) {
            ca1 = this.calendar2.getDate();
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese fecha de inicio de periodo", "Alerta", JOptionPane.ERROR_MESSAGE);
        }

        if (!this.calendar2.getDate().equals("")) {
            if (this.calendar2.getDate().isAfter(ca1)) {
                ca2 = this.calendar2.getDate();
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese una fehca después de la inicial", "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese fecha de fin de periodo", "Alerta", JOptionPane.ERROR_MESSAGE);
        }

        if (cbxTipo.getSelectedItem().equals("Licencia")) {
            tipo = "Licencia";
        } else if (cbxTipo.getSelectedItem().equals("Placa")) {
            tipo = "Placa";
        } else if (cbxTipo.getSelectedItem().equals("Todo :)")) {
            tipo = "Todo";
        } else {
            JOptionPane.showMessageDialog(null, "Elija un tipo de trámite", "Alerta", JOptionPane.ERROR_MESSAGE);
        }

        ReporteDTO parametros = new ReporteDTO(nombre, tipo, ca1, ca2);
        avanzarPagina(parametros);
    }//GEN-LAST:event_btnAvanzarActionPerformed

    /**
     * Evento que hace que no se puedan ingresar espacios y que las letras que se ingrenen en el campo
     * de texto se hagan mayúsculas en el campo de texto de nombre
     * @param evt evento que desencadena la acción 
     */
    private void txtfNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfNombreKeyTyped
        // TODO add your handling code here:
        if (txtfNombre.getText().length() >= 50) {
            evt.consume();
        }
        final char keyChar = evt.getKeyChar();
        if (!(Character.isLetter(keyChar) || (keyChar == KeyEvent.VK_BACK_SPACE) || keyChar == KeyEvent.VK_DELETE || Character.isWhitespace(keyChar))) {
            evt.consume();
        } else if (Character.isLowerCase(keyChar)) {
            evt.setKeyChar((keyChar));
        }
    }//GEN-LAST:event_txtfNombreKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvanzar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JToggleButton btnReporte;
    private javax.swing.JButton btnRetroceder;
    private com.github.lgooddatepicker.components.DatePicker calendar1;
    private com.github.lgooddatepicker.components.DatePicker calendar2;
    private javax.swing.JComboBox<String> cbxElementosPágina;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPersonas;
    private javax.swing.JTextField txtfNombre;
    // End of variables declaration//GEN-END:variables
}
