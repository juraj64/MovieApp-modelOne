package com.jurajlazovy.movies.domain;

import com.jurajlazovy.movies.domain.Actor;
import com.jurajlazovy.movies.domain.Gender;
import java.util.Date;

/**
 * Builder for Actor class.
 */
public class ActorBuilder {

	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private Date createdDate;
	private String createdBy;
	private Date lastUpdated;
	private String lastUpdatedBy;

	private Gender gender;

	/**
	 * Static factory method for ActorBuilder
	 */
	public static ActorBuilder actor() {
		return new ActorBuilder();
	}

	public ActorBuilder() {
	}

	public ActorBuilder firstName(String val) {
		this.firstName = val;
		return this;
	}

	public ActorBuilder lastName(String val) {
		this.lastName = val;
		return this;
	}

	public ActorBuilder dateOfBirth(Date val) {
		this.dateOfBirth = val;
		return this;
	}

	public ActorBuilder createdDate(Date val) {
		this.createdDate = val;
		return this;
	}

	public ActorBuilder createdBy(String val) {
		this.createdBy = val;
		return this;
	}

	public ActorBuilder lastUpdated(Date val) {
		this.lastUpdated = val;
		return this;
	}

	public ActorBuilder lastUpdatedBy(String val) {
		this.lastUpdatedBy = val;
		return this;
	}

	public ActorBuilder gender(Gender gender) {
		this.gender = gender;
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

	public Gender getGender() {
		return gender;
	}

	/**
	 * @return new Actor instance constructed based on the values that have been set into this builder
	 */
	public Actor build() {
		Actor obj = new Actor();
		obj.setFirstName(firstName);
		obj.setLastName(lastName);
		obj.setDateOfBirth(dateOfBirth);
		obj.setCreatedDate(createdDate);
		obj.setCreatedBy(createdBy);
		obj.setLastUpdated(lastUpdated);
		obj.setLastUpdatedBy(lastUpdatedBy);
		obj.setGender(gender);

		return obj;
	}
}
