package com.myntra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myntra.entity.Orders;


public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
