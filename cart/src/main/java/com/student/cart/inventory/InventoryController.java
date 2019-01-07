package com.student.cart.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @RequestMapping("/inventories")
    public List<Inventory> getAllInventories(){
        return inventoryService.getAllInventories();
    }

    @RequestMapping("/inventories/{id}")
    public Inventory getInventory(@PathVariable int id){
        return inventoryService.getInventory(id);
    }

    @RequestMapping( method= RequestMethod.POST, value="/inventories")
    public void addInventory(@RequestBody Inventory inventory){
        inventoryService.addInventory(inventory);
    }

    @RequestMapping( method= RequestMethod.PUT, value="/inventories/{id}")
    public void updateInventory(@RequestBody Inventory inventory, @PathVariable int id){
        inventory.setId(id);
        inventoryService.updateInventory(inventory);
    }

    @RequestMapping( method= RequestMethod.DELETE, value="/inventories/{id}")
    public void deleteInventory(@PathVariable int id){
        inventoryService.deleteInventory(id);
    }

}
