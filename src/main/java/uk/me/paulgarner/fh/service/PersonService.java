package uk.me.paulgarner.fh.service;

import javax.annotation.ManagedBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import uk.me.paulgarner.fh.domain.Person;

@Stateful
public class PersonService {

    @PersistenceContext(unitName = "fh", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;
 
	public Person find(Long id) {
        Person person = entityManager.find(Person.class, id);
        return person;
    }
}
