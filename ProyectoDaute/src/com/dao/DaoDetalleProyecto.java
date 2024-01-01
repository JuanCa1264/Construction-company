/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dao;

import com.conexion.Conexion;
import com.modelo.DetalleProyecto;
import com.modelo.DetalleRRHH;
import com.modelo.MateriaPrima;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JC
 */
public class DaoDetalleProyecto extends Conexion{
    
    DetalleProyecto dp = new DetalleProyecto();
    
    public String insertarDetalleP(DetalleProyecto dp){
        try {
            this.conectar();
            String sql = "Insert into detalleProyecto (id_Proyecto ,atrasos,porcentajeUtilidad, porcentajeAvance, estado) values(?,?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);         
            pre.setInt(1, dp.getId_Proyecto());
            pre.setString(2, dp.getAtrasos());
            pre.setString(3, dp.getPorcentajeU());
            pre.setString(4, dp.getPorcentajeAvance());
            pre.setInt(5, dp.getEstado());
       
            
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro Agregado Éxitosamente";
    }
    
    public ArrayList<DetalleProyecto> mostrarDetalleP(int idP){
    ArrayList<DetalleProyecto> listDetalleP = new ArrayList();
        ResultSet res = null;
        try 
        {
            this.conectar();
            String sql = "select  p.nombreProyecto ,dp.* from detalleProyecto dp inner join proyecto p on dp.id_Proyecto = p.id_Proyecto where dp.id_Proyecto=? and dp.estado!=0";
            PreparedStatement pre = this.getCon().prepareCall(sql);
             pre.setInt(1, idP);
            res = pre.executeQuery();
            while (res.next()) 
            {
                DetalleProyecto dp = new DetalleProyecto();
                dp.setDetalle_Proyecto(res.getInt("id_Detalle_Proyecto"));
                dp.setId_Proyecto(res.getInt("id_Proyecto"));
                dp.setNombreProyecto(res.getString("nombreProyecto"));
                dp.setAtrasos(res.getString("atrasos"));
                dp.setPorcentajeU(res.getString("porcentajeUtilidad"));
                dp.setPorcentajeAvance(res.getString("porcentajeAvance"));
                dp.setEstado(res.getInt("estado"));

                listDetalleP.add(dp);
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
        return listDetalleP;
    
    }
    
    public String modificarDetalleP(DetalleProyecto dp){
        try {
            this.conectar();
            String sql = "update detalleProyecto set atrasos=?, porcentajeUtilidad=?, porcentajeAvance=? where id_Detalle_Proyecto=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);  
            
            pre.setString(1, dp.getAtrasos());
            pre.setString(2, dp.getPorcentajeU());
            pre.setString(3, dp.getPorcentajeAvance());
            pre.setInt(4, dp.getDetalle_Proyecto());
            
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro Modificado Éxitosamente";
    }
    
    public String eliminarDetalleP(DetalleProyecto dp){
        try {
            this.conectar();
            String sql = "delete from detalleProyecto where id_Detalle_Proyecto=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, dp.getDetalle_Proyecto());
       
            
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminado: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro Eliminado Éxitosamente";
    }
    
    public String eliminarDetallePLogico(DetalleProyecto dp){

        try {
            this.conectar();
            String sql = "Update detalleProyecto set estado = ? where id_Detalle_Proyecto = ?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setInt(1, dp.getEstado());
            pre.setInt(2, dp.getDetalle_Proyecto());
            
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
