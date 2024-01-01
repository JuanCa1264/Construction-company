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
public class Maquinaria {
    
    private int id_Maquinaria;
    private String nombreMaquinaria;
    private String modelo;
    private String fabricante;
    private double precio;
    private int anio;
    private int estado;
    private int available;
    private int cantidad;
    
    public Maquinaria() {
    }

    public Maquinaria(int id_Maquinaria, String nombreMaquinaria, String modelo, String fabricante, double precio, int anio, int estado, int available, int cantidad) {
        this.id_Maquinaria = id_Maquinaria;
        this.nombreMaquinaria = nombreMaquinaria;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.precio = precio;
        this.anio = anio;
        this.estado = estado;
        this.available = available;
        this.cantidad = cantidad;
    }

    public int getId_Maquinaria() {
        return id_Maquinaria;
    }

    public void setId_Maquinaria(int id_Maquinaria) {
        this.id_Maquinaria = id_Maquinaria;
    }

    public String getNombreMaquinaria() {
        return nombreMaquinaria;
    }

    public void setNombreMaquinaria(String nombreMaquinaria) {
        this.nombreMaquinaria = nombreMaquinaria;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
           
}
