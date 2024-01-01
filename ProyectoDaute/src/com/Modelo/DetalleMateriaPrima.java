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
public class DetalleMateriaPrima {
    private int id_detalle_materiap;
    private int id_materiap;
    private int id_proyecto;
    private int cantidad;

    public DetalleMateriaPrima() {
    }

    public DetalleMateriaPrima(int id_detalle_materiap, int id_materiap, int id_proyecto, int cantidad) {
        this.id_detalle_materiap = id_detalle_materiap;
        this.id_materiap = id_materiap;
        this.id_proyecto = id_proyecto;
        this.cantidad = cantidad;
    }

    public int getId_detalle_materiap() {
        return id_detalle_materiap;
    }

    public void setId_detalle_materiap(int id_detalle_materiap) {
        this.id_detalle_materiap = id_detalle_materiap;
    }

    public int getId_materiap() {
        return id_materiap;
    }

    public void setId_materiap(int id_materiap) {
        this.id_materiap = id_materiap;
    }

    public int getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
