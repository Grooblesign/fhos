package uk.me.paulgarner.fh.domain;

public class Person {

	private long id;
	
	private String forenames;

	private String surname;

	private Long fatherId;

	private Long motherId;
	
	private Event birthEvent;

	private Event deathEvent;
	
	private String image;

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

	public Event getBirthEvent() {
		return birthEvent;
	}

	public void setBirthEvent(Event birthEvent) {
		this.birthEvent = birthEvent;
	}

	public Event getDeathEvent() {
		return deathEvent;
	}

	public void setDeathEvent(Event deathEvent) {
		this.deathEvent = deathEvent;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
