package uk.me.paulgarner.fh.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import uk.me.paulgarner.fh.entity.CitationEntity;

public class CitationDAO {
	
	@PersistenceContext(unitName = "fh", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

	public CitationEntity findById(long id) {
        return entityManager.find(CitationEntity.class, id);
	}

}
