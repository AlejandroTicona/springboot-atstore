package com.springboot.atstore.springboot_atstore.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.atstore.springboot_atstore.entities.Store;
import com.springboot.atstore.springboot_atstore.services.StoreService;

@RestController
@RequestMapping("/api/stores")
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping()
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }

    @GetMapping("/{id}")
    public Optional<Store> getStoreById(@PathVariable Long id) {
        return storeService.getStoreById(id);
    }

    @PostMapping()
    public Store createStore(@RequestBody Store store) {
        return storeService.saveStore(store);
    }

    @PutMapping("/{id}")
    public Store updateStore(@PathVariable Long id, @RequestBody Store store) {
        store.setId(id);
        return storeService.saveStore(store);
    }

    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable Long id) {
        storeService.deleteStore(id);
    }
}
