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
public class Usuario {
    private int id_user;
    private String fullname;
    private String username;
    private String password;
    private int id_rol;
    private int estado;

    public Usuario() {
    }

    public Usuario(int id_user, String fullname, String username, String password, int id_rol, int estado) {
        this.id_user = id_user;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.id_rol = id_rol;
        this.estado = estado;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

   
    
}

