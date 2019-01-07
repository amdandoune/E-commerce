package com.student.cart.shipping;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShippingRepository extends CrudRepository<Shipping, Integer> {
    public List<Shipping> findByCustomerId(int customerId);
}
