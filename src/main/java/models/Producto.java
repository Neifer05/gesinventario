package models;

import models.enums.TipoProducto;

public class Producto {
    private int id;
    private String nombreProducto;
    private String descripcion;
    private float precio;
    private int stock;
    private int stockMinimo;
    private int caducable;
    private TipoProducto tipoProducto;

    public Producto(int id, String nombreProducto, String descripcion, float precio, int stock, int stockMinimo, int caducable, TipoProducto tipoProducto) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.caducable = caducable;
        this.tipoProducto = tipoProducto;
    }
}
