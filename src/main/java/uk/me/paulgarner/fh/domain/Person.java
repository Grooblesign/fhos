package uk.me.paulgarner.fh.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	@Column
	private long id;
	
	@Column
	private String forenames;

	@Column
	private String surname;
}
