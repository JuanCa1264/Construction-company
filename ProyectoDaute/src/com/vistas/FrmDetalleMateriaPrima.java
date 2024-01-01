/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vistas;

import com.Dao.DaoMateriaPrima;
import com.Dao.DaoProyecto;
import com.Modelo.DetalleMateriaPrima;
import com.Modelo.Rol;
import com.Modelo.Usuario;
import com.dao.DaoDetalleMateriaPrima;
import com.modelo.MateriaPrima;
import com.modelo.Proyecto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class FrmDetalleMateriaPrima extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmDetalleMateriaPrima
     */
    DaoDetalleMateriaPrima ddmp= new  DaoDetalleMateriaPrima();
    DetalleMateriaPrima dmp= new DetalleMateriaPrima();
    DaoMateriaPrima mp=new DaoMateriaPrima();
    DaoProyecto dp= new DaoProyecto();
   
    public FrmDetalleMateriaPrima() throws Exception{
        initComponents();
        cargarcomboMateria(cmbMateria,mp.mostrarMateria());
        cargarcomboProyecto(cmbProyecto,dp.mostrarProyecto());
         tablaDetalleMP();
    }
    private void cargarcomboProyecto(JComboBox combo,
            ArrayList<Proyecto> list)throws Exception{
    for (Proyecto item : list) {
            combo.addItem(new ComboItem(item.getId_Proyecto(), 
                    item.getNombreProyecto()));
    
    }
    }
     private void cargarcomboMateria(JComboBox combo,
            ArrayList<MateriaPrima> list)throws Exception{
    for (MateriaPrima item : list) {
            combo.addItem(new ComboItem(item.getId_MateriaP(), 
                    item.getNombreMateria()));
    
    }
     }
     
     public void ingresar(){
         dmp.setCantidad(Integer.parseInt(this.txtCantidad.getText()));
     ComboItem item = new ComboItem();
     ComboItem item2=new ComboItem();
      String fac = cmbMateria.getSelectedItem().toString();
     
       
        for (int i = 0; i < cmbMateria.getItemCount(); i++) {
            if (fac.equals(cmbMateria.getItemAt(i).toString())) {
                item = (ComboItem) cmbMateria.getModel().getElementAt(i);
                
            }
        }
        String proy= cmbProyecto.getSelectedItem().toString();
         for (int i = 0; i < cmbProyecto.getItemCount(); i++) {
            if (proy.equals(cmbProyecto.getItemAt(i).toString())) {
                item2 = (ComboItem) cmbProyecto.getModel().getElementAt(i);
                
            }
        }
     dmp.setId_proyecto(item2.getValue());
     dmp.setId_materiap(item.getValue());
     ddmp.insertarMateria(dmp);
     }
public void tablaDetalleMP(){
        String [] cols = {"Id","IdMateriaP","Id Proyecto ", "Cantidad"};
        Object[] obj = new Object[4];
        DefaultTableModel tabla = new DefaultTableModel(null, cols);
        List ls;
        
        try {
            ls = ddmp.mostrarDMP();
            for (int i = 0; i <ls.size(); i++) {
                dmp = (DetalleMateriaPrima)ls.get(i);
                obj[0] = dmp.getId_detalle_materiap();
                obj[1]=ddmp.getMateriP(dmp.getId_materiap()).getNombreMateria();
                obj[2]=ddmp.getProy(dmp.getId_proyecto()).getNombreProyecto();
                obj[3]=dmp.getCantidad();
                
                
                tabla.addRow(obj);
            }
            
            
            this.jTable1.setModel(tabla);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al mostrar datos de la carrera "+e.toString());
        }
         
    }
public void eliminarDetalle(){
       
             try {
            dmp.setId_detalle_materiap(Integer.parseInt(this.txtId.getText()));
            int SioNo = JOptionPane.showConfirmDialog(this, "Desea eliminar el Registro","Eliminar Registro", JOptionPane.YES_NO_OPTION);
            
            if (SioNo==0) {
                ddmp.eliminarDetalle(dmp);
                JOptionPane.showMessageDialog(rootPane, "Eliminado con éxito","Confirmación", JOptionPane.INFORMATION_MESSAGE);
               tablaDetalleMP();
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
 
    }

public void llenarCampos(){
        
        int fila = this.jTable1.getSelectedRow();
        this.txtId.setText(String.valueOf(this.jTable1.getValueAt(fila, 0)));
        String materia=String.valueOf(this.jTable1.getValueAt(fila, 1));
        this.cmbMateria.getModel().setSelectedItem(materia);
       String proy = String.valueOf(this.jTable1.getValueAt(fila, 2));
        this.cmbProyecto.getModel().setSelectedItem(proy);
        this.txtCantidad.setText(String.valueOf(this.jTable1.getValueAt(fila,3)));
         
    }
public void Modificar(){
 dmp.setCantidad(Integer.parseInt(this.txtCantidad.getText()));
     ComboItem item = new ComboItem();
     ComboItem item2=new ComboItem();
      String fac = cmbMateria.getSelectedItem().toString();
     
       
        for (int i = 0; i < cmbMateria.getItemCount(); i++) {
            if (fac.equals(cmbMateria.getItemAt(i).toString())) {
                item = (ComboItem) cmbMateria.getModel().getElementAt(i);
                
            }
        }
        String proy= cmbProyecto.getSelectedItem().toString();
         for (int i = 0; i < cmbProyecto.getItemCount(); i++) {
            if (proy.equals(cmbProyecto.getItemAt(i).toString())) {
                item2 = (ComboItem) cmbProyecto.getModel().getElementAt(i);
                
            }
        }
     dmp.setId_proyecto(item2.getValue());
     dmp.setId_materiap(item.getValue());
     dmp.setId_detalle_materiap(Integer.parseInt(this.txtId.getText()));
            int SioNo = JOptionPane.showConfirmDialog(this, "Desea modificar El Registro", "Modificar Registro", JOptionPane.YES_NO_OPTION);
            
            if (SioNo==0) {
                ddmp.modificarDetalle(dmp);
                JOptionPane.showMessageDialog(rootPane,"Registro modificado con éxito", "Confirmación",
                        JOptionPane.INFORMATION_MESSAGE);
            }


}
public void limpiar(){
this.txtCantidad.setText("");
this.cmbMateria.setSelectedIndex(0);
this.cmbProyecto.setSelectedIndex(0);
this.txtId.setText("");
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEliminar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbMateria = new javax.swing.JComboBox();
        cmbProyecto = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel11.setText("Cantidad");

        jLabel12.setText("Id Detallae M. Prima");

        jLabel3.setText(" Proyecto");

        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel2.setText(" Materia Prima");

        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
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
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/pala-triangular-con-hormigon-liquido.png"))); // NOI18N
        jLabel1.setText("Detalle Materia Prima");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel12)
                                .addGap(41, 41, 41)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cmbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(91, 91, 91)
                                        .addComponent(cmbProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(299, 299, 299)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 61, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(btnAgregar)
                .addGap(55, 55, 55)
                .addComponent(btnModificar)
                .addGap(38, 38, 38)
                .addComponent(btnEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cmbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cmbProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       ingresar();
       limpiar();
       tablaDetalleMP();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        llenarCampos();
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarDetalle();
        limpiar();
        tablaDetalleMP();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
       Modificar();
       limpiar();
       tablaDetalleMP();
    }//GEN-LAST:event_btnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox cmbMateria;
    private javax.swing.JComboBox cmbProyecto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables

   }
