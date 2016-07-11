package uk.me.paulgarner.fh.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "citation")
public class CitationEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private long id;
	
	@Column(name="details", nullable=true)
	private String details;

	@Column(name="sourceid", nullable=false)
	private long sourceId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSourceId() {
		return sourceId;
	}

	public void setSourceId(long sourceId) {
		this.sourceId = sourceId;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
