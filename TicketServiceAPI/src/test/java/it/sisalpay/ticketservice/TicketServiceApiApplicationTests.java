package it.sisalpay.ticketservice;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import it.sisalpay.ticketservice.model.Ticket;
import it.sisalpay.ticketservice.repository.TicketRepository;
import it.sisalpay.ticketservice.service.TicketServiceImpl;

@SpringBootTest
class TicketServiceApiApplicationTests {

	
	@Mock
	TicketRepository repository;
	
	@Autowired
	@InjectMocks
	TicketServiceImpl ticketService;
	
	@BeforeTestClass
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void shouldGetSuccessiveTicketNumber() {
		
		when(repository.createTicket(any(Ticket.class))).thenReturn(1);
		
		int firstTicketNumber = ticketService.buyTicket("Luigi", "1234");
		
		when(repository.createTicket(any(Ticket.class))).thenReturn(2);
		int secondTicketNumber = ticketService.buyTicket("Francesco", "1234");
		
		assertTrue(secondTicketNumber == firstTicketNumber + 1, () -> "Il biglietto comprato dopo ha il numero successivo");

	}
}
