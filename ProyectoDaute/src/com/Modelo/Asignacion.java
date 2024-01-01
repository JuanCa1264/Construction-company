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
public class Asignacion {
    
    private int id_RRHH;
    private int id_Empleado;
    private int estado;

    public Asignacion() {
    }

    public Asignacion(int id_RRHH, int id_Empleado, int estado) {
        this.id_RRHH = id_RRHH;
        this.id_Empleado = id_Empleado;
        this.estado = estado;
    }

    public int getId_RRHH() {
        return id_RRHH;
    }

    public void setId_RRHH(int id_RRHH) {
        this.id_RRHH = id_RRHH;
    }

    public int getId_Empleado() {
        return id_Empleado;
    }

    public void setId_Empleado(int id_Empleado) {
        this.id_Empleado = id_Empleado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
}
