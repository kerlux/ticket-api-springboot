package it.sisalpay.ticketservice.repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;

import it.sisalpay.ticketservice.model.Ticket;

 
@Component
public class TicketRepositoryImpl implements TicketRepository {

	static int ticketCounter = 0;
	static List<Ticket> tickets = new CopyOnWriteArrayList<>();
	
	@Override
	public int createTicket(Ticket ticket) {
		//synchronized (ticket) {
			ticket.setTicketNo(++ticketCounter);
			tickets.add(ticket);
		//}
		return ticketCounter;
	}
	
	public Ticket read(int ticketId) {		
		return tickets.get(ticketId-1);
	}
	
	public List<Ticket> readAll() {		
		return tickets;
	}

}
