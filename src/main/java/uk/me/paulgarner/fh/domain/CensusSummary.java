package uk.me.paulgarner.fh.domain;

import uk.me.paulgarner.fh.util.DateValueCalculator;

public class CensusSummary implements Comparable {

	private long id;
	
	private String date;
	
	private String title;
	
	private String address;
	
	private String name;
	
	private String age;
	
	private String occupation;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	@Override
	public int compareTo(Object o) {
		CensusSummary other = (CensusSummary)o;
		
		Integer thisDateValue = DateValueCalculator.getDateValue(this.getDate());
		Integer otherDateValue = DateValueCalculator.getDateValue(other.getDate());
		
		return thisDateValue.compareTo(otherDateValue);
	}
}
