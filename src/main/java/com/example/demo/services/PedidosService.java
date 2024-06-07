package com.example.demo.services;

import com.example.demo.models.PedidoModel;
import com.example.demo.repositories.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PedidosService {
    @Autowired
    PedidosRepository pedidosRepository;

    public ArrayList<PedidoModel> getPedidos(){
        return (ArrayList<PedidoModel>)pedidosRepository.findAll();
    }

    public PedidoModel postPedido(PedidoModel pedido){
        return pedidosRepository.save(pedido);
    }

    public Optional<PedidoModel> getById(Integer id) {
        return pedidosRepository.findById(id);
    }

    public boolean deletePedido(Integer id){
        try{
            pedidosRepository.deleteById(id);
            return true;
        }
        catch(Exception error)
        {
            return false;
        }
    }
}
