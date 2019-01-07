package com.student.cart.shoppingCart;

import com.student.cart.costumers.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping("/customers/{cid}/shoppingCarts")/*@RequestMapping("/customers/{cid}/shoppingCarts")*/
    public List<ShoppingCart> getAllShoppingCarts( @PathVariable int cid){
        return shoppingCartService.getAllShoppingCarts(cid);
    }

    @RequestMapping("/customers/{cid}/shoppingCarts/{id}")/*@RequestMapping("/customers/{cid}/shoppingCarts/{id}")*/
    public ShoppingCart getShoppingCart(@PathVariable int id){
        return shoppingCartService.getShoppingCart(id);
    }

    @RequestMapping( method= RequestMethod.POST, value="/customers/{cid}/shoppingCarts")/*@RequestMapping("/customers/{cid}/shoppingCarts")*/
    public void addShoppingCart(@RequestBody ShoppingCart shoppingCart, @PathVariable int cid){
        shoppingCart.setCustomer(new Customer(cid));
        shoppingCartService.addShoppingCart(shoppingCart);
    }

    @RequestMapping( method= RequestMethod.PUT, value="/customers/{cid}/shoppingCarts/{id}")/*@RequestMapping("/customers/{cid}/shoppingCarts/{id}")*/
    public void updateShoppingCart(@RequestBody ShoppingCart shoppingCart, @PathVariable int cid, @PathVariable int id){
        shoppingCart.setCustomer(new Customer(cid));
        shoppingCart.setId(id);
        shoppingCartService.updateShoppingCart(shoppingCart);
    }

    @RequestMapping( method= RequestMethod.DELETE, value="/customers/{cid}/shoppingCarts/{id}")/*@RequestMapping("/customers/{cid}/shoppingCarts/{id}")*/
    public void deleteShoppingCart(@PathVariable int id){
        shoppingCartService.deleteShoppingCart(id);
    }

}
