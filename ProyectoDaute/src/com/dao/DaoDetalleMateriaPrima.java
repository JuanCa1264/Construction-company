/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.Modelo.DetalleMateriaPrima;
import com.Modelo.Rol;
import com.Modelo.Usuario;
import com.conexion.Conexion;
import com.modelo.Empleado;
import com.modelo.MateriaPrima;
import com.modelo.Proyecto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class DaoDetalleMateriaPrima extends Conexion {
    public String insertarMateria(DetalleMateriaPrima dmp){
        try {
            this.conectar();
            String sql = "insert into detallemateriap (id_MateriaP,id_Proyecto,cantidad) values(?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);         
            pre.setInt(1, dmp.getId_materiap());
            pre.setInt(2,dmp.getId_proyecto());
            pre.setInt(3,dmp.getCantidad());
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro Agregado Éxitosamente";
    }
    
     public ArrayList<DetalleMateriaPrima> mostrarDMP(){
    ArrayList<DetalleMateriaPrima> dmp = new ArrayList();
        ResultSet res = null;
        try 
        {
            this.conectar();
            String sql = "select*from detallemateriap ";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res = pre.executeQuery();
            while (res.next()) 
            {
                DetalleMateriaPrima dm= new DetalleMateriaPrima();
                dm.setId_detalle_materiap(res.getInt("id_Detalle_MateriaP"));
                dm.setId_materiap(res.getInt("id_MateriaP"));
                dm.setId_proyecto(res.getInt("id_Proyecto"));
                dm.setCantidad(res.getInt("cantidad"));
               

               dmp.add(dm);
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
        return dmp;
    
    }
     
      public MateriaPrima getMateriP(int MateriaP)
     {
       MateriaPrima rl = new MateriaPrima();

        ResultSet res = null;
           try 
           {
               this.conectar();
               String sql = 
                       "select*from materiaprima where id_MateriaP = ?";
               PreparedStatement pre = this.getCon().prepareCall(sql);
                 pre.setInt(1, MateriaP);   
               res = pre.executeQuery();

               while (res.next()) 
               {              
                  rl.setNombreMateria(res.getString("nombreMateria"));
                  rl.setDescripcionMateria(res.getString("DescripcionMateria"));
                  rl.setPrecio(res.getDouble("precio"));
                  rl.setEstado(res.getInt("estado"));
                  rl.setId_MateriaP(res.getInt("id_MateriaP"));
                  
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
      
      public Proyecto getProy (int Proy)
     {
       Proyecto rl = new Proyecto();

        ResultSet res = null;
           try 
           {
               this.conectar();
               String sql = 
                       "select*from proyecto where id_Proyecto = ?";
               PreparedStatement pre = this.getCon().prepareCall(sql);
                 pre.setInt(1, Proy);   
               res = pre.executeQuery();

               while (res.next()) 
               {              
                  rl.setNombreProyecto(res.getString("nombreProyecto"));
                  rl.setUbicacionProyecto(res.getString("ubicacionProyecto"));
                  rl.setFechaInicio(res.getString("fechaInicio"));
                  rl.setFechaFin(res.getString("fechaFin"));
                  rl.setTipoProyecto(res.getString("tipoProyecto"));
                  rl.setInversionInicial(res.getDouble("fechaFin"));
                  rl.setEstadoProyecto(res.getString("estadoProyecto"));
                  rl.setEstado(res.getInt("estado"));
                  rl.setId_Proyecto(res.getInt("id_Proyecto"));
                  
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
      
      public String eliminarDetalle(DetalleMateriaPrima dmp ){

        try {
            this.conectar();
            String sql = "Delete from detallemateriap where id_Detalle_MateriaP= ?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setInt(1, dmp.getId_detalle_materiap());
            
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro eliminado Éxitosamente";
     
     
}
      public void modificarDetalle(DetalleMateriaPrima dmp)
    {

        try {

            this.conectar();

            String sql = "update detallemateriap set id_MateriaP = ? , id_Proyecto = ?, cantidad= ? where id_Detalle_MateriaP = ? ";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1,dmp.getId_materiap());
            pre.setInt(2,dmp.getId_proyecto());
            pre.setInt(3, dmp.getCantidad());
            pre.setInt(4,dmp.getId_detalle_materiap());
          
            pre.executeUpdate();

        } 
        catch (Exception e) 
        {
          JOptionPane.showMessageDialog(null,"Error al modificar datos"+e.getMessage());
        } finally 
        {

            this.desconectar();
        }
}}
