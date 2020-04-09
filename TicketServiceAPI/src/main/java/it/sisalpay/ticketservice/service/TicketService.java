package it.sisalpay.ticketservice.service;

import java.util.List;

import it.sisalpay.ticketservice.model.Ticket;

public interface TicketService {

	int buyTicket(String passengerName, String phone);

	Ticket getTicket(String tickNo);

	List<Ticket> getAllTickets();
	
}
