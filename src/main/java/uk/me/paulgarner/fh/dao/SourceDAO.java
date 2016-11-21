package uk.me.paulgarner.fh.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import uk.me.paulgarner.fh.entity.SourceEntity;

public class SourceDAO {

	@PersistenceContext(unitName = "fh", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
	public List<SourceEntity> findAll() {
    	return entityManager.createQuery(
    		    "SELECT s FROM SourceEntity s ORDER BY s.title")
    		    .getResultList();    
	}
	
	public SourceEntity findById(long id) {
        return entityManager.find(SourceEntity.class, id);
	}

}
