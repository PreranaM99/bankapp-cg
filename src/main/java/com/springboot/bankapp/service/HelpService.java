package com.springboot.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bankapp.model.Help;
import com.springboot.bankapp.repository.HelpRepository;

@Service
public class HelpService {

	@Autowired
	private HelpRepository helpRepository;

	public Help postQandA(Help help) {
		help.setQuestion(help.getQuestion());
		help.setAnswer(help.getAnswer());
		
		return helpRepository.save(help);
	}

	public Help getQandAById(Long id) {
		return helpRepository.getById(id);
	}

	public List<Help> findAll() {
		return helpRepository.findAll();
	}


}
