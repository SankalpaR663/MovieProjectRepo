package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
public class UserController 
{
	@Autowired
	private UserService service;
		
		@PostMapping("/adduser")
		public ResponseEntity<UserEntity> addUser(@Valid @RequestBody UserEntity user) {

			return new ResponseEntity<UserEntity>(service.addUser(user), HttpStatus.CREATED);
		}
		@GetMapping("/list")
		public List<UserEntity> getAllUser() {
			return service.getAllUser();
		}

		@GetMapping("find/{userid}")
		public ResponseEntity<UserEntity> getUserById(@PathVariable("userid") int userid) {
			return new ResponseEntity<UserEntity>(service.getUserById(userid), HttpStatus.OK);
		}
		@PutMapping("update")
		public ResponseEntity<UserEntity> updateUser(@Valid  @RequestBody UserEntity user) {
			return new ResponseEntity<UserEntity>(service.updateUser(user),HttpStatus.OK);
		}

		@DeleteMapping("delete/{userid}")
		public ResponseEntity<Boolean> deleteUser(@PathVariable("userid") int userid) {
			service.deleteUser(userid);
			boolean flag = true;
			return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
		}
	}