
package com.modelo;

/**
 *
 * @author JC
 */
public class DetalleMaquinaria {
    
    private int id_Detalle_Maquinaria;
    private int id_Maquinaria;
    private int id_Proyecto;
    private String nombreProyecto;
    private String nombreMaquinaria;
    private int cantidad;
    private int cantidadP;
    private int estado;

    public DetalleMaquinaria() {
    }

    public DetalleMaquinaria(int id_Detalle_Maquinaria, int id_Maquinaria, int id_Proyecto, String nombreProyecto, String nombreMaquinaria, int cantidad, int cantidadP, int estado) {
        this.id_Detalle_Maquinaria = id_Detalle_Maquinaria;
        this.id_Maquinaria = id_Maquinaria;
        this.id_Proyecto = id_Proyecto;
        this.nombreProyecto = nombreProyecto;
        this.nombreMaquinaria = nombreMaquinaria;
        this.cantidad = cantidad;
        this.cantidadP = cantidadP;
        this.estado = estado;
    }

    public int getId_Detalle_Maquinaria() {
        return id_Detalle_Maquinaria;
    }

    public void setId_Detalle_Maquinaria(int id_Detalle_Maquinaria) {
        this.id_Detalle_Maquinaria = id_Detalle_Maquinaria;
    }

    public int getId_Maquinaria() {
        return id_Maquinaria;
    }

    public void setId_Maquinaria(int id_Maquinaria) {
        this.id_Maquinaria = id_Maquinaria;
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

    public String getNombreMaquinaria() {
        return nombreMaquinaria;
    }

    public void setNombreMaquinaria(String nombreMaquinaria) {
        this.nombreMaquinaria = nombreMaquinaria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidadP() {
        return cantidadP;
    }

    public void setCantidadP(int cantidadP) {
        this.cantidadP = cantidadP;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

   
}
