package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TicketEntity;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService
{

	@Autowired
	TicketRepository dao;

	@Override
	public TicketEntity bookTicket(TicketEntity t) {
		return null;
	}

	@Override
	public TicketEntity getTicket(long id) {
		return this.dao.findById(id).orElse(null);
	}

	@Override
	public String deleteTicket(long id) {
		TicketEntity existsID = dao.findById(id).orElse(null);
		if (existsID != null) {
			dao.deleteById(id);
			return "Ticket deleted!!";
		} else {
			return "Ticket does not exist!!";
		}
	}
}
