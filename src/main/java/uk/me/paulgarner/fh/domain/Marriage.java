package uk.me.paulgarner.fh.domain;

import uk.me.paulgarner.fh.util.DateValueCalculator;

public class Marriage implements Comparable {

	private long id;

	private long husbandId;

	private long wifeId;
	
	private String location;

	private String date;

	private String notes;

	private long citationId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getHusbandId() {
		return husbandId;
	}

	public void setHusbandId(long husbandId) {
		this.husbandId = husbandId;
	}

	public long getWifeId() {
		return wifeId;
	}

	public void setWifeId(long wifeId) {
		this.wifeId = wifeId;
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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public long getCitationId() {
		return citationId;
	}

	public void setCitationId(long citationId) {
		this.citationId = citationId;
	}

	@Override
	public int compareTo(Object o) {
		Marriage other = (Marriage)o;
		
		Integer thisDateValue = DateValueCalculator.getDateValue(this.getDate());
		Integer otherDateValue = DateValueCalculator.getDateValue(other.getDate());
		
		return thisDateValue.compareTo(otherDateValue);
	}
}
