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
		
		return person;
	}
	
	public Person getById(String id) {
		return getById(Long.parseLong(id));
	}
	
	private Event getBirthEvent(Long id) {
		Event result = null;
		
		List<uk.me.paulgarner.fh.entity.Event> eventEntities = eventDAO.findAllByPersonIdAndType(id,  "Birth");
		
		if (!eventEntities.isEmpty()) {
			result = new Event();
			result.setId(eventEntities.get(0).getId());
			result.setPersonId(eventEntities.get(0).getPersonId());
			result.setEventType(eventEntities.get(0).getEventType());
			result.setDate(eventEntities.get(0).getDate());
			result.setLocation(eventEntities.get(0).getLocation());
			result.setDetails(eventEntities.get(0).getDetails());
		}
				
		return result;
	}
}
