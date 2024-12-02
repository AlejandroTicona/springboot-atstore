package com.springboot.atstore.springboot_atstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.atstore.springboot_atstore.entities.Store;
import com.springboot.atstore.springboot_atstore.repositories.IStoreRepository;

@Service
public class StoreService {
    private final IStoreRepository storeRepository;

    public StoreService(IStoreRepository storeRepository) {
        this.storeRepository = storeRepository;
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
        storeRepository.deleteById(id);

    }
}
