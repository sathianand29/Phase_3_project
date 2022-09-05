package com.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Quiz;
import com.repository.QuizRepository;


@Service
public class QuizService {
	
	@Autowired
	private QuizRepository repo;
	
	//add method or CREATE RECORD
	public Quiz addUser(Quiz u) {
		return repo.save(u);
	}
	
	
	//List user Method
	public List<Quiz> getAllUser(){
		return repo.findAll();
	}
	
	//get user by id
	public Quiz getUserById(int id) {
		if(repo.findById(id).isPresent()) 
			return repo.findById(id).get();
		else 
			return null;
	
	}
	}