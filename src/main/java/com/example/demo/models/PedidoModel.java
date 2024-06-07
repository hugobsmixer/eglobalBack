package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "pedidos")
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id_pedido;
    private int id_pedido_item;


    public void setId(int id_pedido) {
        this.id_pedido = id_pedido;
    }
    public int getId(){
        return id_pedido;
    }
    
    public void setIdPedido(int id_pedido_item) {
        this.id_pedido_item = id_pedido_item;
    }
    public int getIdPedido(){
        return id_pedido_item;
    }

}
