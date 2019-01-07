package com.student.cart.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {


    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/payments")
    public List<Payment> getAllPayments(){
        return paymentService.getAllPayments();
    }

    @RequestMapping("/payments/{id}")
    public Payment getPayment(@PathVariable int id){
        return paymentService.getPayment(id);
    }

    @RequestMapping( method= RequestMethod.POST, value="/payments")
    public void addPayment(@RequestBody Payment payment){
        paymentService.addPayment(payment);
    }

    @RequestMapping( method= RequestMethod.PUT, value="/payments/{id}")
    public void updatePayment(@RequestBody Payment payment, @PathVariable int id){
        payment.setId(id);
        paymentService.updatePayment(payment);
    }

    @RequestMapping( method= RequestMethod.DELETE, value="/payments/{id}")
    public void deletePayment(@PathVariable int id){
        paymentService.deletePayment(id);
    }
}
