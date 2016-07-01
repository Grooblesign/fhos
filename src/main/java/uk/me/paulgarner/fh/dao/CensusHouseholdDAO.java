package uk.me.paulgarner.fh.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import uk.me.paulgarner.fh.entity.CensusHousehold;

public class CensusHouseholdDAO {

	@PersistenceContext(unitName = "fh", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

	public CensusHousehold findById(long id) {
        return entityManager.find(CensusHousehold.class, id);
	}
}
