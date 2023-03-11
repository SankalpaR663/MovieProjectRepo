package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TheaterEntity;
import com.example.demo.service.TheaterService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/theater")
public class TheaterController 
{

	@Autowired
	TheaterService service;

	@PostMapping("/addTheater")
	public ResponseEntity<TheaterEntity> addtheater(@Valid @RequestBody TheaterEntity t) {

		return new ResponseEntity<TheaterEntity>(service.addTheater(t), HttpStatus.CREATED);
	}

	@GetMapping("find/{tid}")
	public ResponseEntity<TheaterEntity> getTheaterById(@PathVariable("tid") long tid) {
		return new ResponseEntity<TheaterEntity>(service.getTheater(tid), HttpStatus.OK);
	}
}