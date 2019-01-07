package com.student.cart.items;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @Column(name="ID")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private double price;
    @Column(name="quantity")
    private int quantity;
    @Column(name="seller")
    private String seller;
    @Column(name="type")
    private String type;
    @Column(name="inventory_ID")
    private int inventoryID; // might want to make changes


    public Item(){}

    public Item(int id){
        super();
        this.id = id;
        this.name = "";
        this.price = 0;
        this.quantity = 0;
        this.seller = "";
        this.inventoryID = 0;
        this.type = "";
    }

    public Item(int id, String name, double price, int quantity, String seller, int inventoryID, String type){
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.seller = seller;
        this.inventoryID = inventoryID;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }
}
