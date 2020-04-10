package it.sisalpay.ticketservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sisalpay.ticketservice.model.Ticket;
import it.sisalpay.ticketservice.repository.TicketRepository;


@Component
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository repository;
	
	@Autowired
	private TicketMessageProducer messageProducer;
	
	@Override
	public int buyTicket(String passengerName, String phone) {		
		Ticket ticket = new Ticket();
		ticket.setPassengerName(passengerName);
		ticket.setPhone(phone);
		
		//invio la notifica sulla coda (ovviamente ANDREBBE fatto in maniera transazionale con createTicket)
		messageProducer.produceTicketMessage(ticket);
		//persisto sul dao
		return repository.createTicket(ticket);
	}

	public TicketRepository getRepository() {
		return repository;
	}

	public void setDao(TicketRepository repository) {
		this.repository = repository;
	}

	@Override
	public Ticket getTicket(String tickNo) {
		return repository.read(new Integer(tickNo));
	}

	@Override
	public List<Ticket> getAllTickets() {		
		return repository.readAll();
	}

}
