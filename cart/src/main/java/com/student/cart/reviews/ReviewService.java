package com.student.cart.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReview(){
        List<Review> reviews = new ArrayList<>();
        reviewRepository.findAll().forEach(reviews::add);
        return reviews;
    }

    public List<Review> getAllReviews(int itemId){
        List<Review> reviews = new ArrayList<>();
        reviewRepository.findByItemId(itemId).forEach(reviews::add);
//        reviewRepository.findAll().forEach(reviews::add);
        return reviews;
    }

    public Review getReview(int id){
        return reviewRepository.findOne(id);
    }

    public void addReview(Review review){
        reviewRepository.save(review);
    }

    public void updateReview(Review review){
        reviewRepository.save(review);
    }

    public void deleteReview(int id){
        reviewRepository.delete(id);
    }


}
