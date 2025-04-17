package com.myntra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myntra.entity.Products;

public interface ProductRepository extends JpaRepository<Products, Integer> {

}
