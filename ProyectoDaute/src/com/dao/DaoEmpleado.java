/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dao;

import com.conexion.Conexion;
import com.modelo.Empleado;
import com.modelo.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JC
 */
public class DaoEmpleado extends Conexion{
    public String insertarEmpleado(Empleado emp){
        try {
            this.conectar();
            String sql = "Insert into empleado (nombreEmp ,edad,telefono,direccion,estado) values(?,?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);         
            pre.setString(1, emp.getNombreEmp());
            pre.setInt(2, emp.getEdad());
            pre.setString(3, emp.getTelefono());
            pre.setString(4, emp.getDireccion());
            //pre.setInt(5, emp.getAsignacion());
            pre.setInt(5, emp.getEstado());
       
            
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro Agregado Éxitosamente";
    }
    
    public String modificarEmpleado(Empleado emp){
        try {
            this.conectar();
            String sql = "update empleado set nombreEmp=?,edad=?, telefono=?, direccion=?, estado=? where idEmp=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);         
            pre.setString(1, emp.getNombreEmp());
            pre.setInt(2, emp.getEdad());
            pre.setString(3, emp.getTelefono());
            pre.setString(4, emp.getDireccion());
            //pre.setInt(5, emp.getAsignacion());
            pre.setInt(5, emp.getEstado());
            pre.setInt(6, emp.getIdEmp());
       
            
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro Modificado Éxitosamente";
    }
    
    public String eliminarEmpleado(Empleado emp){
        try {
            this.conectar();
            String sql = "delete from empleado where idEmp=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, emp.getIdEmp());
       
            
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminado: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro Eliminado Éxitosamente";
    }
    
    public ArrayList<Empleado> mostrarEmpleado(){
    ArrayList<Empleado> Empleado = new ArrayList();
        ResultSet res = null;
        try 
        {
            this.conectar();
            String sql = "select*from empleado ";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res = pre.executeQuery();
            while (res.next()) 
            {
                Empleado emp=new Empleado();
                emp.setIdEmp(res.getInt("idEmp"));
                emp.setNombreEmp(res.getString("nombreEmp"));
                emp.setEdad(res.getInt("edad"));
                emp.setTelefono(res.getString("telefono"));
                emp.setDireccion(res.getString("direccion"));
                //emp.setAsignacion(res.getInt("asignacion"));
                emp.setEstado(res.getInt("estado"));

                Empleado.add(emp);
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
        return Empleado;
    
    }
    
    public String eliminarEmpleadoLogico(Empleado emp){

        try {
            this.conectar();
            String sql = "Update empleado set estado = ? where idEmp = ?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setInt(1, emp.getEstado());
            pre.setInt(2, emp.getIdEmp());
            
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
