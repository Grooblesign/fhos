package uk.me.paulgarner.fh.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import uk.me.paulgarner.fh.domain.Person;
import uk.me.paulgarner.fh.service.PersonService;

@Model
public class PersonServiceDAO {

	@Inject
    private PersonService personService;
	
	private String test;
	
	public Person findById(long id) {
		return personService.find(id);
	}

	public String getTest() {
		Person person = findById(55287);
		
		if (null ==  person) {
			test = "Wibble";
		} else {
			test = person.getSurname();
		}
		
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
}
