package uk.me.paulgarner.fh.domain;

public enum TimelineEventType {
	BAPTISM("Baptism"),
	BIRTH("Birth"),
	BURIAL("Burial"),
	CENSUS("Census"),
	CHILDBORN("Child Born"),
	DEATH("Death"),
	IMPRISONMENT("Imprisonment"),
	MARRIAGE("Marriage"),
	MILITARYSERVICEBEGIN("Military Begin"),
	MILITARYSERVICEEND("Military End"),
	OCCUPATION("Occupation"),
	RESIDENCE("Residence"),
	SPOUSEDEATH("Spouse Death"),
	WITNESS("Witness");
	
	private String typeAsString;
	
	private TimelineEventType(String typeAsString) {
		this.typeAsString = typeAsString;
	}
	
	public String asString() {
		return typeAsString;
	}
}
