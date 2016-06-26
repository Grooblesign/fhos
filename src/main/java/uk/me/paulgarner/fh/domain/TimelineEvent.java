package uk.me.paulgarner.fh.domain;

import uk.me.paulgarner.fh.util.DateValueCalculator;

public class TimelineEvent implements Comparable {
	
	private Long id;
	private Long personId;
	private TimelineEventType timelineEventType;
	private String date;
	private String location;
	private String details;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	public TimelineEventType getTimelineEventType() {
		return timelineEventType;
	}
	public void setTimelineEventType(TimelineEventType timelineEventType) {
		this.timelineEventType = timelineEventType;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	@Override
	public int compareTo(Object o) {
		TimelineEvent other = (TimelineEvent)o;
		
		Integer thisDateValue = DateValueCalculator.getDateValue(this.getDate());
		Integer otherDateValue = DateValueCalculator.getDateValue(other.getDate());
		
		return thisDateValue.compareTo(otherDateValue);
	}
}
