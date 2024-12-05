package com.springboot.atstore.springboot_atstore.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.atstore.springboot_atstore.entities.Category;

public interface ICategoryRepository extends JpaRepository<Category, Long> {

}
