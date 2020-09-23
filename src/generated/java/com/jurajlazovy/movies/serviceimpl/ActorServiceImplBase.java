package com.jurajlazovy.movies.serviceimpl;

import com.jurajlazovy.movies.domain.Actor;
import com.jurajlazovy.movies.domain.ActorRepository;
import com.jurajlazovy.movies.exception.ActorNotFoundException;
import com.jurajlazovy.movies.serviceapi.ActorService;
import java.util.List;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.context.ServiceContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Generated base class for implementation of ActorService.
 * <p>
 * Make sure that subclass defines the following annotations:
 * 
 * <pre>
 * @org.springframework.stereotype.Service("actorService")
 * </pre>
 *
 */
public abstract class ActorServiceImplBase implements ActorService {

	public ActorServiceImplBase() {
	}

	@Autowired
	private ActorRepository actorRepository;

	protected ActorRepository getActorRepository() {
		return actorRepository;
	}

	/**
	 * Delegates to {@link com.jurajlazovy.movies.domain.ActorRepository#findByCondition}
	 */
	public List<Actor> findByCondition(ServiceContext ctx, List<ConditionalCriteria> condition) {
		return actorRepository.findByCondition(condition);
	}

	/**
	 * Delegates to {@link com.jurajlazovy.movies.domain.ActorRepository#findById}
	 */
	public Actor findById(ServiceContext ctx, Long id) throws ActorNotFoundException {
		return actorRepository.findById(id);
	}

	/**
	 * Delegates to {@link com.jurajlazovy.movies.domain.ActorRepository#findAll}
	 */
	public List<Actor> findAll(ServiceContext ctx) {
		return actorRepository.findAll();
	}

	/**
	 * Delegates to {@link com.jurajlazovy.movies.domain.ActorRepository#save}
	 */
	public Actor save(ServiceContext ctx, Actor entity) {
		return actorRepository.save(entity);
	}

	/**
	 * Delegates to {@link com.jurajlazovy.movies.domain.ActorRepository#delete}
	 */
	public void delete(ServiceContext ctx, Actor entity) {
		actorRepository.delete(entity);
	}

}
