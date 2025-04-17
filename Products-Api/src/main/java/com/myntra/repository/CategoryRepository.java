package com.myntra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myntra.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
