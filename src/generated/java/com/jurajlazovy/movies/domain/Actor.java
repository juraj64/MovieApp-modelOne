package com.jurajlazovy.movies.domain;

import com.jurajlazovy.movies.domain.Gender;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Type;
import org.sculptor.framework.domain.AbstractDomainObject;
import org.sculptor.framework.domain.AuditListener;
import org.sculptor.framework.domain.Auditable;
import org.sculptor.framework.domain.Identifiable;

/**
 * Entity representing Actor.
 */

@Entity
@Table(name = "ACTOR")
@EntityListeners({ AuditListener.class })
public class Actor extends AbstractDomainObject implements Auditable, Identifiable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "FIRSTNAME", nullable = false, length = 100)
	@NotNull
	private String firstName;
	@Column(name = "LASTNAME", nullable = false, length = 100)
	@NotNull
	private String lastName;
	@Column(name = "DATEOFBIRTH", nullable = false)
	@Type(type = "date")
	@NotNull
	private Date dateOfBirth;
	@Column(name = "UUID", nullable = false, length = 36, unique = true)
	private String uuid;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATEDDATE")
	private Date createdDate;
	@Column(name = "CREATEDBY", length = 50)
	private String createdBy;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LASTUPDATED")
	private Date lastUpdated;
	@Column(name = "LASTUPDATEDBY", length = 50)
	private String lastUpdatedBy;
	@Version
	@Column(name = "VERSION", nullable = false)
	private Long version;

	@Column(name = "GENDER", length = 1)
	@Enumerated(EnumType.STRING)
	private Gender gender;

	public Actor() {
	}

	public Long getId() {
		return id;
	}

	/**
	 * The id is not intended to be changed or assigned manually, but for test purpose it is allowed to assign the id.
	 */
	protected void setId(Long id) {
		if ((this.id != null) && !this.id.equals(id)) {
			throw new IllegalArgumentException("Not allowed to change the id property.");
		}
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;

	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;

	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;

	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;

	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;

	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;

	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;

	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;

	}

	/**
	 * This domain object doesn't have a natural key and this random generated identifier is the unique identifier for this domain
	 * object.
	 */
	public String getUuid() {
		// lazy init of UUID
		if (uuid == null) {
			uuid = UUID.randomUUID().toString();
		}
		return uuid;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@PrePersist
	protected void prePersist() {
		getUuid();
	}

	/**
	 * This method is used by toString. It specifies what to include in the toString result.
	 * 
	 * @return true if the field is to be included in toString
	 */
	protected boolean acceptToString(Field field) {
		if (super.acceptToString(field)) {
			return true;
		} else {
			if (field.getName().equals("gender")) {
				return true;
			}
			return false;
		}
	}

	/**
	 * This method is used by equals and hashCode.
	 * 
	 * @return {{@link #getUuid}
	 */
	public Object getKey() {
		return getUuid();
	}

}
