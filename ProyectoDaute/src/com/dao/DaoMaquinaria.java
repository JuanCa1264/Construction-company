/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dao;

import com.conexion.Conexion;
import com.modelo.Empleado;
import com.modelo.Maquinaria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JC
 */
public class DaoMaquinaria extends Conexion{
    public String insertarMaquinaria(Maquinaria ma){
        try {
            this.conectar();
            String sql = "Insert into maquinaria (nombreMaquinaria, modelo, fabricante, precio, anio, estado, available, cantidad) values(?,?,?,?,?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);         
            pre.setString(1, ma.getNombreMaquinaria());        
            pre.setString(2, ma.getModelo());        
            pre.setString(3, ma.getFabricante());        
            pre.setDouble(4, ma.getPrecio());
            pre.setInt(5, ma.getAnio());
            pre.setInt(6, ma.getEstado());
            pre.setInt(7, ma.getAvailable());
            pre.setInt(8, ma.getCantidad());
            
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro Agregado Éxitosamente";
    }
    
    public String modificarMaquinaria(Maquinaria ma){
        try {
            this.conectar();
            String sql = "update maquinaria set nombreMaquinaria=?,modelo=?, fabricante=?, precio=?, anio=?, available=?, cantidad=? where id_Maquinaria=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);         
            pre.setString(1, ma.getNombreMaquinaria());        
            pre.setString(2, ma.getModelo());        
            pre.setString(3, ma.getFabricante());        
            pre.setDouble(4, ma.getPrecio());
            pre.setInt(5, ma.getAnio());
            pre.setInt(6, ma.getAvailable());
            pre.setInt(7, ma.getCantidad());
            pre.setInt(8, ma.getId_Maquinaria());
       
            
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro Modificado Éxitosamente";
    }
    
    public String eliminarMaquinaria(Maquinaria ma){
        try {
            this.conectar();
            String sql = "delete from maquinaria where id_Maquinaria=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, ma.getId_Maquinaria());
       
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminado: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro Eliminado Éxitosamente";
    }
    
    public ArrayList<Maquinaria> mostrarMaquinaria(){
    ArrayList<Maquinaria> Maquinaria = new ArrayList();
        ResultSet res = null;
        try 
        {
            this.conectar();
            String sql = "select*from maquinaria where estado!= 0";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res = pre.executeQuery();
            while (res.next()) 
            {
                Maquinaria ma=new Maquinaria();
                ma.setId_Maquinaria(res.getInt("id_Maquinaria"));
                ma.setNombreMaquinaria(res.getString("nombreMaquinaria"));
                ma.setModelo(res.getString("modelo"));
                ma.setFabricante(res.getString("fabricante"));
                ma.setPrecio(res.getDouble("precio"));
                ma.setAnio(res.getInt("anio"));
                ma.setEstado(res.getInt("estado"));
                ma.setAvailable(res.getInt("available"));
                ma.setCantidad(res.getInt("cantidad"));
                
                Maquinaria.add(ma);
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
        return Maquinaria;
    
    }
    
    public String eliminarMaquinariaLogico(Maquinaria ma){

        try {
            this.conectar();
            String sql = "Update maquinaria set estado = ? where id_Maquinaria = ?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setInt(1, ma.getEstado());
            pre.setInt(2, ma.getId_Maquinaria());
            
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
