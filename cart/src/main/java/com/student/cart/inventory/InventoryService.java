package com.student.cart.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> getAllInventories(){
        List<Inventory> inventories = new ArrayList<>();
        inventoryRepository.findAll().forEach(inventories::add);
        return inventories;
    }

    public Inventory getInventory(int id){
        return inventoryRepository.findOne(id);
    }

    public void addInventory(Inventory inventory){
        inventoryRepository.save(inventory);
    }

    public void updateInventory(Inventory inventory){
        inventoryRepository.save(inventory);
    }

    public void deleteInventory(int id){
        inventoryRepository.delete(id);
    }


}
