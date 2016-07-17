package uk.me.paulgarner.fh.conversion;

import uk.me.paulgarner.fh.domain.Event;
import uk.me.paulgarner.fh.entity.EventEntity;

public class EventEntityToEvent {

	public static Event adapt(EventEntity in) {
		
		Event out = null;
		
		if (null != in) {
			out = new Event();
			
			out.setCitationId(in.getCitationId());
			out.setDate(in.getDate());
			out.setDetails(in.getDetails());
			out.setEventType(in.getEventType());
			out.setId(in.getId());
			out.setLocation(in.getLocation());
			out.setPersonId(in.getPersonId());
		}
		
		return out;
	}
}
