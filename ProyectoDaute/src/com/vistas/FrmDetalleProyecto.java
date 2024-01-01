/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vistas;

import com.Dao.DaoDetalleProyecto;
import com.modelo.DetalleProyecto;
import com.modelo.RRHH;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JC
 */
public class FrmDetalleProyecto extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmDetalleProyecto
     * @param idP
     */
    public FrmDetalleProyecto(int idP) {
        
        initComponents();
        tablaDetalleP(idP);
    }
    
    DetalleProyecto dp = new DetalleProyecto();
    DaoDetalleProyecto ddp = new DaoDetalleProyecto();
    
    public void insertar(){
        
        try {
            dp.setId_Proyecto(Integer.parseInt(this.txtId.getText()));
            dp.setAtrasos(this.txtIncon.getText());
            dp.setPorcentajeU(this.txtPercent.getText());
            dp.setPorcentajeAvance(this.txtAvance.getText());
            dp.setEstado(1);
        
            ddp.insertarDetalleP(dp);
        
        JOptionPane.showMessageDialog(null, "Datos insertados con éxito");
        
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void tablaDetalleP(int idP){
        String [] cols = {"Nombre Proyecto", "Código detalle", "Atrasos","Porcentaje Utilidad", "Porcentaje Avance"};
        Object[] obj = new Object[5];
        DefaultTableModel tabla = new DefaultTableModel(null, cols);
        List ls;
        
        try {
            ls = ddp.mostrarDetalleP(idP);
            for (int i = 0; i <ls.size(); i++) {
                dp = (DetalleProyecto)ls.get(i);
                obj[0] = dp.getNombreProyecto();
                obj[1] = dp.getDetalle_Proyecto();
                obj[2] = dp.getAtrasos();
                obj[3] = dp.getPorcentajeU();
                obj[4] = dp.getPorcentajeAvance();
                
                
                tabla.addRow(obj);
            }
            
            
            this.jTable1.setModel(tabla);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al mostrar datos de la empleado "+e.toString());
        }
               
    }
    
     public void modificar(){
        
        try {
            
            dp.setAtrasos(this.txtIncon.getText());
            dp.setPorcentajeU(this.txtPercent.getText());
            dp.setPorcentajeAvance(this.txtAvance.getText());
            dp.setDetalle_Proyecto(Integer.parseInt(this.txtIdDetail.getText()));
        
            ddp.modificarDetalleP(dp);
        
        JOptionPane.showMessageDialog(null, "Datos insertados con éxito");
        
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
     
     public void eliminarDetalleP(){
        try {
            
        dp.setDetalle_Proyecto(Integer.parseInt(this.txtIdDetail.getText()));
            int SioNo = JOptionPane.showConfirmDialog(this, "Desea eliminar el detalle","Eliminar Carrera", JOptionPane.YES_NO_OPTION);
            
            if (SioNo==0) {
                ddp.eliminarDetalleP(dp);
                JOptionPane.showMessageDialog(rootPane, "Eliminado con éxito","Confirmación", JOptionPane.INFORMATION_MESSAGE);
                tablaDetalleP(Integer.parseInt(this.txtId.getText()));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
     
         public void eliminarL(){
        try {
            dp.setDetalle_Proyecto(Integer.parseInt(this.txtIdDetail.getText()));
            dp.setEstado(0);
            int SioNo = JOptionPane.showConfirmDialog(this, "Desea eliminar el detalle","Eliminar facultad", JOptionPane.YES_NO_OPTION);
            
            if (SioNo==0) {
                ddp.eliminarDetallePLogico(dp);
                JOptionPane.showMessageDialog(rootPane, "Eliminado con éxito","Confirmación", JOptionPane.INFORMATION_MESSAGE);
                tablaDetalleP(Integer.parseInt(this.txtId.getText()));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
     
     public void llenarCampos(){
        
        int fila = this.jTable1.getSelectedRow();
        this.txtIdDetail.setText(String.valueOf(this.jTable1.getValueAt(fila, 1)));
        this.txtIncon.setText(String.valueOf(this.jTable1.getValueAt(fila, 2)));  
        this.txtPercent.setText(String.valueOf(this.jTable1.getValueAt(fila, 3)));  
        this.txtAvance.setText(String.valueOf(this.jTable1.getValueAt(fila, 4)));  
        
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtIncon = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txtPercent = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAvance = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnMod = new javax.swing.JButton();
        txtIdDetail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnDel = new javax.swing.JButton();
        btnLogico = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setText("Código del Proyecto");

        txtId.setEditable(false);

        jLabel2.setText("Atrasos o Inconvenientes");

        txtIncon.setColumns(20);
        txtIncon.setRows(5);
        jScrollPane1.setViewportView(txtIncon);

        jLabel3.setText("Porcentaje de Utilidad a la Empresa");

        jLabel4.setText("Porcentaje de Avance del proyecto");

        btnAdd.setText("Agregar");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Detalles de Proyecto");

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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        btnMod.setText("Modificar");
        btnMod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModMouseClicked(evt);
            }
        });

        txtIdDetail.setEditable(false);

        jLabel6.setText("Código del detalle");

        btnDel.setText("Eliminar");
        btnDel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDelMouseClicked(evt);
            }
        });

        btnLogico.setText("Eliminado Lógico");
        btnLogico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogicoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(119, 119, 119))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAvance, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd)
                    .addComponent(btnMod)
                    .addComponent(btnDel)
                    .addComponent(btnLogico))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
            .addGroup(layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPercent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtAvance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btnAdd)
                        .addGap(30, 30, 30)
                        .addComponent(btnMod)
                        .addGap(28, 28, 28)
                        .addComponent(btnDel)
                        .addGap(18, 18, 18)
                        .addComponent(btnLogico))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        insertar();
        tablaDetalleP(Integer.parseInt(this.txtId.getText()));
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnModMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModMouseClicked
        modificar();
        tablaDetalleP(Integer.parseInt(this.txtId.getText()));
    }//GEN-LAST:event_btnModMouseClicked

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseEntered

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        llenarCampos();
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnDelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDelMouseClicked
        eliminarDetalleP();
        
    }//GEN-LAST:event_btnDelMouseClicked

    private void btnLogicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogicoMouseClicked
        eliminarL();
    }//GEN-LAST:event_btnLogicoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnLogico;
    private javax.swing.JButton btnMod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAvance;
    public static javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdDetail;
    private javax.swing.JTextArea txtIncon;
    private javax.swing.JTextField txtPercent;
    // End of variables declaration//GEN-END:variables
}
