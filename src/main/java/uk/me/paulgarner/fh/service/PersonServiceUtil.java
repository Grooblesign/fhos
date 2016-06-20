package uk.me.paulgarner.fh.service;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import uk.me.paulgarner.fh.domain.Person;

@ApplicationScoped
public class PersonServiceUtil {

	@Inject
    private PersonService personService;
	
	public Person findById(long id) {
		return personService.find(id);
	}
}
