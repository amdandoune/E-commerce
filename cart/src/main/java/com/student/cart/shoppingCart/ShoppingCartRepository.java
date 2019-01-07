package com.student.cart.shoppingCart;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Integer> {
    public List<ShoppingCart> findByCustomerId(int customerId);
}
