/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author JC
 */
public class Conexion {
    private Connection con;

    public Connection getCon() {
        return con;
    }
    
    public boolean conectar(){
    try {
    Class.forName("com.mysql.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdaute2019","root","");
    return true;
    }
    catch(SQLException| ClassNotFoundException e){
    JOptionPane.showMessageDialog(null,"ERROR EN LA COEXION"+e.getMessage(), "ERROR", 0);
    return false;
    }
    }
    public boolean desconectar(){
     try {
            
            if (con!=null) {
             if (con.isClosed()==false) {
                con.close();
            }
            
        }
          
            return true;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al desconectar "+e.getMessage(),"Error",0);
            return false;
        }
        
        
    }

    
    }
    
    

