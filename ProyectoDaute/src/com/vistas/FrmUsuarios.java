/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vistas;

import com.Dao.DaoUsuario;
import com.Modelo.Rol;
import com.Modelo.Usuario;
import com.dao.DaoRoles;
import com.modelo.Hash;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class FrmUsuarios extends javax.swing.JInternalFrame {
Usuario usr= new Usuario();
    DaoUsuario dusr= new DaoUsuario();
    DaoRoles rl= new DaoRoles();
    public FrmUsuarios() throws Exception {
        initComponents();
        cargarCombo(cmbRol,rl.mostrarRoles());
        tablaUsuario();
    }
     public void insertar(){
        
    try {
            
         
       usr.setFullname(this.txtNombreFull.getText());
       usr.setUsername(this.txtUsername.getText());
       String pass= new String(txtPassword.getPassword());
      
       String encrip= Hash.sha1(pass);
       usr.setPassword(encrip);
       ComboItem item = new ComboItem();
       String fac = cmbRol.getSelectedItem().toString();
       
        for (int i = 0; i < cmbRol.getItemCount(); i++) {
            if (fac.equals(cmbRol.getItemAt(i).toString())) {
                item = (ComboItem) cmbRol.getModel().getElementAt(i);
                
            }
        }
       usr.setEstado(1);
       usr.setId_rol(item.getValue());
       
       dusr.insertarUsuario(usr);
        
        JOptionPane.showMessageDialog(null, "Datos insertados con éxito");
        
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
     private void cargarCombo(JComboBox combo,
            ArrayList<Rol> list) throws Exception {

        for (Rol item : list) {
            combo.addItem(new ComboItem(item.getId_rol(), 
                    item.getNombrerol()));
        }
        

    }   
      public void tablaUsuario(){
        String [] cols = {"Código Usuario","Nombre Completo","Nombre De Usuario ", "Contraseña", "Id Rol"};
        Object[] obj = new Object[5];
        DefaultTableModel tabla = new DefaultTableModel(null, cols);
        List ls;
        
        try {
            ls = dusr.mostrarUsuario();
            for (int i = 0; i <ls.size(); i++) {
                usr = (Usuario)ls.get(i);
                obj[0] = usr.getId_user();
                obj[1] = usr.getFullname();
                obj[2]=usr.getUsername();
                obj[3] = usr.getPassword();
                obj[4] = dusr.getRol(usr.getId_rol()).getNombrerol();
                
                
                tabla.addRow(obj);
            }
            
            
            this.jTable1.setModel(tabla);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al mostrar datos de la carrera "+e.toString());
        }
         
    }
      public void eliminarUsuario(){
       
             try {
            usr.setId_user(Integer.parseInt(this.txtIdUser.getText()));
            int SioNo = JOptionPane.showConfirmDialog(this, "Desea eliminar al Usuario","Eliminar Usuario", JOptionPane.YES_NO_OPTION);
            
            if (SioNo==0) {
                dusr.eliminarUsuario(usr);
                JOptionPane.showMessageDialog(rootPane, "Eliminado con éxito","Confirmación", JOptionPane.INFORMATION_MESSAGE);
                tablaUsuario();
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
 
    }
      public void modificarUsuario(){
        try {
            usr.setFullname(this.txtNombreFull.getText());
       usr.setUsername(this.txtUsername.getText());
       String pass= new String(txtPassword.getPassword());
      
       String encrip= Hash.sha1(pass);
       usr.setPassword(encrip);
       ComboItem item = new ComboItem();
       String fac = cmbRol.getSelectedItem().toString();
       
        for (int i = 0; i < cmbRol.getItemCount(); i++) {
            if (fac.equals(cmbRol.getItemAt(i).toString())) {
                item = (ComboItem) cmbRol.getModel().getElementAt(i);
                
            }
        }
       usr.setEstado(1);
       usr.setId_rol(item.getValue());
            
            usr.setId_user(Integer.parseInt(this.txtIdUser.getText()));
            int SioNo = JOptionPane.showConfirmDialog(this, "Desea modificar El Usuario", "Modificar Usuario", JOptionPane.YES_NO_OPTION);
            
            if (SioNo==0) {
                dusr.modificarUsuario(usr);
                JOptionPane.showMessageDialog(rootPane,"Usuario modificado con éxito", "Confirmación",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
      }
      public void llenarCampos(){
        
        int fila = this.jTable1.getSelectedRow();
        this.txtIdUser.setText(String.valueOf(this.jTable1.getValueAt(fila, 0)));
        this.txtNombreFull.setText(String.valueOf(this.jTable1.getValueAt(fila, 1)));
        this.txtUsername.setText(String.valueOf(this.jTable1.getValueAt(fila, 2)));
        this.txtPassword.setText(String.valueOf(this.jTable1.getValueAt(fila, 3)));
        String rol = String.valueOf(this.jTable1.getValueAt(fila, 4));
        this.cmbRol.getModel().setSelectedItem(rol);
         
    }
      public void limpiar(){
     this.txtIdUser.setText("");
     this.txtNombreFull.setText("");
     this.txtPassword.setText("");
     this.txtUsername.setText("");
     this.cmbRol.setSelectedIndex(0);
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
        txtNombreFull = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        cmbRol = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtIdUser = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/participacion.png"))); // NOI18N
        jLabel1.setText("GESTION DE USUARIOS");

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

        jLabel2.setText("Nombre Completo");

        jLabel3.setText("Nombre De Usuario");

        jLabel4.setText("Contraseña");

        jLabel5.setText("Rol Del Usuario");

        jLabel6.setText("Id Usuario");

        txtIdUser.setEnabled(false);

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

        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreFull, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUsername)
                                    .addComponent(cmbRol, 0, 200, Short.MAX_VALUE)))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 275, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAgregar)
                .addGap(55, 55, 55)
                .addComponent(btnModificar)
                .addGap(56, 56, 56)
                .addComponent(btnEliminar)
                .addGap(156, 156, 156))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreFull, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       insertar();
       tablaUsuario();
       limpiar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
       modificarUsuario();
      limpiar();
      tablaUsuario();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
      llenarCampos();
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
      eliminarUsuario();
      limpiar();
      tablaUsuario();
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox cmbRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtIdUser;
    private javax.swing.JTextField txtNombreFull;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
