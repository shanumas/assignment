package com.uma.assignment;

import com.uma.assignment.models.Person;
import com.uma.assignment.services.PersonService;

public class RequestHandler {
	private PersonService personService;

	public RequestHandler(PersonService personService) {
		this.personService = personService;
	}

	boolean handleRequest() {

		for (int count = 0; count < Operations.Operation.values().length; count++) {
			System.out.println("Press " + count + " for " + Operations.Operation.values()[count]);
		}
		System.out.println("Press \"q\" to quit");

		String c = System.console().readLine();

		switch (c) {
		case "0":
			add();
			break;
		case "1":
			edit();
			break;
		case "2":
			delete();
			break;
		case "3":
			count();
			break;
		case "4":
			break;
		case "q":
			// quit loop
			return false;
		default:
			System.out.println("Invalid choice");
			break;
		}
		printAll();
		// continue loop
		return true;

	}

	private void printAll() {
		System.out.println("Printing all elements:");
		int count = 1;
		for (Person person : personService.list()) {
			System.out.println("Person with id(" + count + "): FirstName: " + person.getfirstName() + " LastName: "
					+ person.getLastName());
			count++;
		}
		System.out.println("Press enter to continue...");
	}

	private void add() {
		System.out.println("Enter Firstname: ");
		String firstName = System.console().readLine();
		System.out.println("Enter Lastname: ");
		String lastName = System.console().readLine();
		personService.addPerson(new Person(firstName, lastName));
		System.out.println("Person :" + firstName + " " + lastName + " added successfully.");
	}

	private void edit() {
		System.out.println("Enter the id number to edit: ");
		String id = System.console().readLine();
		try {
			int number = Integer.parseInt(id);
			if (number > 0 && number <= personService.list().size()) {
				int recordNumberToDelete = number - 1;
				Person originalPerson = personService.list().get(recordNumberToDelete);
				System.out.println("Enter Firstname: ");
				String firstName = System.console().readLine();
				System.out.println("Enter Lastname: ");
				String lastName = System.console().readLine();
				originalPerson.setFirstName(firstName);
				originalPerson.setLastName(lastName);
				personService.editPerson(originalPerson);

			} else {
				System.out.println("This record number " + number + " does not exist");
			}

		} catch (NumberFormatException e) {
			System.out.println("You made a wrong choice:");
		}
	}

	private void delete() {
		System.out.println("Enter the id number to delete: ");
		String id = System.console().readLine();
		try {
			int number = Integer.parseInt(id);
			if (number > 0 && number <= personService.list().size()) {
				Person personToDelete = personService.list().get(number - 1);
				personService.deletePerson(personToDelete);
			} else {
				System.out.println("This record number " + number + " does not exist");
			}

		} catch (NumberFormatException e) {
			System.out.println("You made a wrong choice:");
		}

	}
	
	private void count() {
		System.out.println("Total number of records are: "+personService.list().size());
	}

}
