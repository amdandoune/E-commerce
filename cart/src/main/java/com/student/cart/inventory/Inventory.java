package com.student.cart.inventory;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @Column(name="ID")
    private int id;
    @Column(name="type")
    private String type;
    @Column(name="total_quantity")
    private int totalQuantity;

    public Inventory(){}

    public Inventory(int id, String type, int totalQuantity){
        super();
        this.id = id;
        this.type = type;
        this.totalQuantity = totalQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
