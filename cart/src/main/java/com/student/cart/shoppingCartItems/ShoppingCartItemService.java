package com.student.cart.shoppingCartItems;

import com.student.cart.shoppingCartItems.ShoppingCartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartItemService {

    @Autowired
    private ShoppingCartItemRepository shoppingCartItemRepository;

    public List<ShoppingCartItem> getAllShoppingCartItems(int sid){
        List<ShoppingCartItem> shoppingCartItems = new ArrayList<>();
        shoppingCartItemRepository.findByShoppingCartId(sid).forEach(shoppingCartItems::add);
//        shoppingCartItemRepository.findAll().forEach(shoppingCartItems::add);
        return shoppingCartItems;
    }

    public ShoppingCartItem getShoppingCartItem(int id){
        return shoppingCartItemRepository.findOne(id);
    }

    public void addShoppingCartItem(ShoppingCartItem shoppingCartItem){
        shoppingCartItemRepository.save(shoppingCartItem);
    }

    public void updateShoppingCartItem(ShoppingCartItem shoppingCartItem){
        shoppingCartItemRepository.save(shoppingCartItem);
    }

    public void deleteShoppingCartItem(int id){
        shoppingCartItemRepository.delete(id);
    }


}
