package com.student.cart.payment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @Column(name="ID")
    private int id;
    @Column(name="full_name")
    private String fullName;
    @Column(name="card_number")
    private String cardNum;
    @Column(name="cvc")
    private String cVCode;
    @Column(name="expiration_date")
    private String expiration;
    @Column(name="billing_address")
    private String billingAddress;
    @Column(name="total_payment")
    private double paymentTotal;

    public Payment(){

    }

    public Payment(int id, String fullName, String cardNum, String cVCode, String expiration, String billingAddress, double paymentTotal){
        super();
        this.id = id;
        this.fullName = fullName;
        this.cardNum = cardNum;
        this.cVCode = cVCode;
        this.expiration = expiration;
        this.billingAddress = billingAddress;
        this.paymentTotal = paymentTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getcVCode() {
        return cVCode;
    }

    public void setcVCode(String cVCode) {
        this.cVCode = cVCode;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public double getPaymentTotal() {
        return paymentTotal;
    }

    public void setPaymentTotal(double paymentTotal) {
        this.paymentTotal = paymentTotal;
    }
}
