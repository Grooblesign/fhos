package uk.me.paulgarner.fh.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import uk.me.paulgarner.fh.dao.CensusDAO;
import uk.me.paulgarner.fh.dao.CensusHouseholdDAO;
import uk.me.paulgarner.fh.dao.CensusHouseholdPersonDAO;
import uk.me.paulgarner.fh.dao.EventDAO;
import uk.me.paulgarner.fh.dao.MarriageDAO;
import uk.me.paulgarner.fh.dao.PersonDAO;
import uk.me.paulgarner.fh.domain.TimelineEvent;
import uk.me.paulgarner.fh.domain.TimelineEventType;
import uk.me.paulgarner.fh.entity.Census;
import uk.me.paulgarner.fh.entity.CensusHousehold;
import uk.me.paulgarner.fh.entity.CensusHouseholdPerson;
import uk.me.paulgarner.fh.entity.Event;
import uk.me.paulgarner.fh.entity.MarriageEntity;
import uk.me.paulgarner.fh.entity.PersonEntity;

@Model
public class TimelineService {

	private static Map<String, TimelineEventType> typeMap;
	
	static {
		typeMap = new HashMap<String, TimelineEventType>();
		
		typeMap.put("Baptism", TimelineEventType.BAPTISM);
		typeMap.put("Birth", TimelineEventType.BIRTH);
		typeMap.put("Burial", TimelineEventType.BURIAL);
		typeMap.put("Death", TimelineEventType.DEATH);
		typeMap.put("Milit-Beg", TimelineEventType.MILITARYSERVICEBEGIN);
		typeMap.put("Occupation", TimelineEventType.OCCUPATION);
		typeMap.put("Residence", TimelineEventType.RESIDENCE);
	}

	@Inject
	private CensusDAO censusDAO;

	@Inject
	private CensusHouseholdDAO censusHouseholdDAO;

	@Inject
	private CensusHouseholdPersonDAO censusHouseholdPersonDAO;

	@Inject
	private EventDAO eventDAO;

	@Inject
	private MarriageDAO marriageDAO;

	@Inject
	private PersonDAO personDAO;

	@SuppressWarnings("unchecked")
	public List<TimelineEvent> getAllByPersonId(Long personId) {
		
		List<TimelineEvent> result = new ArrayList<TimelineEvent>();
		
		List<Event> events = eventDAO.findAllByPersonId(personId);
		
		for (Event event : events) {
			if (null != typeMap.get(event.getEventType())) {
				TimelineEvent timelineEvent = new TimelineEvent();
				
				timelineEvent.setDate(event.getDate());
				timelineEvent.setDetails(event.getDetails());
				timelineEvent.setId(event.getId());
				timelineEvent.setLocation(event.getLocation());
				timelineEvent.setTimelineEventType(typeMap.get(event.getEventType()));
				timelineEvent.setPersonId(personId);
				
				result.add(timelineEvent);
			}
		}

		List<Census> censuses = censusDAO.findAll();
		
		Map<Long, Census> censusMap = new HashMap<Long, Census>();  
		for (Census census : censuses) {
			censusMap.put(census.getId(), census);
		}
		
		List<CensusHouseholdPerson> censusHouseholdEntries = censusHouseholdPersonDAO.findAllByPersonId(personId);
		
		for (CensusHouseholdPerson censusEntry : censusHouseholdEntries) {
			TimelineEvent timelineEvent = new TimelineEvent();
			
			CensusHousehold censusHousehold = censusHouseholdDAO.findById(censusEntry.getCensusHouseholdId());
			
			timelineEvent.setDate(censusMap.get(censusHousehold.getCensusId()).getDate());
			timelineEvent.setLocation(censusHousehold.getAddress());
			timelineEvent.setId(censusHousehold.getId());
			timelineEvent.setTimelineEventType(TimelineEventType.CENSUS);
			
			result.add(timelineEvent);
		}
		
		List<MarriageEntity> marriages = marriageDAO.findAllByPersonId(personId);

		for (MarriageEntity marriage : marriages) {
			PersonEntity spouse = null;
			
			if (marriage.getHusbandId() == personId) {
				spouse = personDAO.findById(marriage.getWifeId());
			} else {
				spouse = personDAO.findById(marriage.getHusbandId());
			}
			
			TimelineEvent timelineEvent = new TimelineEvent();
			
			timelineEvent.setDate(marriage.getDate());
			timelineEvent.setDetails(spouse.getForenames() + " " + spouse.getSurname());
			timelineEvent.setLocation(marriage.getLocation());
			timelineEvent.setId(marriage.getId());
			timelineEvent.setTimelineEventType(TimelineEventType.MARRIAGE);
			
			result.add(timelineEvent);
		}

		Collections.sort(result);
		
		return result;
	}
}
