package it.sisalpay.ticketservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.sisalpay.ticketservice.model.Ticket;
import it.sisalpay.ticketservice.service.TicketService;

@RestController
@RequestMapping("/junitspring")
public class TicketController {
	@Autowired
    private TicketService service;
 
    @RequestMapping("/")
    public String welcome() {
        return "Welcome to RestTemplate Example.";
    }
 
    // URL:
    // http://localhost:8080/junitspring/Tickets
    // http://localhost:8080/junitspring/Tickets.xml
    // http://localhost:8080/junitspring/Tickets.json
    @GetMapping(value = "/Tickets", //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<Ticket> getTickets() {
        List<Ticket> list = service.getAllTickets();
        return list;
    }
  
    // URL:
    // http://localhost:8080/junitspring/Tickets/{empNo}
    // http://localhost:8080/junitspring/Tickets/{empNo}.xml
    // http://localhost:8080/junitspring/Tickets/{empNo}.json
    @GetMapping(value = "/Tickets/{tickNo}", //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
 
    public Ticket getTicket(@PathVariable("tickNo") String tickNo) {
        return service.getTicket(tickNo);
    }
 
    // URL:
    // http://localhost:8080/junitspring/Tickets
    // http://localhost:8080/junitspring/Tickets.xml
    // http://localhost:8080/junitspring/Tickets.json
    @PostMapping(value = "/Tickets", //
            consumes = { MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public int addTicket(@RequestBody Ticket t) {
        return service.buyTicket(t.getPassengerName(), t.getPhone());
    }
}
