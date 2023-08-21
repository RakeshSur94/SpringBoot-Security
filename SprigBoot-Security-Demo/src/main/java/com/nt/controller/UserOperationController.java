package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.module.User;
import com.nt.service.UserService;

@RestController
@RequestMapping("/user")
public class UserOperationController {
	@Autowired
	private UserService service;
	
	@GetMapping("/allUser")
	public ResponseEntity<List<User>> getAlluser(){
		return new ResponseEntity<List<User>>(service.getAlluser(), HttpStatus.OK);
	}
	
	@GetMapping("/single/{username}")
	public ResponseEntity<User> getSingleuser(@PathVariable("username") String username){
		return new ResponseEntity<User>(service.fetchsingleUser(username), HttpStatus.OK);
	}
	@PostMapping("/save")
	public ResponseEntity<User> saveAllusers(@RequestBody User user){
		return new ResponseEntity<User>(service.addUser(user), HttpStatus.CREATED);
	}

}
