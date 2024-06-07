package com.example.demo.repositories;

import com.example.demo.models.ItemModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends CrudRepository<ItemModel, Integer> {
}
