package uk.me.paulgarner.fh.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import uk.me.paulgarner.fh.entity.Person;

public class PersonDAO {

    @PersistenceContext(unitName = "fh", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
	public List<Person> findAll() {
    	return entityManager.createQuery(
    		    "SELECT p FROM Person p ORDER BY p.surname, p.forenames")
    		    .getResultList();    
	}

	public Person findById(long id) {
        return entityManager.find(Person.class, id);
	}
}
