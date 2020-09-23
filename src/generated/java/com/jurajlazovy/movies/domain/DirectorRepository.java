package com.jurajlazovy.movies.domain;

import com.jurajlazovy.movies.domain.Director;
import com.jurajlazovy.movies.exception.DirectorNotFoundException;
import java.util.List;
import org.sculptor.framework.accessapi.ConditionalCriteria;

/**
 * Generated interface for Repository for Director
 */
public interface DirectorRepository {

	public final static String BEAN_ID = "directorRepository";

	public List<Director> findByCondition(List<ConditionalCriteria> condition);

	public Director findById(Long id) throws DirectorNotFoundException;

	public List<Director> findAll();

	public Director save(Director entity);

	public void delete(Director entity);

}
