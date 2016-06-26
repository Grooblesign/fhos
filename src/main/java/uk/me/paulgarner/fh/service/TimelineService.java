package uk.me.paulgarner.fh.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import uk.me.paulgarner.fh.dao.EventDAO;
import uk.me.paulgarner.fh.domain.TimelineEvent;
import uk.me.paulgarner.fh.domain.TimelineEventType;
import uk.me.paulgarner.fh.entity.Event;

@Model
public class TimelineService {

	private static Map<String, TimelineEventType> typeMap;
	
	static {
		typeMap = new HashMap<String, TimelineEventType>();
		
		typeMap.put("Baptism", TimelineEventType.BAPTISM);
		typeMap.put("Birth", TimelineEventType.BIRTH);
		typeMap.put("Burial", TimelineEventType.BURIAL);
		typeMap.put("Death", TimelineEventType.DEATH);
		typeMap.put("Occupation", TimelineEventType.OCCUPATION);
	}
	
	@Inject
	private EventDAO eventDAO;

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
		
		Collections.sort(result);
		
		return result;
	}
}
