package uk.me.paulgarner.fh.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import uk.me.paulgarner.fh.dao.EventDAO;
import uk.me.paulgarner.fh.dao.PersonDAO;
import uk.me.paulgarner.fh.domain.Event;
import uk.me.paulgarner.fh.domain.Person;

@Model
public class PersonService {

	@Inject
	private EventDAO eventDAO;
	
	@Inject
	private PersonDAO personDAO;
	
	public List<Person> getAll() {
		List<Person> result = new ArrayList<Person>();
		
		List<uk.me.paulgarner.fh.entity.Person> personEntities = personDAO.findAll();
		
		for (uk.me.paulgarner.fh.entity.Person personEntity : personEntities) {
			Person person = new Person();
			
			person.setId(personEntity.getId());
			person.setForenames(personEntity.getForenames());
			person.setSurname(personEntity.getSurname());
			person.setFatherId(personEntity.getFatherId());
			person.setMotherId(personEntity.getMotherId());

			person.setBirthEvent(getBirthEvent(personEntity.getId()));
			person.setDeathEvent(getDeathEvent(personEntity.getId()));

			result.add(person);
		}
		
		return result;
	}

	public List<Person> getAllBySurnameStartingWithLetter(String letter) {
		List<Person> result = new ArrayList<Person>();
		
		List<uk.me.paulgarner.fh.entity.Person> personEntities = personDAO.findAllBySurnameStartingWithLetter(letter);
		
		for (uk.me.paulgarner.fh.entity.Person personEntity : personEntities) {
			Person person = new Person();
			
			person.setId(personEntity.getId());
			person.setForenames(personEntity.getForenames());
			person.setSurname(personEntity.getSurname());
			person.setFatherId(personEntity.getFatherId());
			person.setMotherId(personEntity.getMotherId());

			person.setBirthEvent(getBirthEvent(personEntity.getId()));
			person.setDeathEvent(getDeathEvent(personEntity.getId()));

			result.add(person);
		}
		
		return result;
	}

	public Person getById(Long id) {
		uk.me.paulgarner.fh.entity.Person personEntity = personDAO.findById(id); 
		
		Person person = new Person();
		
		person.setId(personEntity.getId());
		person.setForenames(personEntity.getForenames());
		person.setSurname(personEntity.getSurname());
		person.setFatherId(personEntity.getFatherId());
		person.setMotherId(personEntity.getMotherId());

		person.setBirthEvent(getBirthEvent(id));
		person.setDeathEvent(getDeathEvent(personEntity.getId()));
		
		return person;
	}
	
	public Person getById(String id) {
		return getById(Long.parseLong(id));
	}
	
	private Event getBirthEvent(Long id) {
		Event result = null;
		
		List<uk.me.paulgarner.fh.entity.Event> eventEntities = eventDAO.findAllByPersonIdAndType(id,  "Birth");
		
		if (!eventEntities.isEmpty()) {
			uk.me.paulgarner.fh.entity.Event birthEvent = eventEntities.get(0); 
			for (uk.me.paulgarner.fh.entity.Event event : eventEntities) {
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
		
		List<uk.me.paulgarner.fh.entity.Event> eventEntities = eventDAO.findAllByPersonIdAndType(id, "Death");
		
		if (!eventEntities.isEmpty()) {
			uk.me.paulgarner.fh.entity.Event deathEvent = eventEntities.get(0); 
			for (uk.me.paulgarner.fh.entity.Event event : eventEntities) {
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
}
