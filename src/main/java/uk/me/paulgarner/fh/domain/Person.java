package uk.me.paulgarner.fh.domain;

public class Person {
	
	private long id;
	
	private String forenames;

	private String surname;

	private Long fatherId;

	private Long motherId;
	
	private String birthDate;
	
	private String deathDate;
	
	private Event birthEvent;

	public String getFullName() {
		String fullName = "";
		
		if (null != forenames && forenames.length() > 0) {
			fullName = fullName + forenames + " ";
		}
		if (null != surname && surname.length() > 0) {
			fullName = fullName + surname;
		}		
		
		return fullName.trim();
	}

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

	public Long getFatherId() {
		return fatherId;
	}

	public void setFatherId(Long fatherId) {
		this.fatherId = fatherId;
	}

	public Long getMotherId() {
		return motherId;
	}

	public void setMotherId(Long motherId) {
		this.motherId = motherId;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}

	public Event getBirthEvent() {
		return birthEvent;
	}

	public void setBirthEvent(Event birthEvent) {
		this.birthEvent = birthEvent;
	}
}
