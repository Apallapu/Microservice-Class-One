package com.poc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.config.RedBusClient;
import com.poc.model.Ticket;

@Service
public class ApsrtcService {

	@Autowired
	RedBusClient redBusClient;

	public Ticket createTicket(Ticket ticket) {
		return redBusClient.createTicket(ticket);
	}

	public void updateTicket(Ticket ticket, Long id) {
		redBusClient.updateTicket(ticket, id);
	}

	public Ticket getTicketById(Long id) {

		return redBusClient.getTicketById(id);
	}

	public List<Ticket> getAllTickets() {

		return redBusClient.getAllTickets();
	}

	public void deleteTicketById(Long id) {

		redBusClient.deleteTicketById(id);
	}

}
