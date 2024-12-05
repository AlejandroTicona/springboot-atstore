package com.springboot.atstore.springboot_atstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.atstore.springboot_atstore.entities.Order;
import com.springboot.atstore.springboot_atstore.entities.Store;
import com.springboot.atstore.springboot_atstore.repositories.IOrderRepository;
import com.springboot.atstore.springboot_atstore.repositories.IStoreRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StoreService {
    private final IStoreRepository storeRepository;
    private final IOrderRepository orderRepository;

    public StoreService(IStoreRepository storeRepository, IOrderRepository orderRepository) {
        this.storeRepository = storeRepository;
        this.orderRepository = orderRepository;
    }

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    public Optional<Store> getStoreById(Long id) {
        return storeRepository.findById(id);
    }

    public Store saveStore(Store store) {
        return storeRepository.save(store);
    }

    public void deleteStore(Long id) {
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Store not found with id: " + id));

        List<Order> orders = orderRepository.findByStoreId(id);
        for (Order order : orders) {
            order.setStore(null);
            orderRepository.save(order);
        }

        // Ahora elimina la tienda
        storeRepository.delete(store);
    }
}
