package com.example.demo.service;

import com.example.demo.entity.TicketEntity;

public interface TicketService 
{
	public TicketEntity bookTicket(TicketEntity t);

	public TicketEntity getTicket(long id);
	
	public String deleteTicket(long id);
}
