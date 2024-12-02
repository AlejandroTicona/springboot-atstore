package com.springboot.atstore.springboot_atstore.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.atstore.springboot_atstore.entities.DetailsOrder;
import com.springboot.atstore.springboot_atstore.services.DetailsOrderService;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/details_orders")
public class DetailsOrderController {
    private final DetailsOrderService detailsOrderService;

    public DetailsOrderController(DetailsOrderService detailsOrderService) {
        this.detailsOrderService = detailsOrderService;
    }

    @GetMapping()
    public List<DetailsOrder> getAllDetailsOrders() {
        return detailsOrderService.getAllDetailsOrders();
    }

    @GetMapping("/{id}")
    public Optional<DetailsOrder> getDetailsOrderById(@PathVariable Long id) {
        return detailsOrderService.getDetailsOrderById(id);
    }

    @PostMapping()
    public DetailsOrder createDetailsOrder(@RequestBody DetailsOrder detailsOrder) {
        return detailsOrderService.saveDetailsOrder(detailsOrder);
    }

    @PutMapping("/{id}")
    public DetailsOrder updateDetailsOrder(@PathVariable Long id, @RequestBody DetailsOrder detailsOrder) {
        detailsOrder.setId(id);
        return detailsOrderService.saveDetailsOrder(detailsOrder);
    }

    @DeleteMapping("/{id}")
    public void deleteDetailsOrder(@PathVariable Long id) {
        detailsOrderService.deleteDetailsOrder(id);
    }

}
