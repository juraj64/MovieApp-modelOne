package com.jurajlazovy.movies.serviceapi;

import com.jurajlazovy.movies.domain.Director;
import com.jurajlazovy.movies.domain.Movie;
import com.jurajlazovy.movies.exception.MovieNotFoundException;
import java.util.List;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.context.ServiceContext;

/**
 * Generated interface for the Service MovieService.
 */
public interface MovieService {

	public final static String BEAN_ID = "movieService";

	public List<Movie> findMoviesByCondition(ServiceContext ctx);

	public List<Movie> showMoviesWithActors(ServiceContext ctx);

	public List<Movie> findMoviesByDirector(ServiceContext ctx, Director director);

	public List<Movie> findMoviesByDirectorName(ServiceContext ctx, String firstName, String lastName);

	public List<Movie> findMoviesByActor(ServiceContext ctx, String firstName, String lastName);

	public List<Movie> findMoviesByLanguages(ServiceContext ctx);

	public List<Movie> findAllMovies(ServiceContext ctx);

	public List<Movie> findByCondition(ServiceContext ctx, List<ConditionalCriteria> condition);

	public Movie findById(ServiceContext ctx, Long id) throws MovieNotFoundException;

	public List<Movie> findAll(ServiceContext ctx);

	public Movie save(ServiceContext ctx, Movie entity);

	public void delete(ServiceContext ctx, Movie entity);

}
