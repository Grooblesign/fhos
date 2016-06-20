package uk.me.paulgarner.fh.dao;

import java.util.ArrayList;
import java.util.List;

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

	public List<Person> findAll() {
		List<Person> result = new ArrayList<Person>();
		
		Person root = findById(55287); 
		result.add(root);
		result.add(findById(root.getFatherId()));
		result.add(findById(root.getMotherId()));
		
		return result;
	}
	
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
