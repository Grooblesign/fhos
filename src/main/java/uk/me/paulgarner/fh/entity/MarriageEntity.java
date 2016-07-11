package uk.me.paulgarner.fh.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marriage")
public class MarriageEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private long id;

	@Column(name="husbandid", nullable=false)
	private long husbandId;

	@Column(name="wifeId", nullable=false)
	private long wifeId;
	
	@Column
	private String location;

	@Column
	private String date;

	@Column
	private String notes;

	@Column(name="citationId", nullable=false)
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
}
