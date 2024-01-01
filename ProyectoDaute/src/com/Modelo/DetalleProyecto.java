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
public class DetalleProyecto {
    private int detalle_Proyecto;
    private int id_Proyecto;
    private String nombreProyecto;
    private String atrasos;
    private String PorcentajeU;
    private String porcentajeAvance;
    private int estado;

    public DetalleProyecto() {
    }

    public DetalleProyecto(int detalle_Proyecto, int id_Proyecto, String nombreProyecto, String atrasos, String PorcentajeU, String porcentajeAvance, int estado) {
        this.detalle_Proyecto = detalle_Proyecto;
        this.id_Proyecto = id_Proyecto;
        this.nombreProyecto = nombreProyecto;
        this.atrasos = atrasos;
        this.PorcentajeU = PorcentajeU;
        this.porcentajeAvance = porcentajeAvance;
        this.estado = estado;
    }

    public int getDetalle_Proyecto() {
        return detalle_Proyecto;
    }

    public void setDetalle_Proyecto(int detalle_Proyecto) {
        this.detalle_Proyecto = detalle_Proyecto;
    }

    public int getId_Proyecto() {
        return id_Proyecto;
    }

    public void setId_Proyecto(int id_Proyecto) {
        this.id_Proyecto = id_Proyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getAtrasos() {
        return atrasos;
    }

    public void setAtrasos(String atrasos) {
        this.atrasos = atrasos;
    }

    public String getPorcentajeU() {
        return PorcentajeU;
    }

    public void setPorcentajeU(String PorcentajeU) {
        this.PorcentajeU = PorcentajeU;
    }

    public String getPorcentajeAvance() {
        return porcentajeAvance;
    }

    public void setPorcentajeAvance(String porcentajeAvance) {
        this.porcentajeAvance = porcentajeAvance;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

  
    
    
    
    
    
}
