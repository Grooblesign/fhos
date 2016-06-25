package uk.me.paulgarner.fh.domain;

public class TimelineEvent {
	
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
}
