package uk.me.paulgarner.fh.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class EventEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private long id;

	@Column(name="personid", nullable=false)
	private long personId;

	@Column(name="type", nullable=false)
	private String eventType;

	@Column
	private String location;

	@Column
	private String date;

	@Column
	private String details;
	
	@Column(name="citationId", nullable=false)
	private Long citationId;
	
	@Column
	private boolean isPrimary;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public Long getCitationId() {
		return citationId;
	}

	public void setCitationId(Long citationId) {
		this.citationId = citationId;
	}
}
