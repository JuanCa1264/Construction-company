/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dao;

import com.Modelo.Rol;
import com.Modelo.Usuario;
import com.conexion.Conexion;
import com.modelo.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JC
 */
public class DaoUsuario extends Conexion {
    public String insertarUsuario(Usuario usr){

        try {
            this.conectar();
            String sql = "Insert into user (fullName,userName,password,id_Rol,estado) values(?,?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);         
            pre.setString(1, usr.getFullname());
            pre.setString(2, usr.getUsername());
            pre.setString(3, usr.getPassword());
            pre.setInt(4, usr.getId_rol());
            pre.setInt(5, usr.getEstado());
            
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro Agregado Éxitosamente";

    }
     public ArrayList<Usuario> mostrarUsuario()
    {
         ArrayList<Usuario> Usuario = new ArrayList();
        ResultSet res = null;
        try 
        {
            this.conectar();
            String sql = "select id_user, fullName, userName, password, id_Rol from user";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res = pre.executeQuery();
            while (res.next()) 
            {
                Usuario usr=new Usuario();
                usr.setId_user(res.getInt("id_user"));
                usr.setFullname(res.getString("fullName"));
                usr.setUsername(res.getString("userName"));
                usr.setPassword(res.getString("password"));
                usr.setId_rol(res.getInt("id_Rol"));

                Usuario.add(usr);
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
        return Usuario;
        
        
    }
      public String eliminarUsuario(Usuario usr){

        try {
            this.conectar();
            String sql = "Delete from user where id_user= ?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setInt(1, usr.getId_user());
            
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro eliminado Éxitosamente";
     
     
}
      
      public void modificarUsuario(Usuario usr)
    {

        try {

            this.conectar();

            String sql = "update user set fullName = ? , userName = ?, password= ?,id_Rol=? where id_user = ? ";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1,usr.getFullname());
            pre.setString(2,usr.getUsername());
            pre.setString(3, usr.getPassword());
            pre.setInt(4,usr.getId_rol());
            pre.setInt(5, usr.getId_user());

            pre.executeUpdate();

        } 
        catch (Exception e) 
        {
          JOptionPane.showMessageDialog(null,"Error al modificar datos"+e.getMessage());
        } finally 
        {

            this.desconectar();
        }
    }
       public Rol getRol(int rol)
     {
        Rol rl = new Rol();

        ResultSet res = null;
           try 
           {
               this.conectar();
               String sql = 
                       "select * from rol where id_Rol = ?";
               PreparedStatement pre = this.getCon().prepareCall(sql);
                 pre.setInt(1, rol);   
               res = pre.executeQuery();

               while (res.next()) 
               {              
                  rl.setNombrerol(res.getString("nombre_Rol"));
                  rl.setId_rol(res.getInt("id_Rol"));
                  
               }
           } catch (Exception e) 
           {
               JOptionPane.showMessageDialog(null,"Error al mostrar datos"+e.getMessage());
           } 
           finally 
           {
               this.desconectar();
           }
           return rl;
    }
}

    
    
   

