package uk.me.paulgarner.fh.service;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import uk.me.paulgarner.fh.conversion.EventEntityToEvent;
import uk.me.paulgarner.fh.dao.EventDAO;
import uk.me.paulgarner.fh.domain.Event;
import uk.me.paulgarner.fh.entity.EventEntity;

@Model
public class EventService {

	@Inject
	private EventDAO eventDAO;

	public Event getById(long id) {
		EventEntity eventEntity = eventDAO.findById(id);
		
		return EventEntityToEvent.adapt(eventEntity);
	}
}
