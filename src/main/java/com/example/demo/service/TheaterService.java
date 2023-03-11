package com.example.demo.service;

import com.example.demo.entity.TheaterEntity;

public interface TheaterService 
{
	public TheaterEntity addTheater(TheaterEntity t);

	public TheaterEntity getTheater(long id);
}
