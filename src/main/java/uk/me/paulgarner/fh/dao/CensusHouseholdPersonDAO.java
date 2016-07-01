package uk.me.paulgarner.fh.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import uk.me.paulgarner.fh.entity.CensusHouseholdPerson;

public class CensusHouseholdPersonDAO {

	@PersistenceContext(unitName = "fh", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<CensusHouseholdPerson> findAllByPersonId(long id) {
		return entityManager.createQuery(
    		    String.format("SELECT c FROM CensusHouseholdPerson c WHERE c.personId=%s", id))
    		    .getResultList();    
	}
}
