package com.student.cart.costumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @RequestMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable int id){
        return customerService.getCustomer(id);
    }

    @RequestMapping( method= RequestMethod.POST, value="/customers")
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }

    @RequestMapping( method= RequestMethod.PUT, value="/customers/{id}")
    public void updateCustomer(@RequestBody Customer customer, @PathVariable int id){
        customer.setId(id);
        customerService.updateCustomer(customer);
    }

    @RequestMapping( method= RequestMethod.DELETE, value="/customers/{id}")
    public void deleteCustomer(@PathVariable int id){
        customerService.deleteCustomer(id);
    }
}
