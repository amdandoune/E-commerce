package com.student.cart.items;

import com.student.cart.items.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems(){
        List<Item> items = new ArrayList<>();
        itemRepository.findAll().forEach(items::add);
        return items;
    }

    public Item getItem(int id){
        return itemRepository.findOne(id);
    }

    public void addItem(Item item){
        itemRepository.save(item);
    }

    public void updateItem(Item item){
        itemRepository.save(item);
    }

    public void deleteItem(int id){
        itemRepository.delete(id);
    }


}
