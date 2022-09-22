package com.sony.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sony.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
