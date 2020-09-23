package com.jurajlazovy.movies.serviceimpl;

import com.jurajlazovy.movies.domain.*;

import java.util.ArrayList;
import java.util.List;

import com.jurajlazovy.movies.exception.MovieNotFoundException;
import com.jurajlazovy.movies.serviceapi.MovieService;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.accessapi.ConditionalCriteriaBuilder;
import org.sculptor.framework.context.ServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of MovieService.
 */
@Service("movieService")
public class MovieServiceImpl extends MovieServiceImplBase {

	public MovieServiceImpl() {
	}

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private DirectorRepository directorRepository;

	// tato metoda da vyselectovane Movies, ale bez Actors
	public List<Movie> findMoviesByCondition(ServiceContext ctx) {
		List<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(Movie.class)
				.orderBy(MovieProperties.movieName()).build(); // zorad vsetky podla movieName

		return movieRepository.findByCondition(criteria);
	}

	// Tato metoda da Movies aj s Actors. Je to tu aj preto, lebo v resourcoch findAll nechodi
	public List<Movie> showMoviesWithActors(ServiceContext ctx) {

		List<Movie> result = movieRepository.findAll();

		// toto tam musi byt, lebo inak to v MovieResource nefunguje (nenajde actors, neviem preco)
		List<Actor> actors = new ArrayList<>();
		for(Movie movie : result) {
			//System.out.println("Actors last name = " + movie.getActors().get(i).getLastName());
			actors.addAll(movie.getActors());
		}

		return result;
	}

	public List<Movie> findMoviesByDirector(ServiceContext ctx, Director director) {
		List<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(Movie.class)
				.withProperty(MovieProperties.director()).eq(director) // movies directora (jeho id)
				.orderBy(MovieProperties.movieName()).build(); // zorad vsetky podla movieName

		return movieRepository.findByCondition(criteria);
	}


	public List<Movie> findMoviesByDirectorName(ServiceContext ctx, String firstName, String lastName) {
		List<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(Movie.class)
				.withProperty(MovieProperties.director().firstName()).eq(firstName) // director podla firstName
				.withProperty(MovieProperties.director().lastName()).eq(lastName)   // aj lastName
				.orderBy(MovieProperties.movieName()).build(); // zorad vsetky podla movieName

		return movieRepository.findByCondition(criteria);
	}

	public List<Movie> findMoviesByActor(ServiceContext ctx, String firstName, String lastName) {

		List<Movie> allMovies = movieRepository.findAll();

		List<Movie> actorMovies = new ArrayList<>();
		for(Movie movie : allMovies) {
			for (int i = 0; i < movie.getActors().size(); i++) {
				if (movie.getActors().get(i).getFirstName().equals(firstName)
				&& movie.getActors().get(i).getLastName().equals(lastName)) {
					actorMovies.add(movie);
				}
			}
		}

		return actorMovies;
	}

	@Override
	public List<Movie> findMoviesByLanguages(ServiceContext ctx) {
		List<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(Movie.class)
				.withProperty(MovieProperties.movieLang()).in("cesky", "japan").build();
		        // ceske a japonske movies (language)

		return movieRepository.findByCondition(criteria);
	}

	@Override
	public List<Movie> findAllMovies(ServiceContext ctx) {
		return movieRepository.findAll();
	}

}
