/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dao;

import com.conexion.Conexion;
import com.modelo.DetalleMaquinaria;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author JC
 */
public class DaoDetalleMaquinaria extends Conexion{
    
    public String insertarDetalle(DetalleMaquinaria dm){
        try {
            this.conectar();
            CallableStatement call = this.getCon().prepareCall("{call sp_Maquinaria(?,?,?,?)}");         
            call.setInt(1, dm.getId_Maquinaria());
            call.setInt(2, dm.getId_Proyecto());
            call.setInt(3, dm.getCantidad());
            call.setInt(4, dm.getEstado());
           
            call.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro Agregado Éxitosamente";
    }
    
    public String modificarDetalle(DetalleMaquinaria dm){
        try {
            this.conectar();
            CallableStatement call = this.getCon().prepareCall("{call sp_MaquinariaModificar(?,?,?,?)}");         
            call.setInt(1, dm.getId_Maquinaria());
            call.setInt(2, dm.getId_Detalle_Maquinaria());
            call.setInt(3, dm.getCantidad());
            call.setInt(4, dm.getCantidadP());
            
           
            call.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro Agregado Éxitosamente";
    }
    
    public ArrayList<DetalleMaquinaria> mostrarDetalleMaq(int idP){
    ArrayList<DetalleMaquinaria> listDatosRRHH = new ArrayList();
        ResultSet res = null;
        try 
        {
            this.conectar();
            String sql = "select dm.*, p.nombreProyecto,m.nombreMaquinaria, dm.cantidad from detalleMaquinaria dm inner join maquinaria m on dm.id_Maquinaria = m.id_Maquinaria inner join proyecto p on dm.id_Proyecto = p.id_Proyecto where dm.estado!=0 and p.id_Proyecto = ?";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setInt(1, idP);
            res = pre.executeQuery();
            while (res.next()) 
            {
                DetalleMaquinaria drh = new DetalleMaquinaria();
                
                drh.setId_Detalle_Maquinaria(res.getInt("id_Detalle_Maquinaria"));
                drh.setId_Maquinaria(res.getInt("id_Maquinaria"));
                drh.setNombreProyecto(res.getString("nombreProyecto"));
                drh.setNombreMaquinaria(res.getString("nombreMaquinaria"));
                drh.setCantidad(res.getInt("cantidad"));
                

                listDatosRRHH.add(drh);
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
        return listDatosRRHH;
    
    }
    
}
