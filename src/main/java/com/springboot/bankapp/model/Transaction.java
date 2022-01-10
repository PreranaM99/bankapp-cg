package com.springboot.bankapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String accountFrom;
	
	@Column(nullable = false)
	private String accountTo;
	
	@Column(nullable = false)
	private String operationType;
	
	@Column(nullable = false)
	private double amount;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfTransaction;
	
	

}
