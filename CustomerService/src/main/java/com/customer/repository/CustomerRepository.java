package com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.customer.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	@Query("SELECT u FROM Customer u WHERE u.name = ?1")
	public Customer customerByName(String name);
	@Query("SELECT u FROM Customer u WHERE u.email = ?1")
	public Customer customerByEmail(String email);
}
