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

import com.entity.QuizDirectory;
import com.service.QuizDirectoryService;



@RestController
@RequestMapping("/QuizDirectory")
public class QuizDirectoryController {
	
	@Autowired
	private QuizDirectoryService service;
	
	///create new record
	@PostMapping("/")
	public ResponseEntity<QuizDirectory> addUser(@RequestBody QuizDirectory u){
		QuizDirectory user= service.addUser(u);
		if(user!=null)  
			return new ResponseEntity<QuizDirectory>(user,HttpStatus.CREATED);
		else
			return new ResponseEntity<QuizDirectory>(user, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//List of Users Or RETRIVE DATA
	@GetMapping("/getAllQuizzes")
	public  List<QuizDirectory> getAllUser(){
		return service.getAllUser();
	}
	
	 
}