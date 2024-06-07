package com.example.demo.controllers;

import com.example.demo.models.ItemModel;
import com.example.demo.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    ItemsService itemsService;

    @GetMapping()
    public ArrayList<ItemModel> listItems(){
        return itemsService.getItems();
    }

    @PostMapping()
    public ItemModel guardarItem(@RequestBody ItemModel item){
        return this.itemsService.postItem(item);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @GetMapping( path = "/{id}")
    public Optional<ItemModel> obtenerItem(@PathVariable("id") Integer id){
        return this.itemsService.getById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @DeleteMapping( path = "/{id}")
    public String eliminarItem(@PathVariable("id") Integer id){
        boolean result = this.itemsService.deleteItem(id);
        if(result){
            return "Se elimino el item " + id;
        }else{
            return "No se pudo eliminar el item " + id;
        }
    }
}
