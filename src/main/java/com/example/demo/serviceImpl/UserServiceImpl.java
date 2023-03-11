package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	UserRepository dao;
	
	@Override
	public UserEntity addUser(UserEntity user)
	{
		System.out.println("Movie added successfully" +user);
		user.setName(user.getName());
		user.setMobile(user.getMobile());
		user.setEmail(user.getEmail());
		user.setPassword(user.getPassword());
		user.setTicketEntities(user.getTicketEntities());
		return dao.save(user);
	}

	@Override
	public List<UserEntity> getAllUser() 
	{
		return dao.findAll();
	}

	@Override
	public UserEntity getUserById(long id)
	{
		return this.dao.findById(id).orElse(null);
	}

	@Override
	public UserEntity updateUser(UserEntity user) 
	{
		UserEntity existingUser = dao.findById(user.getId()).orElse(null);
		
		existingUser.setName(user.getName());
		existingUser.setMobile(user.getMobile());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		existingUser.setTicketEntities(user.getTicketEntities());
		
		return dao.save(existingUser);
	}

	@Override
	public String deleteUser(long id) 
	{
		UserEntity existsID = dao.findById(id).orElse(null);
		if(existsID != null)
		{
			dao.deleteById(id);
			return "User deleted!!";
		}
		else
		{
			return "User does not exists!!";
		}
	}

}
