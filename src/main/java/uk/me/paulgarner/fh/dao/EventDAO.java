package uk.me.paulgarner.fh.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import uk.me.paulgarner.fh.entity.EventEntity;

public class EventDAO {
	
    @PersistenceContext(unitName = "fh", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
	public List<EventEntity> findAllByPersonId(Long personId) {
    	return entityManager.createQuery(
    		    String.format("SELECT e FROM EventEntity e WHERE e.personId=%s ORDER BY e.id", personId))
    		    .getResultList();    
	}

    @SuppressWarnings("unchecked")
	public List<EventEntity> findAllByPersonIdAndType(Long personId, String eventType) {
    	return entityManager.createQuery(
    		    String.format("SELECT e FROM EventEntity e WHERE e.personId=%s AND e.eventType='%s' ORDER BY e.id", personId, eventType))
    		    .getResultList();    
	}
    
	public EventEntity findById(long id) {
        return entityManager.find(EventEntity.class, id);
	}
}
