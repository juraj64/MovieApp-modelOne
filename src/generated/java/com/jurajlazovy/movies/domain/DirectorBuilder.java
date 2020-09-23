package com.jurajlazovy.movies.domain;

import com.jurajlazovy.movies.domain.Director;
import java.util.Date;

/**
 * Builder for Director class.
 */
public class DirectorBuilder {

	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String nationality;
	private Date createdDate;
	private String createdBy;
	private Date lastUpdated;
	private String lastUpdatedBy;

	/**
	 * Static factory method for DirectorBuilder
	 */
	public static DirectorBuilder director() {
		return new DirectorBuilder();
	}

	public DirectorBuilder() {
	}

	public DirectorBuilder firstName(String val) {
		this.firstName = val;
		return this;
	}

	public DirectorBuilder lastName(String val) {
		this.lastName = val;
		return this;
	}

	public DirectorBuilder dateOfBirth(Date val) {
		this.dateOfBirth = val;
		return this;
	}

	public DirectorBuilder nationality(String val) {
		this.nationality = val;
		return this;
	}

	public DirectorBuilder createdDate(Date val) {
		this.createdDate = val;
		return this;
	}

	public DirectorBuilder createdBy(String val) {
		this.createdBy = val;
		return this;
	}

	public DirectorBuilder lastUpdated(Date val) {
		this.lastUpdated = val;
		return this;
	}

	public DirectorBuilder lastUpdatedBy(String val) {
		this.lastUpdatedBy = val;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getNationality() {
		return nationality;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	/**
	 * @return new Director instance constructed based on the values that have been set into this builder
	 */
	public Director build() {
		Director obj = new Director();
		obj.setFirstName(firstName);
		obj.setLastName(lastName);
		obj.setDateOfBirth(dateOfBirth);
		obj.setNationality(nationality);
		obj.setCreatedDate(createdDate);
		obj.setCreatedBy(createdBy);
		obj.setLastUpdated(lastUpdated);
		obj.setLastUpdatedBy(lastUpdatedBy);

		return obj;
	}
}
