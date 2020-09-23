package com.jurajlazovy.movies.domain;

import com.jurajlazovy.movies.domain.Actor;
import com.jurajlazovy.movies.exception.ActorNotFoundException;
import java.util.List;
import org.sculptor.framework.accessapi.ConditionalCriteria;

/**
 * Generated interface for Repository for Actor
 */
public interface ActorRepository {

	public final static String BEAN_ID = "actorRepository";

	public List<Actor> findByCondition(List<ConditionalCriteria> condition);

	public Actor findById(Long id) throws ActorNotFoundException;

	public List<Actor> findAll();

	public Actor save(Actor entity);

	public void delete(Actor entity);

}
