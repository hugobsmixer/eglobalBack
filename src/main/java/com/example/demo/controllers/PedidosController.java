package com.example.demo.controllers;

import com.example.demo.models.PedidoModel;
import com.example.demo.services.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/pedidos")
public class PedidosController {
    @Autowired
    PedidosService pedidosService;

    @GetMapping()
    public ArrayList<PedidoModel> listPedidos(){
        return pedidosService.getPedidos();
    }

    @PostMapping()
    public PedidoModel guardarPedido(@RequestBody PedidoModel pedido){
        return this.pedidosService.postPedido(pedido);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @GetMapping( path = "/{id}")
    public Optional<PedidoModel> obtenerPedido(@PathVariable("id") Integer id){
        return this.pedidosService.getById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @DeleteMapping( path = "/{id}")
    public String eliminarPedido(@PathVariable("id") Integer id){
        boolean result = this.pedidosService.deletePedido(id);
        if(result){
            return "Se elimino el pedido " + id;
        }else{
            return "No se pudo eliminar el pedido " + id;
        }
    }
}
