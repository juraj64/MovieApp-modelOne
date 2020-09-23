package com.jurajlazovy.movies.serviceimpl;

import com.jurajlazovy.movies.domain.Movie;
import com.jurajlazovy.movies.domain.MovieRepository;
import com.jurajlazovy.movies.exception.MovieNotFoundException;
import com.jurajlazovy.movies.serviceapi.MovieService;
import java.util.List;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.context.ServiceContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Generated base class for implementation of MovieService.
 * <p>
 * Make sure that subclass defines the following annotations:
 * 
 * <pre>
 * @org.springframework.stereotype.Service("movieService")
 * </pre>
 *
 */
public abstract class MovieServiceImplBase implements MovieService {

	public MovieServiceImplBase() {
	}

	@Autowired
	private MovieRepository movieRepository;

	protected MovieRepository getMovieRepository() {
		return movieRepository;
	}

	/**
	 * Delegates to {@link com.jurajlazovy.movies.domain.MovieRepository#findByCondition}
	 */
	public List<Movie> findByCondition(ServiceContext ctx, List<ConditionalCriteria> condition) {
		return movieRepository.findByCondition(condition);
	}

	/**
	 * Delegates to {@link com.jurajlazovy.movies.domain.MovieRepository#findById}
	 */
	public Movie findById(ServiceContext ctx, Long id) throws MovieNotFoundException {
		return movieRepository.findById(id);
	}

	/**
	 * Delegates to {@link com.jurajlazovy.movies.domain.MovieRepository#findAll}
	 */
	public List<Movie> findAll(ServiceContext ctx) {
		return movieRepository.findAll();
	}

	/**
	 * Delegates to {@link com.jurajlazovy.movies.domain.MovieRepository#save}
	 */
	public Movie save(ServiceContext ctx, Movie entity) {
		return movieRepository.save(entity);
	}

	/**
	 * Delegates to {@link com.jurajlazovy.movies.domain.MovieRepository#delete}
	 */
	public void delete(ServiceContext ctx, Movie entity) {
		movieRepository.delete(entity);
	}

}
