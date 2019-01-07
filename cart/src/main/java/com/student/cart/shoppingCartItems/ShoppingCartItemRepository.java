package com.student.cart.shoppingCartItems;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShoppingCartItemRepository extends CrudRepository<ShoppingCartItem, Integer> {
    public List<ShoppingCartItem> findByShoppingCartId(int sid);
}
