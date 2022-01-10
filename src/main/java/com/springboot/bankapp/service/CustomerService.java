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

@Service
public class CustomerService  {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
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
		role= roleRepository.save(role);
		//create List of Role 
		List<Role> list = new ArrayList<>();
		list.add(role);
		
		//attach the role list to user 
		
		user.setRoles(list);
		customer.setUserInfo(user);
		
		return customerRepository.save(customer);
	}

}
