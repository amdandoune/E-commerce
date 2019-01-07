package com.student.cart.shoppingCart;

import com.student.cart.costumers.Customer;

import javax.persistence.*;

@Entity
@Table( name = "shoppingcart")
public class ShoppingCart {

    @Id
    @Column(name="ID")
    private int id;
    @Column(name="sum")
    private double totalSum;

    @ManyToOne
    private Customer customer;

    public ShoppingCart(){}

    public ShoppingCart(int id){
        super();
        this.id = id;
    }

    public ShoppingCart(int id, int customerId, double totalSum){
        super();
        this.id = id;
        this.customer = new Customer(customerId);
        this.totalSum = totalSum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
