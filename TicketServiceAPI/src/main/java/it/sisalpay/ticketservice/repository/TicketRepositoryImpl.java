package it.sisalpay.ticketservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import it.sisalpay.ticketservice.model.Ticket;

 
@Component
public class TicketRepositoryImpl implements TicketRepository {

	static int ticketCounter = 0;
	static List<Ticket> tickets = new ArrayList<>();
	
	@Override
	public int createTicket(Ticket ticket) {
		ticket.setTicketNo(++ticketCounter);
		tickets.add(ticket);
		return ticketCounter;
	}
	
	public Ticket read(int ticketId) {		
		return tickets.get(ticketId-1);
	}
	
	public List<Ticket> readAll() {		
		return tickets;
	}

}
