/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

/**
 *
 * @author JC
 */
public class Empleado {
    private int idEmp;
    private String nombreEmp;
    private int edad;
    private String telefono;
    private String direccion;
    private int  asignacion;
    private int estado;

    public Empleado() {
    }

    public Empleado(int idEmp, String nombreEmp, int edad, String telefono, String direccion, int asignacion, int estado) {
        this.idEmp = idEmp;
        this.nombreEmp = nombreEmp;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
        this.asignacion = asignacion;
        this.estado = estado;
    }

    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    public String getNombreEmp() {
        return nombreEmp;
    }

    public void setNombreEmp(String nombreEmp) {
        this.nombreEmp = nombreEmp;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(int asignacion) {
        this.asignacion = asignacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
}
