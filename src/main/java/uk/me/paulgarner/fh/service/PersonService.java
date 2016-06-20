package uk.me.paulgarner.fh.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import uk.me.paulgarner.fh.domain.Person;

@Stateless
public class PersonService {

	@PersistenceContext
    private EntityManager entityManager;
 
	public Person find(Long id) {
        Person person = entityManager.find(Person.class, id);
        return person;
    }
}
