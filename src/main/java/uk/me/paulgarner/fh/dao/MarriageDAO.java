package uk.me.paulgarner.fh.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import uk.me.paulgarner.fh.entity.MarriageEntity;

public class MarriageDAO {

	@PersistenceContext(unitName = "fh", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
	public List<MarriageEntity> findAllByPersonId(Long personId) {
    	return entityManager.createQuery(
    		    String.format("SELECT m FROM MarriageEntity m WHERE m.husbandId=%s OR m.wifeId=%s ORDER BY m.id", personId, personId))
    		    .getResultList();    
	}
    
	public MarriageEntity findById(long id) {
        return entityManager.find(MarriageEntity.class, id);
	}
}
