package com.jurajlazovy.movies.domain;

import com.jurajlazovy.movies.domain.Movie;
import com.jurajlazovy.movies.exception.MovieNotFoundException;
import java.util.List;
import org.sculptor.framework.accessapi.ConditionalCriteria;

/**
 * Generated interface for Repository for Movie
 */
public interface MovieRepository {

	public final static String BEAN_ID = "movieRepository";

	public List<Movie> findByCondition(List<ConditionalCriteria> condition);

	public Movie findById(Long id) throws MovieNotFoundException;

	public List<Movie> findAll();

	public Movie save(Movie entity);

	public void delete(Movie entity);

}
