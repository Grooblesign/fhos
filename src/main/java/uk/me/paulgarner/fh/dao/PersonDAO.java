package uk.me.paulgarner.fh.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import uk.me.paulgarner.fh.entity.PersonEntity;

public class PersonDAO {

    @PersistenceContext(unitName = "fh", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
	public List<PersonEntity> findAll() {
    	return entityManager.createQuery(
    		    "SELECT p FROM PersonEntity p ORDER BY p.surname, p.forenames")
    		    .getResultList();    
	}

    @SuppressWarnings("unchecked")
	public List<PersonEntity> findAllByFatherId(long fatherId) {
    	return entityManager.createQuery(
    		    String.format("SELECT p FROM PersonEntity p WHERE p.fatherId=%s ORDER BY p.surname, p.forenames", fatherId))
    		    .getResultList();    
	}

    @SuppressWarnings("unchecked")
	public List<PersonEntity> findAllByMotherId(long motherId) {
    	return entityManager.createQuery(
    		    String.format("SELECT p FROM PersonEntity p WHERE p.motherId=%s ORDER BY p.surname, p.forenames", motherId))
    		    .getResultList();    
	}

    @SuppressWarnings("unchecked")
	public List<PersonEntity> findAllBySurnameStartingWithLetter(String letter) {
    	return entityManager.createQuery(
    		    String.format("SELECT p FROM PersonEntity p WHERE p.surname LIKE '%s%s' ORDER BY p.surname, p.forenames", letter, "%"))
    		    .getResultList();    
	}

	public PersonEntity findById(long id) {
        return entityManager.find(PersonEntity.class, id);
	}
}
