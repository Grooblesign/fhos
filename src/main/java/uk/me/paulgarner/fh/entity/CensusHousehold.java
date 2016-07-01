package uk.me.paulgarner.fh.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "censushousehold")
public class CensusHousehold implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private long id;
	
	@Column
	private String address;

	@Column(name="censusid", nullable=false)
	private long censusId;

	@Column(name="citationid", nullable=false)
	private long citationId;

	@Column
	private String folio;

	@Column
	private String notes;

	@Column
	private String page;

	@Column
	private String piece;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getCensusId() {
		return censusId;
	}

	public void setCensusId(long censusId) {
		this.censusId = censusId;
	}

	public long getCitationId() {
		return citationId;
	}

	public void setCitationId(long citationId) {
		this.citationId = citationId;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getPiece() {
		return piece;
	}

	public void setPiece(String piece) {
		this.piece = piece;
	}
}
