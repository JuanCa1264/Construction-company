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
public class DetalleRRHH {
    
    private int id_Detalle_RRHH;
    private int id_Proyecto;
    private int id_AsignacionRRHH;
    private String nombrePro;
    private String nombreEmp;
    private String nombreRRHH;
    private int estado;

    public DetalleRRHH() {
    }

    public DetalleRRHH(int id_Detalle_RRHH, int id_Proyecto, int id_AsignacionRRHH, String nombrePro, String nombreEmp, String nombreRRHH, int estado) {
        this.id_Detalle_RRHH = id_Detalle_RRHH;
        this.id_Proyecto = id_Proyecto;
        this.id_AsignacionRRHH = id_AsignacionRRHH;
        this.nombrePro = nombrePro;
        this.nombreEmp = nombreEmp;
        this.nombreRRHH = nombreRRHH;
        this.estado = estado;
    }

    public int getId_Detalle_RRHH() {
        return id_Detalle_RRHH;
    }

    public void setId_Detalle_RRHH(int id_Detalle_RRHH) {
        this.id_Detalle_RRHH = id_Detalle_RRHH;
    }

    public int getId_Proyecto() {
        return id_Proyecto;
    }

    public void setId_Proyecto(int id_Proyecto) {
        this.id_Proyecto = id_Proyecto;
    }

    public int getId_AsignacionRRHH() {
        return id_AsignacionRRHH;
    }

    public void setId_AsignacionRRHH(int id_AsignacionRRHH) {
        this.id_AsignacionRRHH = id_AsignacionRRHH;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public String getNombreEmp() {
        return nombreEmp;
    }

    public void setNombreEmp(String nombreEmp) {
        this.nombreEmp = nombreEmp;
    }

    public String getNombreRRHH() {
        return nombreRRHH;
    }

    public void setNombreRRHH(String nombreRRHH) {
        this.nombreRRHH = nombreRRHH;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
    
    
    
    
    
}
