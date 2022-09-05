package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Ranking;
import com.service.RankingService;



@RestController
@RequestMapping("/ranking")
public class RankingController {
	
	@Autowired
	private RankingService service;
	
	//List of Users 
	@GetMapping("/")
	public  List<Ranking> getAllUser(){
		return service.getAllUser();
	}
	
	//get user score by id
	@GetMapping("/{id}")
	public ResponseEntity<Ranking> getUserById(@PathVariable int id){
		 Ranking user= service.getUserById(id);
		  
		  if(user!=null)
			  return new ResponseEntity<Ranking >(user,HttpStatus.FOUND);
		  else
			  return new  ResponseEntity<Ranking >(user,HttpStatus.NOT_FOUND);
	}
}
