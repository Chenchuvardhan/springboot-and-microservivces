package com.myntra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myntra.entity.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

}
