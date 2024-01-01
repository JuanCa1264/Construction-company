/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.conexion.Conexion;
import com.Modelo.Rol;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class DaoRoles extends Conexion {
     public ArrayList<Rol> mostrarRoles()
    {
         ArrayList<Rol> rol = new ArrayList();
        ResultSet res = null;
        try 
        {
            this.conectar();
            String sql = "select*from rol;";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res = pre.executeQuery();
            while (res.next()) 
            {
                Rol rol1= new Rol();
               
                rol1.setId_rol(res.getInt("id_Rol"));
                rol1.setNombrerol(res.getString("nombre_Rol"));

               rol.add(rol1);
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,
                    "Generacion incorrecta " + e.getMessage(),
                    "Generacion Fallida",
                    JOptionPane.ERROR_MESSAGE);
        } 
        finally 
        {
            this.desconectar();
        }
        return rol;
}
}
