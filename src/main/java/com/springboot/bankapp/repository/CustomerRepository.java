package com.springboot.bankapp.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.springboot.bankapp.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	@Transactional
	@Modifying
	@Query("update Customer c SET c.address=?1, c.city=?2 where c.id=?3")
	void putCustomer(String address, String city,Long id);

}