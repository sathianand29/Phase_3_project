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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Question;
import com.entity.Participant;
import com.service.ParticipantService;



@RestController
@RequestMapping("/participant")
public class ParticipantController {
	
	@Autowired
	private ParticipantService service;
	
	//login
	@PostMapping("/login")
	public String adminLogin(@RequestBody Participant p)
	{
		if(service.verifyUser(p.getEmail(), p.getPassword()))
		{
			return "Welcome Participant";
		}
		else
		{
			return "Invalid Credentials";
		}
	}
	
	
	//add User
	@PostMapping("/addParticipant")
	public ResponseEntity<Participant> addUser(@RequestBody Participant u){
		Participant user= service.addUser(u);
		if(user!=null)  
			return new ResponseEntity<Participant>(user,HttpStatus.CREATED);
		else
			return new ResponseEntity<Participant>(user, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	//List of Users
	@GetMapping("/")
	public  List<Participant> getAllUser(){
		return service.getAllUser();
	}
	
	//get user by id
	@GetMapping("/{id}")
	public ResponseEntity<Participant> getUserById(@PathVariable int id){
		  Participant user= service.getUserById(id);
		  
		  if(user!=null)
			  return new ResponseEntity<Participant>(user,HttpStatus.FOUND);
		  else
			  return new  ResponseEntity<Participant>(user,HttpStatus.NOT_FOUND);
	}
	
}