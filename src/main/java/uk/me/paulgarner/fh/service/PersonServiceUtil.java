package uk.me.paulgarner.fh.service;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import uk.me.paulgarner.fh.domain.Person;

@ApplicationScoped
public class PersonServiceUtil {

	@Inject
    private PersonService personService;
	
	private String test;
	
	public Person findById(long id) {
		return personService.find(id);
	}

	public String getTest() {
		// findById(55287).getSurname()
		
		test = "Wibble";
		
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
}
