package it.sisalpay.ticketservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sisalpay.ticketservice.model.Ticket;
import it.sisalpay.ticketservice.repository.TicketRepository;


@Component
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository dao;
	
	@Override
	public int buyTicket(String passengerName, String phone) {		
		Ticket ticket = new Ticket();
		ticket.setPassengerName(passengerName);
		ticket.setPhone(phone);
		return dao.createTicket(ticket);
	}

	public TicketRepository getDao() {
		return dao;
	}

	public void setDao(TicketRepository dao) {
		this.dao = dao;
	}

	@Override
	public Ticket getTicket(String tickNo) {
		return dao.read(new Integer(tickNo));
	}

	@Override
	public List<Ticket> getAllTickets() {		
		return dao.readAll();
	}

}
