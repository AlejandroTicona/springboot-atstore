package com.springboot.atstore.springboot_atstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.atstore.springboot_atstore.entities.DetailsOrder;

public interface IDetailsOrderRepository extends JpaRepository<DetailsOrder, Long>{

}
