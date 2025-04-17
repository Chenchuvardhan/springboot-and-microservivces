package com.myntra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myntra.entity.OrderItems;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer> {

}
