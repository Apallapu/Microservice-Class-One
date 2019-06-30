package com.poc.config;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.poc.model.Ticket;
@FeignClient(name = "APSRTCSERVICE")
public interface RedBusClient {
	
	@PostMapping("/create-bus-ticket")
	public Ticket createTicket(@RequestBody Ticket ticket);

	@PutMapping("/update-bus-ticket/{id}")
	public Ticket updateTicket(@RequestBody Ticket ticket, @PathVariable Long id);

	@GetMapping("/get-bus-ticket/{id}")
	public Ticket getTicketById(@PathVariable Long id);

	@GetMapping("/get-All-tickets")
	public List<Ticket> getAllTickets();

	@DeleteMapping("/delete-bus-ticket/{id}")
	public void deleteTicketById(@PathVariable Long id);

}
