/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vistas;

import com.Dao.DaoDetalleRRHH;
import com.modelo.DetalleProyecto;
import com.modelo.DetalleRRHH;
import com.modelo.MateriaPrima;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JC
 */
public class FrmDetalleRRHH extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmDetalleRRHH
     * @param idP
     */
    public FrmDetalleRRHH(int idP) throws Exception {
        initComponents();
        FrmProyecto fp = new FrmProyecto();
        

       
         cargarCombo(cmbAsig, ddrh.mostrarDatosRRHH());
         //cargarCombo1(cmbNombreRRHH, ddrh.mostrarDatosRRHH());
         
         tablaDetalleRRHH(idP);
    }
    
    DetalleRRHH drh = new DetalleRRHH();
    DaoDetalleRRHH ddrh = new DaoDetalleRRHH();
    
    private void cargarCombo(JComboBox combo,
            ArrayList<DetalleRRHH> list) throws Exception {

        for (DetalleRRHH item : list) {
            combo.addItem(new ComboItem(item.getId_AsignacionRRHH(), 
                    item.getNombreEmp()));
        }

    }
    
    private void cargarCombo1(JComboBox combo,
            ArrayList<DetalleRRHH> list) throws Exception {

        for (DetalleRRHH item : list) {
            combo.addItem(new ComboItem(item.getId_AsignacionRRHH(), 
                    item.getNombreRRHH()));
        }

    }
    
    public void insertar(){
        
        try {
            drh.setId_Proyecto(Integer.parseInt(this.txtId.getText()));
            ComboItem item = new ComboItem();
            String rh = cmbAsig.getSelectedItem().toString();
       
        for (int i = 0; i < cmbAsig.getItemCount(); i++) {
            if (rh.equals(cmbAsig.getItemAt(i).toString())) {
                item = cmbAsig.getModel().getElementAt(i);
                
            }
        }
        
            drh.setId_AsignacionRRHH(item.getValue());
        
            drh.setEstado(1);
        
            ddrh.insertarDetalle(drh);
        
        JOptionPane.showMessageDialog(null, "Datos insertados con éxito");
        
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void modificar(){
        
        try {
            
            ComboItem item = new ComboItem();
            String rh = cmbAsig.getSelectedItem().toString();
       
        for (int i = 0; i < cmbAsig.getItemCount(); i++) {
            if (rh.equals(cmbAsig.getItemAt(i).toString())) {
                item = cmbAsig.getModel().getElementAt(i);
                
            }
        }
        
            drh.setId_AsignacionRRHH(item.getValue());
        
            drh.setId_Detalle_RRHH(Integer.parseInt(this.txtIdDetail.getText()));
        
            ddrh.modificarDetalleRH(drh);
        
        JOptionPane.showMessageDialog(null, "Datos insertados con éxito");
        
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void tablaDetalleRRHH(int idP){
        
        String [] cols = {"Código detalle","Código Asignación", "Nombre Proyecto","Nombre Empleado", "Nombre RRHH"};
        Object[] obj = new Object[5];
        DefaultTableModel tabla = new DefaultTableModel(null, cols);
        List ls;
        //int idP = Integer.parseInt(this.txtId.getText());
        
        try {
             
            ls = ddrh.mostrarDetalleRRHH(idP);
            for (int i = 0; i <ls.size(); i++) {
                drh = (DetalleRRHH)ls.get(i);
                obj[0] = drh.getId_Detalle_RRHH();
                obj[1] = drh.getId_AsignacionRRHH();
                obj[2] = drh.getNombrePro();
                obj[3] = drh.getNombreEmp();
                obj[4] = drh.getNombreRRHH();
                
                
                tabla.addRow(obj);
            }
            
            
            this.jTable1.setModel(tabla);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al mostrar datos de la empleado "+e.toString());
        }
       
    }
    
    public void eliminarDetalleRH(){
        try {
            
        drh.setId_Detalle_RRHH(Integer.parseInt(this.txtIdDetail.getText()));
            int SioNo = JOptionPane.showConfirmDialog(this, "Desea eliminar el detalle","Eliminar Carrera", JOptionPane.YES_NO_OPTION);
            
            if (SioNo==0) {
                ddrh.eliminarDetalleRH(drh);
                JOptionPane.showMessageDialog(rootPane, "Eliminado con éxito","Confirmación", JOptionPane.INFORMATION_MESSAGE);
                tablaDetalleRRHH(Integer.parseInt(this.txtId.getText()));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void eliminarL(){
        try {
            drh.setId_Detalle_RRHH(Integer.parseInt(this.txtIdDetail.getText()));
            int SioNo = JOptionPane.showConfirmDialog(this, "Desea eliminar el detalle","Eliminar facultad", JOptionPane.YES_NO_OPTION);
            
            if (SioNo==0) {
                ddrh.eliminarDetalleRHLogico(drh);
                JOptionPane.showMessageDialog(rootPane, "Eliminado con éxito","Confirmación", JOptionPane.INFORMATION_MESSAGE);
                tablaDetalleRRHH(Integer.parseInt(this.txtId.getText()));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void llenarCampos(){
        
        int fila = this.jTable1.getSelectedRow();
        this.txtIdDetail.setText(String.valueOf(this.jTable1.getValueAt(fila, 0)));             
        String rrhh = String.valueOf(this.jTable1.getValueAt(fila, 3));
        this.cmbAsig.getModel().setSelectedItem(rrhh);
         
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbAsig = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtIdDetail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnMod = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnLogico = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setText("Código del Proyecto");

        txtId.setEditable(false);

        jLabel2.setText("Asignar RRHH");

        btnAdd.setText("Asignar");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
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
        jScrollPane2.setViewportView(jTable1);

        txtIdDetail.setEditable(false);

        jLabel3.setText("Código del Detalle");

        btnMod.setText("Modificar");
        btnMod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModMouseClicked(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIdDetail)
                    .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                .addGap(58, 58, 58)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbAsig, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(btnAdd)
                        .addGap(35, 35, 35)
                        .addComponent(btnMod)
                        .addGap(18, 18, 18)
                        .addComponent(btnDel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLogico)))
                .addGap(0, 99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cmbAsig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnMod)
                    .addComponent(btnDel)
                    .addComponent(btnLogico))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        insertar();
        tablaDetalleRRHH(Integer.parseInt(this.txtId.getText()));
    }//GEN-LAST:event_btnAddMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        llenarCampos();
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnModMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModMouseClicked
        modificar();
        tablaDetalleRRHH(Integer.parseInt(this.txtId.getText()));
    }//GEN-LAST:event_btnModMouseClicked

    private void btnDelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDelMouseClicked
        eliminarDetalleRH();
    }//GEN-LAST:event_btnDelMouseClicked

    private void btnLogicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogicoMouseClicked
        eliminarL ();
    }//GEN-LAST:event_btnLogicoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnLogico;
    private javax.swing.JButton btnMod;
    private javax.swing.JComboBox<ComboItem> cmbAsig;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    public static javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdDetail;
    // End of variables declaration//GEN-END:variables
}
