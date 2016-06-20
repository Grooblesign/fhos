package uk.me.paulgarner.fh.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private long id;
	
	@Column
	private String forenames;

	@Column
	private String surname;

	@Column(name="fatherid")
	private long fatherId;

	@Column(name="motherid")
	private long motherId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getForenames() {
		return forenames;
	}

	public void setForenames(String forenames) {
		this.forenames = forenames;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public long getFatherId() {
		return fatherId;
	}

	public void setFatherId(long fatherId) {
		this.fatherId = fatherId;
	}

	public long getMotherId() {
		return motherId;
	}

	public void setMotherId(long motherId) {
		this.motherId = motherId;
	}
}
