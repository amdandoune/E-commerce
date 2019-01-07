package com.student.cart.shipping;

import com.student.cart.costumers.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @RequestMapping("/customers/{cid}/shippings") /*@RequestMapping("/customers/{cid}/shippings")*/
    public List<Shipping> getAllShippings(@PathVariable int cid){
        return shippingService.getAllShippings(cid);
    }

    @RequestMapping("/customers/{cid}/shippings/{id}")/*@RequestMapping("/customers/{cid}/shippings/{id}")*/
    public Shipping getShipping(@PathVariable int id){
        return shippingService.getShipping(id);
    }

    @RequestMapping( method= RequestMethod.POST, value="/customers/{cid}/shippings")/*@RequestMapping("/customers/{cid}/shippings")*/
    public void addShipping(@RequestBody Shipping shipping, @PathVariable int cid){
        shipping.setCustomer(new Customer(cid));
        shippingService.addShipping(shipping);
    }

    @RequestMapping( method= RequestMethod.PUT, value="/customers/{cid}/shippings/{id}")/*@RequestMapping("/customers/{cid}/shippings/{id}")*/
    public void updateShipping(@RequestBody Shipping shipping, @PathVariable int id, @PathVariable int cid){
        shipping.setCustomer(new Customer(cid));
        shipping.setId(id);
        shippingService.updateShipping(shipping);
    }

    @RequestMapping( method= RequestMethod.DELETE, value="/customers/{cid}/shippings/{id}")/*@RequestMapping("/customers/{cid}/shippings/{id}")*/
    public void deleteShipping(@PathVariable int id){
        shippingService.deleteShipping(id);
    }

}
