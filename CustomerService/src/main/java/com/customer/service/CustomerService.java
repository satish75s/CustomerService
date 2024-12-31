package com.customer.service;

import java.util.List;

//import org.springdoc.core.converters.models.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.customer.entity.Customer;
import com.customer.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer customerByEmail(String email) {
		return customerRepository.customerByEmail(email);
	}

	public Customer customerByName(String name) {
		return customerRepository.customerByName(name);
	}

	public Page<Customer> findCustomersWithPagination(int offset, int pageSize) {
		Page<Customer> customers = customerRepository.findAll(PageRequest.of(offset, pageSize));
		return customers;
	}

	// sort by field
	public List<Customer> customerSortByField(String field) {
		return customerRepository.findAll(Sort.by(Sort.Direction.ASC, field));
	}

	// pagination and sort by field
	public Page<Customer> findCustomerssWithPaginationAndSorting(int offset, int pageSize, String field) {
		Page<Customer> customes = customerRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
		return customes;
	}

}
