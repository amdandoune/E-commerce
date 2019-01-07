package com.student.cart.shoppingCartItems;

import com.student.cart.items.Item;
import com.student.cart.shoppingCart.ShoppingCart;
import com.student.cart.shoppingCartItems.ShoppingCartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoppingCartItemController {

    @Autowired
    private ShoppingCartItemService shoppingCartItemService;

    @RequestMapping("/customers/{cid}/shoppingCarts/{sid}/shoppingCartItems")/*@RequestMapping("/customers/{cid}/shoppingCarts/{sid}/shoppingCartItems")*/
    public List<ShoppingCartItem> getAllShoppingCartItems(@PathVariable int sid){
        return shoppingCartItemService.getAllShoppingCartItems(sid);
    }

    @RequestMapping("/customers/{cid}/shoppingCarts/{sid}/shoppingCartItems/{id}")/*@RequestMapping("/customers/{cid}/shoppingCarts/{sid}/shoppingCartItems/{id}")*/
    public ShoppingCartItem getShoppingCartItem(@PathVariable int id /*@PathVariable int sid, @PathVariable String cid*/){
        return shoppingCartItemService.getShoppingCartItem(id);
    }

    @RequestMapping( method= RequestMethod.POST, value="/customers/{cid}/shoppingCarts/{sid}/shoppingCartItems")/*@RequestMapping("/customers/{cid}/shoppingCarts/{sid}/shoppingCartItems")*/
    public void addShoppingCartItem(@RequestBody ShoppingCartItem shoppingCartItem, @PathVariable int sid, @PathVariable int cid){
        shoppingCartItem.setShoppingCart(new ShoppingCart(sid));
        shoppingCartItemService.addShoppingCartItem(shoppingCartItem);
    }

    @RequestMapping( method= RequestMethod.PUT, value="/customers/{cid}/shoppingCarts/{sid}/shoppingCartItems/{id}")/*@RequestMapping("/customers/{cid}/shoppingCarts/{sid}/shoppingCartItems/{id}")*/
    public void updateShoppingCartItem(@RequestBody ShoppingCartItem shoppingCartItem, @PathVariable int id, @PathVariable int sid, @PathVariable int cid){
        shoppingCartItem.setShoppingCart(new ShoppingCart(sid));
        shoppingCartItem.setItem(new Item(id));
        shoppingCartItemService.updateShoppingCartItem(shoppingCartItem);
    }

    @RequestMapping( method= RequestMethod.DELETE, value="/customers/{cid}/shoppingCarts/{sid}/shoppingCartItems/{id}")/*@RequestMapping("/customers/{cid}/shoppingCarts/{sid}/shoppingCartItems/{id}")*/
    public void deleteShoppingCartItem(@PathVariable int id){
        shoppingCartItemService.deleteShoppingCartItem(id);
    }

}
