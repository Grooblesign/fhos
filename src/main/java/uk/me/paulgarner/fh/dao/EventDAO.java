package uk.me.paulgarner.fh.dao;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import uk.me.paulgarner.fh.entity.Event;
import uk.me.paulgarner.fh.entity.Person;

@Model
public class EventDAO {
	
    @PersistenceContext(unitName = "fh", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
	public List<Event> findAllByPersonId(Long personId) {
    	return entityManager.createQuery(
    		    String.format("SELECT e FROM Event e WHERE e.personId=%s ORDER BY e.id", personId))
    		    .getResultList();    
	}

    @SuppressWarnings("unchecked")
	public List<Event> findAllByPersonIdAndType(Long personId, String eventType) {
    	return entityManager.createQuery(
    		    String.format("SELECT e FROM Event e WHERE e.personId=%s AND e.eventType='%s' ORDER BY e.id", personId, eventType))
    		    .getResultList();    
	}
}
