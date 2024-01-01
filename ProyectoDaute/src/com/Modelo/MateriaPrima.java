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
public class MateriaPrima {
    private int id_MateriaP;
    private String nombreMateria;
    private String descripcionMateria;
    private double precio;
    private int estado;

    public MateriaPrima(int id_MateriaP, String nombreMateria, String descripcionMateria, double precio, int estado) {
        this.id_MateriaP = id_MateriaP;
        this.nombreMateria = nombreMateria;
        this.descripcionMateria = descripcionMateria;
        this.precio = precio;
        this.estado = estado;
    }

    public MateriaPrima() {
    }

    public int getId_MateriaP() {
        return id_MateriaP;
    }

    public void setId_MateriaP(int id_MateriaP) {
        this.id_MateriaP = id_MateriaP;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getDescripcionMateria() {
        return descripcionMateria;
    }

    public void setDescripcionMateria(String descripcionMateria) {
        this.descripcionMateria = descripcionMateria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
}
