package com.jurajlazovy.movies.domain;

import com.jurajlazovy.movies.domain.Actor;
import com.jurajlazovy.movies.domain.Director;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Type;
import org.sculptor.framework.domain.AbstractDomainObject;
import org.sculptor.framework.domain.AuditListener;
import org.sculptor.framework.domain.Auditable;
import org.sculptor.framework.domain.Identifiable;

/**
 * Entity representing Movie.
 */

@Entity
@Table(name = "MOVIE")
@EntityListeners({ AuditListener.class })
public class Movie extends AbstractDomainObject implements Auditable, Identifiable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "MOVIENAME", nullable = false, length = 100)
	@NotNull
	private String movieName;
	@Column(name = "MOVIELENGTH", nullable = false)
	private int movieLength;
	@Column(name = "MOVIELANG", nullable = false, length = 100)
	@NotNull
	private String movieLang;
	@Column(name = "RELEASEDATE", nullable = false)
	@Type(type = "date")
	@NotNull
	private Date releaseDate;
	@Column(name = "AGECERTIFICATE", nullable = false, length = 100)
	@NotNull
	private String ageCertificate;
	@Column(name = "DOMESTICTAKINGS", nullable = false)
	private int domesticTakings;
	@Column(name = "INTERNATIONALTAKINGS", nullable = false)
	private int internationalTakings;
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

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "DIRECTOR", nullable = false)
	@ForeignKey(name = "FK_MOVIE_DIRECTOR")
	@NotNull
	private Director director;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ACTOR_MOVIE", joinColumns = @JoinColumn(name = "MOVIE"), inverseJoinColumns = @JoinColumn(name = "ACTOR"))
	@ForeignKey(name = "FK_ACTOR_MOVIE_MOVIE", inverseName = "FK_ACTOR_MOVIE_ACTOR")
	@NotNull
	private List<Actor> actors = new ArrayList<Actor>();

	public Movie() {
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

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;

	}

	public int getMovieLength() {
		return movieLength;
	}

	public void setMovieLength(int movieLength) {
		this.movieLength = movieLength;

	}

	public String getMovieLang() {
		return movieLang;
	}

	public void setMovieLang(String movieLang) {
		this.movieLang = movieLang;

	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;

	}

	public String getAgeCertificate() {
		return ageCertificate;
	}

	public void setAgeCertificate(String ageCertificate) {
		this.ageCertificate = ageCertificate;

	}

	public int getDomesticTakings() {
		return domesticTakings;
	}

	public void setDomesticTakings(int domesticTakings) {
		this.domesticTakings = domesticTakings;

	}

	public int getInternationalTakings() {
		return internationalTakings;
	}

	public void setInternationalTakings(int internationalTakings) {
		this.internationalTakings = internationalTakings;

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

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public List<Actor> getActors() {
		return actors;
	}

	/**
	 * Adds an object to the unidirectional to-many association. It is added the collection {@link #getActors}.
	 */
	public void addActor(Actor actorElement) {
		getActors().add(actorElement);
	}

	/**
	 * Removes an object from the unidirectional to-many association. It is removed from the collection {@link #getActors}.
	 */
	public void removeActor(Actor actorElement) {
		getActors().remove(actorElement);
	}

	/**
	 * Removes all object from the unidirectional to-many association. All elements are removed from the collection
	 * {@link #getActors}.
	 */
	public void removeAllActors() {
		getActors().clear();
	}

	@PrePersist
	protected void prePersist() {
		getUuid();
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
