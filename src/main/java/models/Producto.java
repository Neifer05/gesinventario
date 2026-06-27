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

    public Producto(int id, String nombreProducto, String descripcion, float precio, int stock, int stockMinimo, int caducable) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.caducable = caducable;
    }

    public int getId() {
        return id;
    }
    public String getNombreProducto() {
        return nombreProducto;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public float getPrecio() {
        return precio;
    }
    public int getStock() {
        return stock;
    }
    public int getStockMinimo() {
        return stockMinimo;
    }
    public int getCaducable() {
        return caducable;
    }
    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public void setCaducable(int caducable) {
        this.caducable = caducable;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}
