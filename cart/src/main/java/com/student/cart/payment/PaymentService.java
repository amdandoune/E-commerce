package com.student.cart.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments(){
        List<Payment> payments = new ArrayList<>();
        paymentRepository.findAll().forEach(payments::add);
        return payments;
    }

    public Payment getPayment(int id){
        return paymentRepository.findOne(id);
    }

    public void addPayment(Payment payment){
        paymentRepository.save(payment);
    }

    public void updatePayment(Payment payment){
        paymentRepository.save(payment);
    }

    public void deletePayment(int id){
        paymentRepository.delete(id);
    }

}
