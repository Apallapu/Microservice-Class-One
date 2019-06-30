package com.poc.config;

import java.util.List;

import org.springframework.stereotype.Component;

import com.poc.model.Ticket;

@Component
public class RedBusClientFallback implements RedBusClient {

	@Override
	public Ticket createTicket(Ticket ticket) {
		Ticket ticket2 = new Ticket();
		ticket2.setCost(123);
		ticket2.setName("name");
		ticket2.setTicket_from("ticket_from");
		ticket2.setTicket_to("ticket_to");
		ticket2.setTicketId(123l);
		return ticket2;
	}

	@Override
	public Ticket updateTicket(Ticket ticket, Long id) {
		Ticket ticket2 = new Ticket();
		ticket2.setCost(123);
		ticket2.setName("name");
		ticket2.setTicket_from("ticket_from");
		ticket2.setTicket_to("ticket_to");
		ticket2.setTicketId(123l);
		return ticket2;
	}

	@Override
	public Ticket getTicketById(Long id) {
		Ticket ticket2 = new Ticket();
		ticket2.setCost(123);
		ticket2.setName("name");
		ticket2.setTicket_from("ticket_from");
		ticket2.setTicket_to("ticket_to");
		ticket2.setTicketId(123l);
		return ticket2;
	}

	@Override
	public List<Ticket> getAllTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTicketById(Long id) {
		// TODO Auto-generated method stub

	}

}
