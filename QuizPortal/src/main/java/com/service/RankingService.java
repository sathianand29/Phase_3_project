package com.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Ranking;
import com.repository.RankingRepository;


@Service
public class RankingService {
	
	@Autowired
	private RankingRepository repo;
	
	
	//List user Method
	public List<Ranking> getAllUser(){
		return repo.findAll();
	}
	
	//get user by id
	public Ranking getUserById(int id) {
		if(repo.findById(id).isPresent()) 
			return repo.findById(id).get();
		else 
			return null;
		
	}
}