package com.student.cart.shoppingCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public List<ShoppingCart> getAllShoppingCarts(int cid){
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        shoppingCartRepository.findByCustomerId(cid).forEach(shoppingCarts::add);
//        shoppingCartRepository.findAll().forEach(shoppingCarts::add);
        return shoppingCarts;
    }

    public ShoppingCart getShoppingCart(int id){
        return shoppingCartRepository.findOne(id);
    }

    public void addShoppingCart(ShoppingCart shoppingCart){
        shoppingCartRepository.save(shoppingCart);
    }

    public void updateShoppingCart(ShoppingCart shoppingCart){
        shoppingCartRepository.save(shoppingCart);
    }

    public void deleteShoppingCart(int id){
        shoppingCartRepository.delete(id);
    }


}
