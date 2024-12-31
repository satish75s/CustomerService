package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import com.customer.entity.Customer;
import com.customer.service.CustomerService;

@RestController
@RequestMapping
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer) {

		return customerService.addCustomer(customer);
	}
	@GetMapping("/searchByEmail/{email}")
	public Customer customerByEmail(@PathVariable String email) {
		return customerService.customerByEmail(email);
	}
	@GetMapping("/searchByName/{name}")
	public Customer customerByName(@PathVariable String name) {
		return customerService.customerByName(name);
	}
	
	@GetMapping("/pagination/{offset}/{pageSize}")
	private ResponseEntity<Page<Customer>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Customer> productsWithPagination = customerService.findCustomersWithPagination(offset, pageSize);
        return new ResponseEntity<>(productsWithPagination,HttpStatus.ACCEPTED);
    }
	
	@GetMapping("/SortByField/{field}")
	public List<Customer> customerSortByField(@PathVariable String field) {
		return customerService.customerSortByField(field);
	}
	
	@GetMapping("/PaginationSortByField/{pageNumber}/{pageSize}/{field}")
	public Page<Customer> findCustomerssWithPaginationAndSorting(@PathVariable int pageNumber, @PathVariable int pageSize, @PathVariable String field) {
		Page<Customer> customes = customerService.findCustomerssWithPaginationAndSorting(pageNumber, pageSize, field);
		return customes;
	}
	
	
	


}
