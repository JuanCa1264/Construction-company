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
public class Proyecto {
    private int id_Proyecto;
    private String nombreProyecto;
    private String ubicacionProyecto;
    private String fechaInicio;
    private String fechaFin;
    private String tipoProyecto;
    private double inversionInicial;
    private String estadoProyecto;
    private int estado;

    public Proyecto() {
    }

    public Proyecto(int id_Proyecto, String nombreProyecto, String ubicacionProyecto, String fechaInicio, String fechaFin, String tipoProyecto, double inversionInicial, String estadoProyecto, int estado) {
        this.id_Proyecto = id_Proyecto;
        this.nombreProyecto = nombreProyecto;
        this.ubicacionProyecto = ubicacionProyecto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipoProyecto = tipoProyecto;
        this.inversionInicial = inversionInicial;
        this.estadoProyecto = estadoProyecto;
        this.estado = estado;
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

    public String getUbicacionProyecto() {
        return ubicacionProyecto;
    }

    public void setUbicacionProyecto(String ubicacionProyecto) {
        this.ubicacionProyecto = ubicacionProyecto;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipoProyecto() {
        return tipoProyecto;
    }

    public void setTipoProyecto(String tipoProyecto) {
        this.tipoProyecto = tipoProyecto;
    }

    public double getInversionInicial() {
        return inversionInicial;
    }

    public void setInversionInicial(double inversionInicial) {
        this.inversionInicial = inversionInicial;
    }

    public String getEstadoProyecto() {
        return estadoProyecto;
    }

    public void setEstadoProyecto(String estadoProyecto) {
        this.estadoProyecto = estadoProyecto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
}
