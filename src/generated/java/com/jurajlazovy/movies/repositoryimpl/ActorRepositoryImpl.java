package com.jurajlazovy.movies.repositoryimpl;

import com.jurajlazovy.movies.domain.Actor;
import com.jurajlazovy.movies.domain.ActorRepository;
import com.jurajlazovy.movies.exception.ActorNotFoundException;
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
 * Repository implementation for Actor
 */
@Repository("actorRepository")
public class ActorRepositoryImpl implements ActorRepository {

	public ActorRepositoryImpl() {
	}

	/**
	 * Delegates to {@link org.sculptor.framework.accessapi.FindByConditionAccess}
	 */
	public List<Actor> findByCondition(List<ConditionalCriteria> condition) {
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
	public Actor findById(Long id) throws ActorNotFoundException {

		FindByIdAccess<Actor, Long> ao = createFindByIdAccess();

		ao.setId(id);
		ao.execute();
		if (ao.getResult() == null) {
			throw new ActorNotFoundException("No Actor found with id: " + id);
		}
		return ao.getResult();
	}

	/**
	 * Delegates to {@link org.sculptor.framework.accessapi.FindAllAccess}
	 */
	public List<Actor> findAll() {
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
	public Actor save(Actor entity) {

		SaveAccess<Actor> ao = createSaveAccess();

		ao.setEntity(entity);
		ao.execute();
		return ao.getResult();
	}

	/**
	 * Delegates to {@link org.sculptor.framework.accessapi.DeleteAccess}
	 */
	public void delete(Actor entity) {

		DeleteAccess<Actor> ao = createDeleteAccess();

		ao.setEntity(entity);
		ao.execute();
	}

	@PersistenceContext(unitName = "MovieAppEntityManagerFactory")
	private EntityManager entityManager;

	/**
	 * Dependency injection
	 */
	@PersistenceContext(unitName = "MovieAppEntityManagerFactory")
	protected void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	// convenience method
	protected FindByConditionAccess2<Actor> createFindByConditionAccess() {
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

	protected FindByIdAccess<Actor, Long> createFindByIdAccess() {
		JpaFindByIdAccessImpl<Actor, Long> ao = new JpaFindByIdAccessImpl<Actor, Long>(getPersistentClass());
		ao.setEntityManager(getEntityManager());
		return ao;
	}

	// convenience method
	protected FindAllAccess2<Actor> createFindAllAccess() {
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

	protected SaveAccess<Actor> createSaveAccess() {
		JpaSaveAccessImpl<Actor> ao = new JpaSaveAccessImpl<Actor>(getPersistentClass());
		ao.setEntityManager(getEntityManager());
		return ao;
	}

	protected DeleteAccess<Actor> createDeleteAccess() {
		JpaDeleteAccessImpl<Actor> ao = new JpaDeleteAccessImpl<Actor>(getPersistentClass());
		ao.setEntityManager(getEntityManager());
		return ao;
	}

	protected Class<Actor> getPersistentClass() {
		return Actor.class;
	}

}
