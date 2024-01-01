/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.conexion.Conexion;
import com.modelo.Hash;
import com.Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class DaoLogin extends Conexion{
    public String[] logiar(Usuario usu){
        String[] result=new String[2];
        try {
            String sql="SELECT COUNT(*),r.nombre_Rol from user as u INNER JOIN rol as r WHERE u.id_Rol=r.id_Rol && password=? && userName=?";
            super.conectar();
            PreparedStatement pre = super.getCon().prepareStatement(sql);
            pre.setString(1, Hash.sha1(usu.getPassword()));
            pre.setString(2, usu.getUsername());
            ResultSet res = pre.executeQuery();
            while(res.next()){
              result[0]=res.getString(1);
              result[1]=res.getString(2);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR: "+e.getMessage());
        }
        return result;
    }
}
