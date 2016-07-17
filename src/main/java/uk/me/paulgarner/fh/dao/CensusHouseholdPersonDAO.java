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

	@SuppressWarnings("unchecked")
	public List<CensusHouseholdPerson> findAllByCensusHouseholdId(long id) {
		return entityManager.createQuery(
    		    String.format("SELECT c FROM CensusHouseholdPerson c WHERE c.censusHouseholdId=%s ORDER BY c.rowNumber, c.id", id))
    		    .getResultList();    
	}

	public CensusHouseholdPerson findByCensusHouseholdIdAndPersonId(long censusHouseholdId, long personId) {
		
		CensusHouseholdPerson result = (CensusHouseholdPerson) entityManager.createQuery(
    		    String.format("SELECT c FROM CensusHouseholdPerson c WHERE c.censusHouseholdId=%s AND c.personId=%s", censusHouseholdId, personId))
    		    .getSingleResult();    
		
		return result;
	}
	
	public CensusHouseholdPerson findById(long id) {
		CensusHouseholdPerson result = entityManager.find(CensusHouseholdPerson.class, id);
        return result;
	}

}
