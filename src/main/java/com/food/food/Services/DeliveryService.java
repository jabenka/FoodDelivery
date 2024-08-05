package com.food.food.Services;

import com.food.food.Models.DeliveryForm;
import com.food.food.Repositories.DeliveryFormRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {
    private final DeliveryFormRepository orderRepository;
    @Autowired
    public DeliveryService(DeliveryFormRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addOrder(DeliveryForm order) {
       orderRepository.save(order);
       orderRepository.flush();
    }
    public List<DeliveryForm> getOrders() {
        List<DeliveryForm> orders = orderRepository.findAll();
        return orders;
    }
    public DeliveryForm getOrder(long id) {
        return orderRepository.findById(id).orElse(null);
    }





}
