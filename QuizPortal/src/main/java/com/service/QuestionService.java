package com.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Question;
import com.repository.QuestionRepository;


@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository repo;
	
	//add method or CREATE RECORD
	public Question addUser(Question u) {
		return repo.save(u);
	}
	
	
	//List user Method
	public List<Question> getAllUser(){
		return repo.findAll();
	}
	
	//get user by id
	public Question getUserById(int id) {
		if(repo.findById(id).isPresent()) 
			return repo.findById(id).get();
		else 
			return null;
		
	}
	//update user by id
	public  Question updateUser(Question user, int id) {
		
		if(repo.findById(id).isPresent())
		{
			Question old= repo.findById(id).get();
			old.setOptionA(user.getOptionA());
			old.setOptionB(user.getOptionB());
			old.setOptionC(user.getOptionC());
			old.setOptionD(user.getOptionD());
			old.setAnswer(user.getAnswer());
			
			
			return repo.save(old);
		}
		else
		{
			return null;
		}
		
	}
	
	///DELETE USER BY ID
	public boolean deleteUser(int id) {
		
		if(repo.findById(id).isPresent())
		{
			repo.deleteById(id);
			return true;
		}
		else
			return false;
	}

}