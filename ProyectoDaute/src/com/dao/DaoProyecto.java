
package com.Dao;

import com.conexion.Conexion;
import com.modelo.Proyecto;
import com.modelo.Proyecto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JC
 */
public class DaoProyecto extends Conexion{
    
    
    
    public String insertarProyecto(Proyecto pr){
        try {
            this.conectar();
            String sql = "Insert into proyecto (nombreProyecto ,ubicacionProyecto , fechaInicio, fechaFin, tipoProyecto, inversionInicial, estadoProyecto, estado) values(?,?,?,?,?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);         
            pre.setString(1, pr.getNombreProyecto());
            pre.setString(2, pr.getUbicacionProyecto());
            pre.setString(3, pr.getFechaInicio());
            pre.setString(4, pr.getFechaFin());
            pre.setString(5, pr.getTipoProyecto());
            pre.setDouble(6, pr.getInversionInicial());
            pre.setString(7, pr.getEstadoProyecto());
            pre.setInt(8, pr.getEstado());
            
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro Agregado Éxitosamente";
    }
    
    public String modificarProyecto(Proyecto pr){
        try {
            this.conectar();
            String sql = "update proyecto set nombreProyecto=?,ubicacionProyecto=?, fechaInicio=?, fechaFin=?, tipoProyecto=?, inversionInicial=?, estadoProyecto=? where id_Proyecto=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);  
            
            pre.setString(1, pr.getNombreProyecto());
            pre.setString(2, pr.getUbicacionProyecto());
            pre.setString(3, pr.getFechaInicio());
            pre.setString(4, pr.getFechaFin());
            pre.setString(5, pr.getTipoProyecto());
            pre.setDouble(6, pr.getInversionInicial());
            pre.setString(7, pr.getEstadoProyecto());
            pre.setInt(8, pr.getId_Proyecto());
            
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro Modificado Éxitosamente";
    }
    
    public String eliminarProyecto(Proyecto pr){
        try {
            this.conectar();
            String sql = "delete from proyecto where id_Proyecto=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, pr.getId_Proyecto());
       
            
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro Eliminado Éxitosamente";
    }
    
    public String eliminarProyectoLogico(Proyecto pr){

        try {
            this.conectar();
            String sql = "Update proyecto set estado = ? where id_Proyecto = ?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setInt(1, pr.getEstado());
            pre.setInt(2, pr.getId_Proyecto());
            
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro eliminado Éxitosamente";

    }
    
   public ArrayList<Proyecto> mostrarProyecto(){
    ArrayList<Proyecto> proyecto = new ArrayList();
        ResultSet res;
        try 
        {
            this.conectar();
            String sql = "select * from proyecto where estado!=0";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res = pre.executeQuery();
            while (res.next()) 
            {
                Proyecto pro=new Proyecto();
                pro.setId_Proyecto(res.getInt("id_Proyecto"));
                pro.setNombreProyecto(res.getString("nombreProyecto"));
                pro.setUbicacionProyecto(res.getString("ubicacionProyecto"));
                pro.setFechaInicio(res.getString("fechaInicio"));
                pro.setFechaFin(res.getString("fechaFin"));
                pro.setTipoProyecto(res.getString("tipoProyecto"));
                pro.setInversionInicial(res.getDouble("inversionInicial"));
                pro.setEstadoProyecto(res.getString("estadoProyecto"));
                pro.setEstado(res.getInt("estado"));
                

                proyecto.add(pro);
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
        return proyecto;
    
    }
}
