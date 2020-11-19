package com.uma.assignment.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "PERSON")
public class Person {
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	private String firstName;
	private String lastName;
	
	public Person() {
		
	}
	
	public Person(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getfirstName()
	{
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
}
