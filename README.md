# Microservice-Class-One
Microservice-Class-One



steps to develop eureka server
==============================

All the micro services are regiter into eureka server for communicating each other.

Group id
com.poc


Artifact id
eureka-server

Selected dependencies
=========================
spring boot dev tool

spring eureka server

click on genereate project

after genereating the project import into eclipse;



step2:
Enable eureka server by adding below annotation in spring boot class level



@EnableEurekaServer

example:
SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}

step3:
Add below information in application.properties file

By default all eureka server register all micro service it self.



eureka.client.registerWithEureka = false
eureka.client.fetchRegistry = false
server.port = 8761


step4:
======

Step to add the enable eureka client in micro service
example:


apsrts-service
=============
4.1 add below dependencies in pom.xml file
<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>
		
		
		
		
4.2: Enable eureka client by adding below annotation
     @EnableEurekaClient
	 
	 
	 
examplecode




@SpringBootApplication
@EnableEurekaClient
public class ApsrtcServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApsrtcServiceApplication.class, args);
	}

}





4.3:add below information in application.properties

for connecting to eureka server add below information




eureka.client.serviceUrl.defaultZone  = http://localhost:8761/eureka


eureka.client.instance.preferIpAddress = true


========================================================
http://APSRTCSERVICE/create-bus-ticket is equal to below

http://localhost:9191/create-bus-ticket


flow of application

redbus to eureka

eureka to apsrtc

redbus->eureka-->apsrts














how to communicate one micro service to another micro service usinf feign clien
===============================================================================

Step1:

below dependencies in pom.xml
<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-openfeign</artifactId>
		</dependency>
		
		
step2:

Enable feign client in spring boot application leavel
example code:
=================

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class RedBusApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedBusApplication.class, args);
	}
	
step3:
=====

create interface with external api with defination
example:
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

feign client inbuilt support Ribbon loadbalancing.
