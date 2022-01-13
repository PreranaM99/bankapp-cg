package com.springboot.bankapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.bankapp.model.Account;
import com.springboot.bankapp.model.Customer;
import com.springboot.bankapp.model.Role;
import com.springboot.bankapp.model.UserInfo;
import com.springboot.bankapp.repository.CustomerRepository;
import com.springboot.bankapp.repository.RoleRepository;
import com.springboot.bankapp.repository.UserRepository;

@Service
public class CustomerService  {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Customer postcustomer(Customer customer) {
		//generate 10 digit account number
		Random random = new Random();
		int temp = random.nextInt(99999);
		String accountNo = "MSB91"+temp;
		
		Account account = new Account();
		
		//prepare account with account no,initial balance,date of opening
		
		account.setAccountNumber(accountNo);
		account.setBalance(100);
		account.setDateOfOpening(new Date());
		customer.setAccount(account);
		
		//encode the password given and attach to customer 
		String encodePass= passwordEncoder.encode(customer.getUserInfo().getPassword());
		
		UserInfo user =new UserInfo();
		user.setUsername(customer.getUserInfo().getUsername());
		user.setPassword(encodePass);
		
		//create a Role and insert it in DB
		Role role = new Role();
		role.setName("USER");
		
		user.setRole(role);
		customer.setUserInfo(user);
		
		return customerRepository.save(customer);
	}

	public Customer getCustomerById(Long id) {

		return customerRepository.getById(id);
	}

	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);	
	}

	public UserInfo getUserByName(String name) {
		return userRepository.findByUsername(name);
	}

	public void putCustomer(String address, String city,Long id) {
	customerRepository.putCustomer(address,city,id);
	}
	public Customer findByid(Long id) {
		return customerRepository.getById(id);
	}
	

}
