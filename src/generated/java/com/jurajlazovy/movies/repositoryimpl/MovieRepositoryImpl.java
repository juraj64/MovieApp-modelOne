package com.jurajlazovy.movies.repositoryimpl;

import com.jurajlazovy.movies.domain.Movie;
import com.jurajlazovy.movies.domain.MovieRepository;
import com.jurajlazovy.movies.exception.MovieNotFoundException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.accessapi.DeleteAccess;
import org.sculptor.framework.accessapi.FindAllAccess2;
import org.sculptor.framework.accessapi.FindByConditionAccess2;
import org.sculptor.framework.accessapi.FindByIdAccess;
import org.sculptor.framework.accessapi.SaveAccess;
import org.sculptor.framework.accessimpl.jpa.JpaDeleteAccessImpl;
import org.sculptor.framework.accessimpl.jpa.JpaFindAllAccessImplGeneric;
import org.sculptor.framework.accessimpl.jpa.JpaFindByConditionAccessImplGeneric;
import org.sculptor.framework.accessimpl.jpa.JpaFindByIdAccessImpl;
import org.sculptor.framework.accessimpl.jpa.JpaSaveAccessImpl;
import org.springframework.stereotype.Repository;

/**
 * Repository implementation for Movie
 */
@Repository("movieRepository")
public class MovieRepositoryImpl implements MovieRepository {

	public MovieRepositoryImpl() {
	}

	/**
	 * Delegates to {@link org.sculptor.framework.accessapi.FindByConditionAccess}
	 */
	public List<Movie> findByCondition(List<ConditionalCriteria> condition) {
		return findByCondition(condition, getPersistentClass());
	}

	public <R> List<R> findByCondition(List<ConditionalCriteria> condition, Class<R> resultType) {

		FindByConditionAccess2<R> ao = createFindByConditionAccess(resultType);

		ao.setCondition(condition);
		ao.execute();
		return ao.getResult();
	}

	/**
	 * Delegates to {@link org.sculptor.framework.accessapi.FindByIdAccess}
	 */
	public Movie findById(Long id) throws MovieNotFoundException {

		FindByIdAccess<Movie, Long> ao = createFindByIdAccess();

		ao.setId(id);
		ao.execute();
		if (ao.getResult() == null) {
			throw new MovieNotFoundException("No Movie found with id: " + id);
		}
		return ao.getResult();
	}

	/**
	 * Delegates to {@link org.sculptor.framework.accessapi.FindAllAccess}
	 */
	public List<Movie> findAll() {
		return findAll(getPersistentClass());
	}

	public <R> List<R> findAll(Class<R> resultType) {

		FindAllAccess2<R> ao = createFindAllAccess(resultType);

		ao.execute();
		return ao.getResult();
	}

	/**
	 * Delegates to {@link org.sculptor.framework.accessapi.SaveAccess}
	 */
	public Movie save(Movie entity) {

		SaveAccess<Movie> ao = createSaveAccess();

		ao.setEntity(entity);
		ao.execute();
		return ao.getResult();
	}

	/**
	 * Delegates to {@link org.sculptor.framework.accessapi.DeleteAccess}
	 */
	public void delete(Movie entity) {

		DeleteAccess<Movie> ao = createDeleteAccess();

		ao.setEntity(entity);
		ao.execute();
	}

	@PersistenceContext(unitName = "MovieAppmodelOneEntityManagerFactory")
	private EntityManager entityManager;

	/**
	 * Dependency injection
	 */
	@PersistenceContext(unitName = "MovieAppmodelOneEntityManagerFactory")
	protected void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	// convenience method
	protected FindByConditionAccess2<Movie> createFindByConditionAccess() {
		return createFindByConditionAccess(getPersistentClass(), getPersistentClass());
	}

	// convenience method
	protected <R> FindByConditionAccess2<R> createFindByConditionAccess(Class<R> resultType) {
		return createFindByConditionAccess(getPersistentClass(), resultType);
	}

	protected <T, R> FindByConditionAccess2<R> createFindByConditionAccess(Class<T> type, Class<R> resultType) {
		JpaFindByConditionAccessImplGeneric<T, R> ao = new JpaFindByConditionAccessImplGeneric<T, R>(type, resultType);
		ao.setEntityManager(getEntityManager());
		return ao;
	}

	protected FindByIdAccess<Movie, Long> createFindByIdAccess() {
		JpaFindByIdAccessImpl<Movie, Long> ao = new JpaFindByIdAccessImpl<Movie, Long>(getPersistentClass());
		ao.setEntityManager(getEntityManager());
		return ao;
	}

	// convenience method
	protected FindAllAccess2<Movie> createFindAllAccess() {
		return createFindAllAccess(getPersistentClass(), getPersistentClass());
	}

	// convenience method
	protected <R> FindAllAccess2<R> createFindAllAccess(Class<R> resultType) {
		return createFindAllAccess(getPersistentClass(), resultType);
	}

	protected <T, R> FindAllAccess2<R> createFindAllAccess(Class<T> type, Class<R> resultType) {
		JpaFindAllAccessImplGeneric<T, R> ao = new JpaFindAllAccessImplGeneric<T, R>(type, resultType);
		ao.setEntityManager(getEntityManager());
		return ao;
	}

	protected SaveAccess<Movie> createSaveAccess() {
		JpaSaveAccessImpl<Movie> ao = new JpaSaveAccessImpl<Movie>(getPersistentClass());
		ao.setEntityManager(getEntityManager());
		return ao;
	}

	protected DeleteAccess<Movie> createDeleteAccess() {
		JpaDeleteAccessImpl<Movie> ao = new JpaDeleteAccessImpl<Movie>(getPersistentClass());
		ao.setEntityManager(getEntityManager());
		return ao;
	}

	protected Class<Movie> getPersistentClass() {
		return Movie.class;
	}

}
