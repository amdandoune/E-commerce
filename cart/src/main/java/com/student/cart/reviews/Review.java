package com.student.cart.reviews;

import com.student.cart.items.Item;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @Column(name="ID")
    private int id;
    @Column(name="nick_name")
    private String nickName;
    @Column(name="rating")
    private int rating;
    @Column(name="review")
    private String review;
//    private String articleID;

    @ManyToOne
    private Item item;

    public Review(){}

    public Review(int id, int articleID, String nickName, int rating, String review){
        super();
        this.id = id;
        this.item = new Item(articleID);
        this.nickName = nickName;
        this.rating = rating;
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
