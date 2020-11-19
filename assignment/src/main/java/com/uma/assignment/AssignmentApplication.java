package com.uma.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uma.assignment.Operations.Operation;
import com.uma.assignment.models.Person;
import com.uma.assignment.repositories.PersonRepository;
import com.uma.assignment.services.PersonService;

@SpringBootApplication
public class AssignmentApplication implements CommandLineRunner {
	
	@Autowired
	PersonService personService;

	private static Logger LOG = LoggerFactory.getLogger(AssignmentApplication.class);

	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(AssignmentApplication.class, args);
		LOG.info("APPLICATION FINISHED");
	}

	@Override
	public void run(String... args) {
		LOG.info("EXECUTING : command line runner");
		
		RequestHandler requestHandler = new RequestHandler(personService);
		
		System.out.println("Press Enter to start, \"q\" to quit");
		while(!System.console().readLine().equals("q"))
		{
			//continue loop until q is pressed
			if(!requestHandler.handleRequest())
			{
				break;
			}
			
		}		
	}

}
