package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class ItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id_item;
    private int id_pedido_item;
    private String nombre;
    private double precio;
    private int cantidad;

    public void setId(int id_item) {
        this.id_item = id_item;
    }
    public int getId(){
        return id_item;
    }
    
    public void setIdPedido(int id_pedido_item) {
        this.id_pedido_item = id_pedido_item;
    }
    public int getIdPedido(){
        return id_pedido_item;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String nombre(){
        return nombre;
    }

    public void setPrecio(double precio) {
        this.precio= precio;
    }
    public double getPrecio(){
        return precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public int getCantidad(){
        return cantidad;
    }
}
