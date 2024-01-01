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
public class DaoDetalleRRHH extends Conexion{
    
    public String insertarDetalle(DetalleRRHH drh){
        try {
            this.conectar();
            String sql = "Insert into detalleRRHH (id_Proyecto, id_AsignacionRRHH, estado) values(?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);         
            pre.setInt(1, drh.getId_Proyecto());
            pre.setInt(2, drh.getId_AsignacionRRHH());
            pre.setInt(3, drh.getEstado());
           
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro Agregado Éxitosamente";
    }
    
    public String modificarDetalleRH(DetalleRRHH rh){
        try {
            this.conectar();
            String sql = "update detalleRRHH set id_AsignacionRRHH=? where id_Detalle_RRHH=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);  
            
            
            pre.setInt(1, rh.getId_AsignacionRRHH());    
            pre.setInt(2, rh.getId_Detalle_RRHH());
            
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro Modificado Éxitosamente";
    }
    
    public ArrayList<DetalleRRHH> mostrarDatosRRHH(){
    ArrayList<DetalleRRHH> listDatosRRHH = new ArrayList();
        ResultSet res = null;
        try 
        {
            this.conectar();
            String sql = "select arh.*, rh.nombreRRHH,emp.nombreEmp from asignacionRRHH arh inner join empleado emp on arh.id_Empleado = emp.idEmp inner join RRHH rh on arh.id_RRHH = rh.id_RRHH";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res = pre.executeQuery();
            while (res.next()) 
            {
                DetalleRRHH drh = new DetalleRRHH();
                
                
                drh.setId_AsignacionRRHH(res.getInt("id_Asignacion"));
                drh.setNombreRRHH(res.getString("nombreRRHH"));
                drh.setNombreEmp(res.getString("nombreEmp"));
                

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
    
    public ArrayList<DetalleRRHH> mostrarDetalleRRHH(int idP){
    ArrayList<DetalleRRHH> listDatosRRHH = new ArrayList();
        ResultSet res = null;
        try 
        {
            this.conectar();
            String sql = "select drh.*,pr.nombreProyecto, arh.id_Empleado, arh.id_RRHH, emp.nombreEmp, rh.nombreRRHH from detalleRRHH drh inner join asignacionRRHH arh on drh.id_AsignacionRRHH = arh.id_Asignacion inner join RRHH rh on arh.id_RRHH = rh.id_RRHH inner join Empleado emp on arh.id_Empleado = emp.idEmp inner join proyecto pr on drh.id_Proyecto = pr.id_Proyecto where drh.id_Proyecto = ? and drh.estado!=0";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setInt(1, idP);
            res = pre.executeQuery();
            while (res.next()) 
            {
                DetalleRRHH drh = new DetalleRRHH();
                
                drh.setId_Detalle_RRHH(res.getInt("id_Detalle_RRHH"));
                drh.setId_AsignacionRRHH(res.getInt("id_AsignacionRRHH"));
                drh.setNombrePro(res.getString("nombreProyecto"));
                drh.setNombreRRHH(res.getString("nombreRRHH"));
                drh.setNombreEmp(res.getString("nombreEmp"));
                

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
    
    public String eliminarDetalleRH(DetalleRRHH rh){
        try {
            this.conectar();
            String sql = "delete from detalleRRHH where id_Detalle_RRHH=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, rh.getId_Detalle_RRHH());
       
            
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminado: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro Eliminado Éxitosamente";
    }
    
    public String eliminarDetalleRHLogico(DetalleRRHH drh){

        try {
            this.conectar();
            String sql = "Update detalleRRHH set estado = ? where id_Detalle_RRHH = ?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setInt(1, drh.getEstado());
            pre.setInt(2, drh.getId_Detalle_RRHH());
            
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
