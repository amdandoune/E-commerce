package com.student.cart.reviews;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
    public List<Review> findByItemId(int itemId);
}
