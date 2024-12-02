package com.springboot.atstore.springboot_atstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.atstore.springboot_atstore.entities.Order;
import com.springboot.atstore.springboot_atstore.repositories.IOrderRepository;

@Service
public class OrderService {
    private final IOrderRepository orderRepository;

    public OrderService(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order saveOrder(Order order) {
        if (order.getStore() == null) {
            throw new IllegalArgumentException("Store must be specified for the order.");
        }
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    // public Optional<Order> findOrderWithDetailsById(Long id) {
    //     return orderRepository.findOrderWithDetailsById(id);
    // }

    public Optional<Order> findOrderWithDetailsById(Long id) {
        Optional<Order> order = orderRepository.findOrderWithDetailsById(id);
        if (order.isPresent()) {
            System.out.println("Order found: " + order.get());
        } else {
            System.out.println("Order not found for id: " + id);
        }
        return order;
    }

}
