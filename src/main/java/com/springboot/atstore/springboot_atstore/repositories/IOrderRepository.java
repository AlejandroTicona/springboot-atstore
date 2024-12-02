package com.springboot.atstore.springboot_atstore.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.atstore.springboot_atstore.entities.Order;

public interface IOrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o JOIN FETCH o.detailsOrders WHERE o.id = :id")
    Optional<Order> findOrderWithDetailsById(@Param("id") Long id);
}
