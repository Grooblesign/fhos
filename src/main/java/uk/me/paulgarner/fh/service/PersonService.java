package uk.me.paulgarner.fh.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import uk.me.paulgarner.fh.dao.EventDAO;
import uk.me.paulgarner.fh.dao.PersonDAO;
import uk.me.paulgarner.fh.domain.Event;
import uk.me.paulgarner.fh.domain.Person;
import uk.me.paulgarner.fh.entity.PersonEntity;

@Model
public class PersonService {

	@Inject
	private EventDAO eventDAO;
	
	@Inject
	private PersonDAO personDAO;
	
	public List<Person> getAll() {
		List<Person> result = new ArrayList<Person>();
		
		List<PersonEntity> personEntities = personDAO.findAll();
		
		for (PersonEntity personEntity : personEntities) {
			result.add(adapt(personEntity));
		}
		
		return result;
	}

	public List<Person> getAllBySurnameStartingWithLetter(String letter) {
		List<Person> result = new ArrayList<Person>();
		
		List<PersonEntity> personEntities = personDAO.findAllBySurnameStartingWithLetter(letter);
		
		for (PersonEntity personEntity : personEntities) {
			result.add(adapt(personEntity));
		}
		
		return result;
	}
	
	public List<Person> getAllChildrenByPersonId(long personId) {
		List<Person> result = new ArrayList<Person>();
	
		List<PersonEntity> personEntities = personDAO.findAllByFatherId(personId);
		personEntities.addAll(personDAO.findAllByMotherId(personId));
		
		for (PersonEntity personEntity : personEntities) {
			result.add(adapt(personEntity));
		}
	
		return result;

	}

	public Person getById(Long id) {
		PersonEntity result = personDAO.findById(id);

		if (null == result) {
			return null;
		} else {
			return adapt(result);
		}
	}
	
	public Person getById(String id) {
		return getById(Long.parseLong(id));
	}
	
	private Event getBirthEvent(Long id) {
		Event result = null;
		
		List<uk.me.paulgarner.fh.entity.EventEntity> eventEntities = eventDAO.findAllByPersonIdAndType(id,  "Birth");

		if (eventEntities.isEmpty()) {
			eventEntities = eventDAO.findAllByPersonIdAndType(id, "Baptism");
		}

		if (!eventEntities.isEmpty()) {
			uk.me.paulgarner.fh.entity.EventEntity birthEvent = eventEntities.get(0); 
			for (uk.me.paulgarner.fh.entity.EventEntity event : eventEntities) {
				if (event.isPrimary()) {
					birthEvent = event;
					break;
				}
			}
			
			result = new Event();
			result.setId(birthEvent.getId());
			result.setPersonId(birthEvent.getPersonId());
			result.setEventType(birthEvent.getEventType());
			result.setDate(birthEvent.getDate());
			result.setLocation(birthEvent.getLocation());
			result.setDetails(birthEvent.getDetails());
		}
				
		return result;
	}
	
	private Event getDeathEvent(Long id) {
		Event result = null;
		
		List<uk.me.paulgarner.fh.entity.EventEntity> eventEntities = eventDAO.findAllByPersonIdAndType(id, "Death");
		
		if (eventEntities.isEmpty()) {
			eventEntities = eventDAO.findAllByPersonIdAndType(id, "Burial");
		}
		
		if (!eventEntities.isEmpty()) {
			uk.me.paulgarner.fh.entity.EventEntity deathEvent = eventEntities.get(0); 
			for (uk.me.paulgarner.fh.entity.EventEntity event : eventEntities) {
				if (event.isPrimary()) {
					deathEvent = event;
					break;
				}
			}
			
			result = new Event();
			result.setId(deathEvent.getId());
			result.setPersonId(deathEvent.getPersonId());
			result.setEventType(deathEvent.getEventType());
			result.setDate(deathEvent.getDate());
			result.setLocation(deathEvent.getLocation());
			result.setDetails(deathEvent.getDetails());
		}
				
		return result;
	}
	
	private Person adapt(PersonEntity in) {
		Person out = new Person();
		
		out.setId(in.getId());
		out.setForenames(in.getForenames());
		out.setSurname(in.getSurname());
		out.setFatherId(in.getFatherId());
		out.setMotherId(in.getMotherId());
		out.setImage(in.getImage());

		out.setBirthEvent(getBirthEvent(in.getId()));
		out.setDeathEvent(getDeathEvent(in.getId()));
		
		return out;
	}
}
