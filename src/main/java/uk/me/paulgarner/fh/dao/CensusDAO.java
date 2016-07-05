package uk.me.paulgarner.fh.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import uk.me.paulgarner.fh.entity.Census;

public class CensusDAO {
    
	@PersistenceContext(unitName = "fh", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
	public List<Census> findAll() {
    	return entityManager.createQuery(
    		    "SELECT c FROM Census c ORDER BY c.id")
    		    .getResultList();    
	}
    
	public Census findById(long id) {
        return entityManager.find(Census.class, id);
	}
}
