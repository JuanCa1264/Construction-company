/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Modelo;

/**
 *
 * @author usuario
 */
public class Rol {
    private int id_rol;
    private String nombrerol;

    public Rol() {
    }

    public Rol(int id_rol, String nombrerol) {
        this.id_rol = id_rol;
        this.nombrerol = nombrerol;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombrerol() {
        return nombrerol;
    }

    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
    }
    
    
}
