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



http://APSRTCSERVICE/create-bus-ticket is equal to below

http://localhost:9191/create-bus-ticket


flow of application

redbus to eureka

eureka to apsrtc

redbus->eureka-->apsrts
