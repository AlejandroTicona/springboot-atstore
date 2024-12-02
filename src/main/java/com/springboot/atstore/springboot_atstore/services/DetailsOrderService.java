package com.springboot.atstore.springboot_atstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.atstore.springboot_atstore.entities.DetailsOrder;
import com.springboot.atstore.springboot_atstore.repositories.IDetailsOrderRepository;

@Service
public class DetailsOrderService {
    private final IDetailsOrderRepository detailsOrderRepository;

    public DetailsOrderService(IDetailsOrderRepository detailsOrderRepository) {
        this.detailsOrderRepository = detailsOrderRepository;
    }

    public List<DetailsOrder> getAllDetailsOrders() {
        return detailsOrderRepository.findAll();
    }

    public Optional<DetailsOrder> getDetailsOrderById(Long id) {
        return detailsOrderRepository.findById(id);
    }

    public DetailsOrder saveDetailsOrder(DetailsOrder detailsOrder) {
        if (detailsOrder.getOrder() == null || detailsOrder.getProduct() == null) {
            throw new IllegalArgumentException("Order and Product must be provided.");
        }
        return detailsOrderRepository.save(detailsOrder);
    }

    public void deleteDetailsOrder(Long id) {
        if (!detailsOrderRepository.existsById(id)) {
            throw new IllegalArgumentException("DetailsOrder with id " + id + " does not exist.");
        }
        detailsOrderRepository.deleteById(id);
    }

}
