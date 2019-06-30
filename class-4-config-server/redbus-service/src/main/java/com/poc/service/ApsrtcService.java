package com.poc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.poc.exception.CustomResponseErrorHandler;
import com.poc.model.Ticket;

@Service
public class ApsrtcService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	CustomResponseErrorHandler customResponseErrorHandler;

	@Value("${apsrtcUrl}")
	private String apsrtcUrl;


	public Ticket createTicket(Ticket ticket) {
		String url = new StringBuilder(apsrtcUrl).append("/create-bus-ticket").toString();
		restTemplate.setErrorHandler(customResponseErrorHandler);
		return restTemplate.postForObject(url, ticket, Ticket.class);
	}

	public void updateTicket(Ticket ticket, Long id) {
		String url = new StringBuilder(apsrtcUrl).append("/update-bus-ticket/").append(id).toString();
		restTemplate.setErrorHandler(customResponseErrorHandler);
		restTemplate.put(url, ticket);
	}

	public Ticket getTicketById(Long id) {
		String url = new StringBuilder(apsrtcUrl).append("/get-bus-ticket/").append(id).toString();
		restTemplate.setErrorHandler(customResponseErrorHandler);
		return restTemplate.getForObject(url, Ticket.class);
	}

	public List<Ticket> getAllTickets() {
		String url = new StringBuilder(apsrtcUrl).append("/get-All-tickets").toString();
		restTemplate.setErrorHandler(customResponseErrorHandler);
		return restTemplate.getForObject(url, List.class);
	}

	public void deleteTicketById(Long id) {
		String url = new StringBuilder(apsrtcUrl).append("/delete-bus-ticket/").append(id).toString();
		restTemplate.setErrorHandler(customResponseErrorHandler);
		restTemplate.delete(url);
	}

}
