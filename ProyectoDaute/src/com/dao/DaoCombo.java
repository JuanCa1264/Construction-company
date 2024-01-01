/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class DaoCombo extends Conexion{
    
    
     public DefaultComboBoxModel obt_pais(){
         DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
         listaModelo.addElement("Seleccione el RRHH correspondiente");
         ResultSet rs;
         try 
         {
             this.conectar();
            String sql="select nombreRRHH from rrhh";
            PreparedStatement pst=this.getCon().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {
                listaModelo.addElement(rs.getString("nombreRRHH"));
            }
         } 
         catch (SQLException e) 
         {
             JOptionPane.showMessageDialog(null, "ERROR: "+e);
         }
         finally{
             this.desconectar();
         }
         return listaModelo;
     }
     
     public DefaultComboBoxModel llenar_ComboMateriaP(){
         DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
         listaModelo.addElement("Seleccione el proyecto correspondiente");
         ResultSet rs;
         try 
         {
             this.conectar();
            String sql="select nombreProyecto from proyecto";
            PreparedStatement pst=this.getCon().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {
                listaModelo.addElement(rs.getString("nombreProyecto"));
            }
         } 
         catch (SQLException e) 
         {
             JOptionPane.showMessageDialog(null, "ERROR: "+e);
         }
         finally{
             this.desconectar();
         }
         return listaModelo;
     }
     
     public DefaultComboBoxModel llenar_ComboMaquinaria(){
         DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
         listaModelo.addElement("Seleccione el proyecto correspondiente");
         ResultSet rs;
         try 
         {
             this.conectar();
            String sql="select nombreProyecto from proyecto";
            PreparedStatement pst=this.getCon().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {
                listaModelo.addElement(rs.getString("nombreProyecto"));
            }
         } 
         catch (SQLException e) 
         {
             JOptionPane.showMessageDialog(null, "ERROR: "+e);
         }
         finally{
             this.desconectar();
         }
         return listaModelo;
     }
}
