/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dao;

import com.conexion.Conexion;
import com.modelo.Empleado;
import com.modelo.MateriaPrima;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JC
 */
public class DaoMateriaPrima extends Conexion{
    public String insertarMateria(MateriaPrima mat){
        try {
            this.conectar();
            String sql = "Insert into materiaPrima (nombreMateria ,DescripcionMateria,precio, estado) values(?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);         
            pre.setString(1, mat.getNombreMateria());
            pre.setString(2, mat.getDescripcionMateria());
            pre.setDouble(3, mat.getPrecio());
            pre.setInt(4, mat.getEstado());
       
            
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro Agregado Éxitosamente";
    }
    
    public String modificarMateria(MateriaPrima mat){
        try {
            this.conectar();
            String sql = "update materiaPrima set nombreMateria=?,DescripcionMateria=?, precio=?,estado=? where id_MateriaP=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);  
            
            
            pre.setString(1, mat.getNombreMateria());
            pre.setString(2, mat.getDescripcionMateria());
            pre.setDouble(3, mat.getPrecio());
            pre.setInt(4, mat.getEstado());      
            pre.setInt(5, mat.getId_MateriaP());
            
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro Modificado Éxitosamente";
    }
    
    public String eliminarMateria(MateriaPrima mat){
        try {
            this.conectar();
            String sql = "delete from materiaPrima where id_MateriaP=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, mat.getId_MateriaP());
       
            
            pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminado: "+e.getMessage(),"Error",0);
        }
        
        finally{
            this.desconectar();
        }
        
        return "Registro Eliminado Éxitosamente";
    }
    
    public ArrayList<MateriaPrima> mostrarMateria(){
    ArrayList<MateriaPrima> MateriaPrima = new ArrayList();
        ResultSet res = null;
        try 
        {
            this.conectar();
            String sql = "select*from materiaPrima where estado!=0";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res = pre.executeQuery();
            while (res.next()) 
            {
                MateriaPrima mat=new MateriaPrima();
                mat.setId_MateriaP(res.getInt("id_MateriaP"));
                mat.setNombreMateria(res.getString("nombreMateria"));
                mat.setDescripcionMateria(res.getString("DescripcionMateria"));
                mat.setPrecio(res.getDouble("precio"));
                mat.setEstado(res.getInt("estado"));

                MateriaPrima.add(mat);
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
        return MateriaPrima;
    
    }
    
    public String eliminarMateriaLogico(MateriaPrima mat){

        try {
            this.conectar();
            String sql = "Update materiaPrima set estado = ? where id_MateriaP = ?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setInt(1, mat.getEstado());
            pre.setInt(2, mat.getId_MateriaP());
            
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
