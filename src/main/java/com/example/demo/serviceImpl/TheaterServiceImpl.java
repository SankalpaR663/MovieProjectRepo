package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TheaterEntity;
import com.example.demo.repository.TheaterRepository;
import com.example.demo.service.TheaterService;

@Service
public class TheaterServiceImpl implements TheaterService
{

	@Autowired
	TheaterRepository repo;

	@Override
	public TheaterEntity addTheater(TheaterEntity t) {
		t.setName(t.getName());
		t.setType(t.getType());
		t.setCity(t.getCity());
		t.setAddress(t.getAddress());
        t.setShows(t.getShows());
        t.setSeats(t.getSeats());
      
		return repo.save(t);
	}

	@Override
	public TheaterEntity getTheater(long id) {
		return this.repo.findById(id).orElse(null);

	}
}
