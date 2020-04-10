package it.sisalpay.ticketservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import it.sisalpay.ticketservice.model.Ticket;

@Component
public class TicketMessageProducer {

	@Autowired
	ApplicationContext context;

	public void produceTicketMessage(Ticket ticket) {
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		// Send a message with a POJO - the template reuse the message converter
		System.out.println("Sending a ticket Notification.");
		jmsTemplate.convertAndSend("ticketQueue", ticket);
	}

}
