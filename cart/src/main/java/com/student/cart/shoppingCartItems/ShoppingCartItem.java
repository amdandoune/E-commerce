package com.student.cart.shoppingCartItems;

import com.student.cart.items.Item;
import com.student.cart.shoppingCart.ShoppingCart;

import javax.persistence.*;

@Entity
@Table( name = "shoppingcartitem")
public class ShoppingCartItem {

	@Id
    @Column(name="ID")
    private int id;
    @Column(name="quantity")
    private int quantity;
    @Column(name="total")
    private double total;
    
    @ManyToOne
    private ShoppingCart shoppingCart;
    @ManyToOne
    private Item item;
    
    public ShoppingCartItem(){}

    public ShoppingCartItem(int id, int sid, int  itemId, int quantity, double total){
        super();
        this.id = id;
        this.shoppingCart = new ShoppingCart( sid);
        this.item = new Item(itemId);
        this.quantity = quantity;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
