package com.example.demo.controller;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TicketEntity;
import com.example.demo.service.TicketService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("ticket")
public class TicketController {

	@Autowired
	private TicketService service;

	/*
	 * @PostMapping("book") public ResponseEntity<TicketDto> bookTicket(@RequestBody
	 * BookTicketRequestDto bookTicketRequestDto) {
	 * 
	 * log.info("Received Request to book ticket: " + bookTicketRequestDto);
	 * 
	 * return ResponseEntity.ok(ticketService.bookTicket(bookTicketRequestDto)); }
	 */
/*
	@GetMapping("{id}")
	public ResponseEntity<TicketEntity> getTicket(
			@PathVariable(name = "id") @Min(value = 1, message = "Ticket Id Cannot be -ve") long id) {

		log.info("Received Request to get ticket: " + id);

		return ResponseEntity.ok(service.getTicket(id));
	}
*/
	@DeleteMapping("delete/{tId}")
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable("tId") int tId) {
		service.deleteTicket(tId);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
}