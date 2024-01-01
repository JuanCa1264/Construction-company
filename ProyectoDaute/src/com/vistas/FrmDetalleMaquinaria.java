/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vistas;

import com.Dao.DaoDetalleMaquinaria;
import com.Dao.DaoMaquinaria;
import com.modelo.DetalleMaquinaria;
import com.modelo.DetalleRRHH;
import com.modelo.Maquinaria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JC
 */
public class FrmDetalleMaquinaria extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmDetalleMaquinaria
     * @param idP
     */
    public FrmDetalleMaquinaria(int idP) throws Exception {
        initComponents();
        tablaDetalleMaq(idP);
        cargarCombo(cmbMaquinaria, ma.mostrarMaquinaria());
    }
    
    DaoMaquinaria ma = new DaoMaquinaria();
    DetalleMaquinaria dm = new DetalleMaquinaria();
    DaoDetalleMaquinaria ddm = new DaoDetalleMaquinaria();

    public void tablaDetalleMaq(int idP){
        
        String [] cols = {"Código detalle","Nombre Proyecto", "Nombre Maquinaria","Cantidad"};
        Object[] obj = new Object[4];
        DefaultTableModel tabla = new DefaultTableModel(null, cols);
        List ls;
        //int idP = Integer.parseInt(this.txtId.getText());
        
        try {
             
            ls = ddm.mostrarDetalleMaq(idP);
            for (int i = 0; i <ls.size(); i++) {
                dm = (DetalleMaquinaria)ls.get(i);
                obj[0] = dm.getId_Detalle_Maquinaria();
                obj[1] = dm.getNombreProyecto();
                obj[2] = dm.getNombreMaquinaria();
                obj[3] = dm.getCantidad();
                
                
                tabla.addRow(obj);
            }
            
            
            this.jTable1.setModel(tabla);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al mostrar datos de la empleado "+e.toString());
        }
       
    }
    
    public void insertar(){
        
        try {
            
            ComboItem item = new ComboItem();
            String rh = cmbMaquinaria.getSelectedItem().toString();
       
        for (int i = 0; i < cmbMaquinaria.getItemCount(); i++) {
            if (rh.equals(cmbMaquinaria.getItemAt(i).toString())) {
                item = cmbMaquinaria.getModel().getElementAt(i);
                
            }
        }
        
            dm.setId_Maquinaria(item.getValue());
            int cant = Integer.parseInt(this.sCant.getValue().toString());
            dm.setId_Proyecto(Integer.parseInt(this.txtProyecto.getText()));
            dm.setCantidad(cant);
            
            dm.setEstado(1);
        
            ddm.insertarDetalle(dm);
            
            
            
            
        JOptionPane.showMessageDialog(null, "Datos insertados con éxito");
        
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void modificar(){
        
        try {
            
            ComboItem item = new ComboItem();
            String rh = cmbMaquinaria.getSelectedItem().toString();
       
        for (int i = 0; i < cmbMaquinaria.getItemCount(); i++) {
            if (rh.equals(cmbMaquinaria.getItemAt(i).toString())) {
                item = cmbMaquinaria.getModel().getElementAt(i);
                
            }
        }
        
            dm.setId_Maquinaria(item.getValue());
            int cant = Integer.parseInt(this.sCant.getValue().toString());
            dm.setCantidad(cant);
            dm.setCantidadP(Integer.parseInt(this.txtCantP.getText()));
            dm.setId_Detalle_Maquinaria(Integer.parseInt(this.txtDetail.getText()));
            
        
            ddm.modificarDetalle(dm);
            
            
            
            
        JOptionPane.showMessageDialog(null, "Datos insertados con éxito");
        
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private void cargarCombo(JComboBox combo,
            ArrayList<Maquinaria> list) throws Exception {

        for (Maquinaria item : list) {
            combo.addItem(new ComboItem(item.getId_Maquinaria(), 
                    item.getNombreMaquinaria()));
        }

    }
    
    public void llenarCampos(){
        
        int fila = this.jTable1.getSelectedRow();
        this.txtDetail.setText(String.valueOf(this.jTable1.getValueAt(fila, 0)));             
        String maq = String.valueOf(this.jTable1.getValueAt(fila, 2));
        this.cmbMaquinaria.getModel().setSelectedItem(maq);
        int cant = Integer.parseInt(String.valueOf(this.jTable1.getValueAt(fila, 3)));
        this.sCant.setValue(cant);
        this.txtCantP.setText(String.valueOf(this.jTable1.getValueAt(fila, 3)));
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
        cmbMaquinaria = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        sCant = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtProyecto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDetail = new javax.swing.JTextField();
        btnMod = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtCantP = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setText("Maquinaria");

        jLabel2.setText("Cantidad");

        sCant.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

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

        btnAgregar.setText("Agregar");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });

        jLabel3.setText("Código Proyecto");

        txtProyecto.setEditable(false);

        jLabel4.setText("Código detalle");

        txtDetail.setEditable(false);

        btnMod.setText("Modificar");
        btnMod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModMouseClicked(evt);
            }
        });

        jLabel5.setText("Previous Cant");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(btnAgregar)
                        .addGap(35, 35, 35)
                        .addComponent(btnMod))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbMaquinaria, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sCant, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantP, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbMaquinaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(sCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCantP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnMod))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        insertar();
        tablaDetalleMaq(Integer.parseInt(this.txtProyecto.getText()));
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       llenarCampos();
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnModMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModMouseClicked
        modificar();
        tablaDetalleMaq(Integer.parseInt(this.txtProyecto.getText()));
    }//GEN-LAST:event_btnModMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnMod;
    private javax.swing.JComboBox<ComboItem> cmbMaquinaria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner sCant;
    private javax.swing.JTextField txtCantP;
    private javax.swing.JTextField txtDetail;
    public static javax.swing.JTextField txtProyecto;
    // End of variables declaration//GEN-END:variables
}
