package com.student.cart.shipping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShippingService {

    @Autowired
    private ShippingRepository shippingRepository;

    public List<Shipping> getAllShippings(int cid){
        List<Shipping> shippings = new ArrayList<>();
        shippingRepository.findByCustomerId(cid).forEach(shippings::add);
//        shippingRepository.findAll().forEach(shippings::add);
        return shippings;
    }

    public Shipping getShipping(int id){
        return shippingRepository.findOne(id);
    }

    public void addShipping(Shipping shipping){
        shippingRepository.save(shipping);
    }

    public void updateShipping(Shipping shipping){
        shippingRepository.save(shipping);
    }

    public void deleteShipping(int id){
        shippingRepository.delete(id);
    }


}
