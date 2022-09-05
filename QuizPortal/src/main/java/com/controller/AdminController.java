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

import com.entity.Admin;
import com.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/login")
	public String adminLogin(@RequestBody Admin a)
	{
		if(adminService.verifyAdmin(a.getEmail(), a.getPassword()))
		{
			return "Welcome Admin";
		}
		else
		{
			return "Invalid Credentials";
		}
	}
	
	
	
	@PostMapping("/changePassword/{id}&{newPassword}")
	public String changePassword(@PathVariable int id, @PathVariable String newPassword)
	{
		adminService.changePassword(id, newPassword);
		return "Password Changed Successfully";
	}
}