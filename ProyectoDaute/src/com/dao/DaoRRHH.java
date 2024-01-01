/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dao;

import com.conexion.Conexion;
import com.modelo.RRHH;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JC
 */
public class DaoRRHH extends Conexion{
    
     public String insertarRRHH(RRHH rh){
        try {
            this.conectar();
            String sql = "Insert into RRHH (nombreRRHH ,Descripcion, estado) values(?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);         
            pre.setString(1, rh.getNombreRRHH());
            pre.setString(2, rh.getDescripcion());
            pre.setInt(3, rh.getEstado());
       
            
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro Agregado Éxitosamente";
    }
    
    public String modificarRRHH(RRHH rh){
        try {
            this.conectar();
            String sql = "update RRHH set nombreRRHH=?,Descripcion=? where id_RRHH=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);  
            
            
            pre.setString(1, rh.getNombreRRHH());
            pre.setString(2, rh.getDescripcion());     
            pre.setInt(3, rh.getIdRRHH());
            
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro Modificado Éxitosamente";
    }
    
    public String eliminarRRHH(RRHH rh){
        try {
            this.conectar();
            String sql = "delete from RRHH where idRRHH=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, rh.getIdRRHH());
       
            
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro Eliminado Éxitosamente";
    }
    
    public ArrayList<RRHH> mostrarRRHH(){
    ArrayList<RRHH> listRRHH = new ArrayList();
        ResultSet res;
        try 
        {
            this.conectar();
            String sql = "select * from RRHH where estado!=0";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res = pre.executeQuery();
            while (res.next()) 
            {
                RRHH rh = new RRHH();
                rh.setIdRRHH(res.getInt("id_RRHH"));
                rh.setNombreRRHH(res.getString("nombreRRHH"));
                rh.setDescripcion(res.getString("Descripcion"));

                listRRHH.add(rh);
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
        return listRRHH;
    
    }
    
    public String eliminarRRHHLogico(RRHH rh){

        try {
            this.conectar();
            String sql = "Update RRHH set estado = ? where id_RRHH = ?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setInt(1, rh.getEstado());
            pre.setInt(2, rh.getIdRRHH());
            
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro eliminado Éxitosamente";

    }
    
}
