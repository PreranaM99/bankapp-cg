package com.springboot.bankapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bankapp.model.Account;
import com.springboot.bankapp.model.Transaction;
import com.springboot.bankapp.repository.TransactionRepository;
import com.springboot.bankapp.repository.UserRepository;

@Service
public class TransactionService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public String fetchFromAccountNumber(String username) {
	
		return userRepository.fetchFromAccountNumber(username);
	}

	public void updateBalance(String fromAccountNumber, double amount) {
		userRepository.updateBalance(fromAccountNumber,amount);
	}

	public void creditAmount(String toAccountNumber, double amount) {
		userRepository.creditAmount(toAccountNumber,amount);
	
	}

	public Transaction saveTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	public List<Transaction> fetchTransactionsByAccountNumber(String accountNumber) {
		return transactionRepository.fetchTransactionsByAccountNumber(accountNumber);
	}

	public void depositAmount(String accountNumber, double amount) {
		transactionRepository.depositAmount(accountNumber, amount);
	}

	public Account getAccountByAccountNumber(String accountNumber) {
		return transactionRepository.getAccountByAccountNumber(accountNumber);
	}

}
