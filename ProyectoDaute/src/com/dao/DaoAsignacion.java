/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dao;

import com.conexion.Conexion;
import com.modelo.Asignacion;
import com.modelo.RRHH;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JC
 */
public class DaoAsignacion extends Conexion{
    
    public String insertarAsignacion(Asignacion asig){
        try {
            this.conectar();
            String sql = "Insert into asignacionRRHH (id_RRHH ,id_Empleado, estado) values(?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);         
            pre.setInt(1, asig.getId_RRHH());
            pre.setInt(2, asig.getId_Empleado());
            pre.setInt(3, asig.getEstado());
       
            
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro Agregado Éxitosamente";
    }
    
    public ArrayList<Asignacion> mostrarAsignacion(){
    ArrayList<Asignacion> listAsignacion = new ArrayList();
        ResultSet res;
        try 
        {
            this.conectar();
            String sql = "select * from asignacionRRHH where estado!=0";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res = pre.executeQuery();
            while (res.next()) 
            {
                Asignacion asig = new Asignacion();
                asig.setId_RRHH(res.getInt("id_RRHH"));
                asig.setId_Empleado(res.getInt("id_Empleado"));
                
                listAsignacion.add(asig);
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
        return listAsignacion;
    
    }
    
}
