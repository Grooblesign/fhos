package uk.me.paulgarner.fh.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "censushouseholdperson")
public class CensusHouseholdPerson implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private long id;
	
	@Column
	private String age;

	@Column
	private String birthplace;

	@Column(name="censusHouseholdid", nullable=false)
	private long censusHouseholdId;

	@Column
	private String name;

	@Column
	private String occupation;

	@Column(name="personid", nullable=true)
	private long personId;

	@Column(name="relationshiptohead", nullable=true)
	private String relationshipToHead;

	@Column(name="rownumber")
	private Integer rowNumber;

	@Column
	private String status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public long getCensusHouseholdId() {
		return censusHouseholdId;
	}

	public void setCensusHouseholdId(long censusHouseholdId) {
		this.censusHouseholdId = censusHouseholdId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getRelationshipToHead() {
		return relationshipToHead;
	}

	public void setRelationshipToHead(String relationshipToHead) {
		this.relationshipToHead = relationshipToHead;
	}

	public Integer getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(Integer rowNumber) {
		this.rowNumber = rowNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
