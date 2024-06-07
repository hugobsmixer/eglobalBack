package com.example.demo.services;

import com.example.demo.models.ItemModel;
import com.example.demo.repositories.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ItemsService {
    @Autowired
    ItemsRepository itemsRepository;

    public ArrayList<ItemModel> getItems(){
        return (ArrayList<ItemModel>)itemsRepository.findAll();
    }

    public ItemModel postItem(ItemModel item){
        return itemsRepository.save(item);
    }

    public Optional<ItemModel> getById(Integer id) {
        return itemsRepository.findById(id);
    }

    public boolean deleteItem(Integer id){
        try{
            itemsRepository.deleteById(id);
            return true;
        }
        catch(Exception error)
        {
            return false;
        }
    }
}
