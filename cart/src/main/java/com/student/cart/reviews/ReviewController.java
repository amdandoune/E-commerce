package com.student.cart.reviews;

import com.student.cart.items.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @RequestMapping("/items/{iid}/reviews")/*@RequestMapping("/items/{iid}/reviews")*/
    public List<Review> getAllReviews(@PathVariable int iid){
        return reviewService.getAllReviews(iid);
    }

    @RequestMapping("/items/{iid}/reviews/{id}")/*@RequestMapping("/items/{iid}/reviews/{id}")*/
    public Review getReview(@PathVariable int id){
        return reviewService.getReview(id);
    }

    @RequestMapping( method= RequestMethod.POST, value="/items/{iid}/reviews")/*@RequestMapping("/items/{iid}/reviews")*/
    public void addReview(@RequestBody Review review, @PathVariable int iid){
        review.setItem(new Item(iid));
        reviewService.addReview(review);
    }

    @RequestMapping( method= RequestMethod.PUT, value="/items/{iid}/reviews/{id}")/*@RequestMapping("/items/{iid}/reviews/{id}")*/
    public void updateReview(@RequestBody Review review, @PathVariable int id, @PathVariable int iid){
        review.setItem(new Item(iid));
        review.setId(id);
        reviewService.updateReview(review);
    }

    @RequestMapping( method= RequestMethod.DELETE, value="/items/{iid}/reviews/{id}")/*@RequestMapping("/items/{iid}/reviews/{id}")*/
    public void deleteReview(@PathVariable int id){
        reviewService.deleteReview(id);
    }

    /////////////////////////

    @RequestMapping("/reviews")/*@RequestMapping("/items/{iid}/reviews")*/
    public List<Review> getAllReview(){
        return reviewService.getAllReview();
    }

    @RequestMapping( method= RequestMethod.POST, value="/reviews")/*@RequestMapping("/items/{iid}/reviews")*/
    public void addReview(@RequestBody Review review){
//        review.setItem(new Item(iid));
        reviewService.addReview(review);
    }

    @RequestMapping( method= RequestMethod.PUT, value="/reviews/{id}")/*@RequestMapping("/items/{iid}/reviews/{id}")*/
    public void updateReview(@RequestBody Review review, @PathVariable int id){
//        review.setItem(new Item(iid));
        review.setId(id);
        reviewService.updateReview(review);
    }

    @RequestMapping( method= RequestMethod.DELETE, value="/reviews/{id}")/*@RequestMapping("/items/{iid}/reviews/{id}")*/
    public void deleteReviews(@PathVariable int id){
        reviewService.deleteReview(id);
    }
}
