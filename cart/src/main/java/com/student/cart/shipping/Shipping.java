package com.student.cart.shipping;

import com.student.cart.costumers.Customer;

import javax.persistence.*;

@Entity
@Table(name = "shipping")
public class Shipping {

    @Id
    @Column(name="ID")
    private int id;
    @Column(name="address")
    private String address;
    @Column(name="type")
    private String type;
    @Column(name="fees")
    private double fees;
    @Column(name="carrier")
    private String carrier;

    @ManyToOne
    private Customer customer;

    public Shipping(){}

    public Shipping(int id, int custumerId, String address, String type, double fees, String carrier ){
        super();
        this.id = id;
        this.customer = new Customer(custumerId);
        this.address = address;
        this.type = type;
        this.fees = fees;
        this.carrier = carrier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
