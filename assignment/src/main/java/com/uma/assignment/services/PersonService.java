package com.uma.assignment.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uma.assignment.models.Person;
import com.uma.assignment.repositories.PersonRepository;

@Service
public class PersonService {	
	
	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> list(){
		return personRepository.findAll();
	}
	
	public void addPerson(Person person)
	{
		personRepository.save(person);
	}
	
	public void deletePerson(Person person)
	{
		personRepository.delete(person);
	}
	
	public void editPerson(Person person)
	{
		personRepository.save(person);
	}
	

}
