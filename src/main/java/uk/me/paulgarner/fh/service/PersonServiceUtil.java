package uk.me.paulgarner.fh.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import uk.me.paulgarner.fh.domain.Person;

@Stateless
public class PersonServiceUtil {

	@Inject
    private PersonService personService;
	
	public Person findById(long id) {
		return personService.find(id);
	}
}
