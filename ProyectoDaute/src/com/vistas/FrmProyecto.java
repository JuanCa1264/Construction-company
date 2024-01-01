/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vistas;

import com.Dao.DaoProyecto;
import com.modelo.MateriaPrima;
import com.modelo.Proyecto;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class FrmProyecto extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmProyecto
     */
    public FrmProyecto() {
        initComponents();
        tablaProyecto();
    }

    Proyecto p = new Proyecto();
    DaoProyecto dp = new DaoProyecto();
    
    public void insertar(){
        
        try {
            
            p.setNombreProyecto(this.txtNombrePro.getText());
            p.setUbicacionProyecto(this.txtUbicacion.getText());
            p.setFechaInicio(this.txtFechaI.getText());
            p.setFechaFin(this.txtFechaF.getText());
            p.setTipoProyecto(this.txtTipoPro.getText());
            p.setInversionInicial(Double.parseDouble(this.txtInversion.getText()));
            p.setEstadoProyecto(this.cmbEstadoPro.getSelectedItem().toString());
            p.setEstado(1);
            
        
            dp.insertarProyecto(p);
        
        JOptionPane.showMessageDialog(null, "Datos insertados con éxito");
        
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void modificar(){
        
        try {
            
            p.setNombreProyecto(this.txtNombrePro.getText());
            p.setUbicacionProyecto(this.txtUbicacion.getText());
            p.setFechaInicio(this.txtFechaI.getText());
            p.setFechaFin(this.txtFechaF.getText());
            p.setTipoProyecto(this.txtTipoPro.getText());
            p.setInversionInicial(Double.parseDouble(this.txtInversion.getText()));
            p.setEstadoProyecto(this.cmbEstadoPro.getSelectedItem().toString());
            p.setId_Proyecto(Integer.parseInt(this.txtId.getText()));
            
        
            dp.modificarProyecto(p);
        
        JOptionPane.showMessageDialog(null, "Datos modificados con éxito");
        
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void eliminar(){
        try {
            p.setId_Proyecto(Integer.parseInt(this.txtId.getText()));
            int SioNo = JOptionPane.showConfirmDialog(this, "Desea eliminar el empleado","Eliminar empleado", JOptionPane.YES_NO_OPTION);
            
            if (SioNo==0) {
                dp.eliminarProyecto(p);
                JOptionPane.showMessageDialog(rootPane, "Eliminado con éxito","Confirmación", JOptionPane.INFORMATION_MESSAGE);
                tablaProyecto();
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void eliminarL(){
        try {
            p.setId_Proyecto(Integer.parseInt(this.txtId.getText()));
            p.setEstado(0);
            int SioNo = JOptionPane.showConfirmDialog(this, "Desea eliminar la facultad","Eliminar facultad", JOptionPane.YES_NO_OPTION);
            
            if (SioNo==0) {
                dp.eliminarProyectoLogico(p);
                JOptionPane.showMessageDialog(rootPane, "Eliminado con éxito","Confirmación", JOptionPane.INFORMATION_MESSAGE);
                tablaProyecto();
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void tablaProyecto(){
        String [] cols = {"Código Proyecto","Nombre", "Ubicación","Fecha Inicio","Fecha Fin","Tipo","Inversión Inicial", "Estado Proyecto", "Estado"};
        Object[] obj = new Object[9];
        DefaultTableModel tabla = new DefaultTableModel(null, cols);
        List ls;
        
        try {
            ls = dp.mostrarProyecto();
            for (int i = 0; i <ls.size(); i++) {
                p = (Proyecto)ls.get(i);
                obj[0] = p.getId_Proyecto();
                obj[1] = p.getNombreProyecto();
                obj[2] = p.getUbicacionProyecto();
                obj[3] = p.getFechaInicio();
                obj[4] = p.getFechaFin();
                obj[5] = p.getTipoProyecto();
                obj[6] = p.getInversionInicial();
                obj[7] = p.getEstadoProyecto();
                obj[8] = p.getEstado();
                
                
                tabla.addRow(obj);
            }
            
            
            this.jTable1.setModel(tabla);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al mostrar datos de la empleado "+e.toString());
        }
        
        
        
    }
    
     public void llenarCampos(){
        
        int fila = this.jTable1.getSelectedRow();
        this.txtId.setText(String.valueOf(this.jTable1.getValueAt(fila, 0)));
        this.txtNombrePro.setText(String.valueOf(this.jTable1.getValueAt(fila, 1)));
        this.txtUbicacion.setText(String.valueOf(this.jTable1.getValueAt(fila, 2)));
        this.txtFechaI.setText(String.valueOf(this.jTable1.getValueAt(fila, 3)));   
        this.txtFechaF.setText(String.valueOf(this.jTable1.getValueAt(fila, 4))); 
        this.txtTipoPro.setText(String.valueOf(this.jTable1.getValueAt(fila, 5)));  
        this.txtInversion.setText(String.valueOf(this.jTable1.getValueAt(fila, 6)));
        String estadoP = String.valueOf(this.jTable1.getValueAt(fila, 7));
        this.cmbEstadoPro.getModel().setSelectedItem(estadoP);
        
        
         
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombrePro = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtUbicacion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTipoPro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtInversion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbEstadoPro = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnDetalle = new javax.swing.JButton();
        txtFechaI = new javax.swing.JFormattedTextField();
        txtFechaF = new javax.swing.JFormattedTextField();
        btnDetalleRRHH = new javax.swing.JButton();
        btnDetalleMaq = new javax.swing.JButton();
        btnDetalleMaq1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        btnAgregar.setText("AGREGAR");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });

        jLabel2.setText("Nombre Proyecto");

        btnModificar.setText("MODIFICAR");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/agregar-nueva-pagina.png"))); // NOI18N
        jLabel1.setText("GESTION PROYECTO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        btnEliminar1.setText("ELIMINADO LOGICO");
        btnEliminar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminar1MouseClicked(evt);
            }
        });

        jLabel11.setText("Ubicacion");

        jLabel12.setText("Fecha Inicio");

        jLabel13.setText("Fecha Finalizacion");

        jLabel3.setText("Tipo Proyecto");

        jLabel4.setText("Inversion Inicial");

        jLabel5.setText("Estado Proyecto");

        cmbEstadoPro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---Selecciona Una Opcion---", "Iniciado", "En Progreso", "Finalizado" }));

        jLabel6.setText("Id Proyecto");

        txtId.setEditable(false);

        btnDetalle.setText("Agregar Detalle");
        btnDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDetalleMouseClicked(evt);
            }
        });

        try {
            txtFechaI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtFechaF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnDetalleRRHH.setText("Agregar Detalle RRHH");
        btnDetalleRRHH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDetalleRRHHMouseClicked(evt);
            }
        });

        btnDetalleMaq.setText("Agregar Detalle Maquinaria");
        btnDetalleMaq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDetalleMaqMouseClicked(evt);
            }
        });

        btnDetalleMaq1.setText("Agregar Detalle Maquinaria");
        btnDetalleMaq1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDetalleMaq1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnDetalle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addGap(26, 26, 26)
                        .addComponent(btnDetalleRRHH)
                        .addGap(35, 35, 35)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar1)
                        .addGap(85, 85, 85)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombrePro, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(34, 34, 34)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtTipoPro, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtInversion, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addGap(121, 121, 121))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(39, 39, 39)
                                        .addComponent(txtFechaF, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbEstadoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(120, 120, 120)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(173, 173, 173))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnDetalleMaq1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDetalleMaq)
                        .addGap(228, 228, 228))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombrePro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtTipoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(txtFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtInversion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFechaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbEstadoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnEliminar1)
                    .addComponent(btnDetalle)
                    .addComponent(btnDetalleRRHH))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetalleMaq)
                    .addComponent(btnDetalleMaq1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetalleMouseClicked
        FrmDetalleProyecto detalle = new FrmDetalleProyecto(Integer.parseInt(this.txtId.getText()));
        Principal.desktop.add(detalle);
        detalle.toFront();
        detalle.setVisible(true);
        FrmDetalleProyecto.txtId.setText(this.txtId.getText());
    }//GEN-LAST:event_btnDetalleMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        llenarCampos();
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnDetalleRRHHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetalleRRHHMouseClicked
        try {
            FrmDetalleRRHH detalleRH = new FrmDetalleRRHH(Integer.parseInt(this.txtId.getText()));
            Principal.desktop.add(detalleRH);
            detalleRH.toFront();
            detalleRH.setVisible(true);
            FrmDetalleRRHH.txtId.setText(this.txtId.getText());
            
        } catch (Exception ex) {
            Logger.getLogger(FrmProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDetalleRRHHMouseClicked

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        insertar();
        tablaProyecto();
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        modificar();
        tablaProyecto();
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        eliminar();
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnEliminar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminar1MouseClicked
        eliminarL();
    }//GEN-LAST:event_btnEliminar1MouseClicked

    private void btnDetalleMaqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetalleMaqMouseClicked
            try {
            FrmDetalleMaquinaria detalleMaq = new FrmDetalleMaquinaria(Integer.parseInt(this.txtId.getText()));
            Principal.desktop.add(detalleMaq);
            detalleMaq.toFront();
            detalleMaq.setVisible(true);
            FrmDetalleMaquinaria.txtProyecto.setText(this.txtId.getText());
            
        } catch (Exception ex) {
            Logger.getLogger(FrmProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDetalleMaqMouseClicked

    private void btnDetalleMaq1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetalleMaq1MouseClicked
        try {
            FrmDetalleMateriaPrima detalleMaq = new FrmDetalleMateriaPrima();
            Principal.desktop.add(detalleMaq);
            detalleMaq.toFront();
            detalleMaq.setVisible(true);
            FrmDetalleMaquinaria.txtProyecto.setText(this.txtId.getText());
            
        } catch (Exception ex) {
            Logger.getLogger(FrmProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDetalleMaq1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnDetalle;
    private javax.swing.JButton btnDetalleMaq;
    private javax.swing.JButton btnDetalleMaq1;
    private javax.swing.JButton btnDetalleRRHH;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox cmbEstadoPro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JFormattedTextField txtFechaF;
    private javax.swing.JFormattedTextField txtFechaI;
    public javax.swing.JTextField txtId;
    private javax.swing.JTextField txtInversion;
    private javax.swing.JTextField txtNombrePro;
    private javax.swing.JTextField txtTipoPro;
    private javax.swing.JTextField txtUbicacion;
    // End of variables declaration//GEN-END:variables
}
