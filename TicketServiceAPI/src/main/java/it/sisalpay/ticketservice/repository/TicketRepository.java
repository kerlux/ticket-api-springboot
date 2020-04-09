package it.sisalpay.ticketservice.repository;

import java.util.List;

import it.sisalpay.ticketservice.model.Ticket;


public interface TicketRepository {

	public int createTicket(Ticket ticket);
	public Ticket read(int ticketNo);
	public List<Ticket> readAll();
}
