package com.myntra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myntra.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
