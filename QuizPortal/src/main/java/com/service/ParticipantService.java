package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Question;
import com.repository.ParticipantRepository;
import com.entity.Participant;


@Service

public class ParticipantService {
	@Autowired
	private ParticipantRepository userRepository;
	
	public Boolean verifyUser(String email, String password)
	{
		List<Participant> users = userRepository.findAll();
		
		for(Participant user : users)
		{
			if(user.getEmail().equals(email) && user.getPassword().equals(password)) 
			{ 
				return true;
			}
		}
		return false;
	}
	
	//add User
	public Participant addUser(Participant u) {
		return userRepository.save(u);
	}
	
	//List user Method
	public List<Participant> getAllUser(){
		return userRepository.findAll();
	}
	
	//get user by id
	public Participant getUserById(int id) {
		if(userRepository.findById(id).isPresent()) 
			return userRepository.findById(id).get();
		else 
			return null;
		
	}
	

}
