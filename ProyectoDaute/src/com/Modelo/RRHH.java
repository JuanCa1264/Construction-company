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
public class RRHH {
    private int idRRHH;
    private String nombreRRHH;
    private String descripcion;
    private int estado;

    public RRHH() {
    }

    public RRHH(int idRRHH, String nombreRRHH, String descripcion, int estado) {
        this.idRRHH = idRRHH;
        this.nombreRRHH = nombreRRHH;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getIdRRHH() {
        return idRRHH;
    }

    public void setIdRRHH(int idRRHH) {
        this.idRRHH = idRRHH;
    }

    public String getNombreRRHH() {
        return nombreRRHH;
    }

    public void setNombreRRHH(String nombreRRHH) {
        this.nombreRRHH = nombreRRHH;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
}
