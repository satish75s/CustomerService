package com.customer.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
  
public Customer(String name, String contact, String email, Date dop, boolean isCustomer, double amount) {
		super();
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.dop = dop;
		this.isCustomer = isCustomer;
		this.amount = amount;
	}
@Id	
  @GeneratedValue
  private int id;
  private String name;
  private String contact;
  private String email;
  @JsonFormat(pattern="dd/MM/yyyy")
  private Date dop;
  private boolean isCustomer;
  private double amount;
}
