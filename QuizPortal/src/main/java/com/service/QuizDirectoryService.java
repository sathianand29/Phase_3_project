package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.QuizDirectory;
import com.repository.QuizDirectoryRepository;


@Service
public class QuizDirectoryService {
	
	@Autowired
	private QuizDirectoryRepository repo;
	
	//add method or CREATE RECORD
	public QuizDirectory addUser(QuizDirectory u) {
		return repo.save(u);
	}
	
	
	//List user Method
	public List<QuizDirectory> getAllUser(){
		return repo.findAll();
	}
	
	 

}