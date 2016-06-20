package uk.me.paulgarner.fh.service;

import javax.annotation.ManagedBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import uk.me.paulgarner.fh.domain.Person;

@ManagedBean
@Stateless
public class PersonService {

	@PersistenceContext
	@Inject
    private EntityManager entityManager;
 
	public Person find(Long id) {
        Person person = entityManager.find(Person.class, id);
        return person;
    }
}
