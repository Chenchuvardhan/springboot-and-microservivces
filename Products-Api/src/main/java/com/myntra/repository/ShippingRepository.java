package com.myntra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myntra.entity.ShippingAddress;

public interface ShippingRepository extends JpaRepository<ShippingAddress, Integer> {

}
