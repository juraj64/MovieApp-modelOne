package com.jurajlazovy.web.rest;

import com.jurajlazovy.movies.domain.Actor;
import com.jurajlazovy.movies.domain.Director;
import com.jurajlazovy.movies.domain.Movie;
import com.jurajlazovy.movies.serviceapi.ActorService;
import com.jurajlazovy.movies.serviceapi.DirectorService;
import com.jurajlazovy.movies.serviceapi.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * Implementation of DirectorResource.
 */
@Controller
public class DirectorResource extends DirectorResourceBase {

	public DirectorResource() {
	}

	@Autowired
	private DirectorService directorService;

	@Autowired
	private MovieService movieService;

	@Autowired
	private ActorService actorService;

	@RequestMapping(value = "/director/form", method = RequestMethod.GET)
	public String createForm(ModelMap modelMap) {
		Director entity = new Director();
		modelMap.addAttribute("entity", entity);
		return "director/create";
	}

	// Vytvorenie formulara pre metodu findDirectorsByCondition.
	// Nefunguje, ani ostatne findy (HTTP ERROR 415. Problem accessing /rest/director/find.
	// Reason: Unsupported Media Type). Obdobne aj pri zadani akejkolvek novej entity (beanu)
	// Pouzivam preto len curl prikaz.
	@RequestMapping(value = "/director/form/find", method = RequestMethod.GET)
	public String findForm(ModelMap modelMap) {
		Director entity = new Director();
		modelMap.addAttribute("entity", entity);
		return "director/find";
	}

	// spustenie metody findDirectorsByCondition. Dáta pomocou curl prikazu.
	@RequestMapping(value = "/director/find", method = RequestMethod.POST)
	public String find(@RequestBody Director entity) throws ParseException {

		List<Director> result = directorService.findDirectorsByCondition(serviceContext());
		System.out.println("size = " + result.size());

		for (Director director : result) {
			System.out.println(director.getFirstName() + " " + director.getLastName() +
					" was born in " + director.getDateOfBirth());
		}

		return String.format("redirect:/rest/director/%s", result);
	}

	// spustenie metody findDirectorsByBirth. Dáta pomocou curl prikazu.
	@RequestMapping(value = "/director/findbirth", method = RequestMethod.POST)
	public String findBirth(@RequestBody Director entity) throws ParseException {

		Date dateOfBirth = entity.getDateOfBirth();
		List<Director> result = directorService.findDirectorsByBirth(serviceContext(), dateOfBirth);
		System.out.println("size = " + result.size());

		for (Director director : result) {
			System.out.println(director.getFirstName() + " " + director.getLastName() +
					" was born in " + director.getDateOfBirth());
		}

		return String.format("redirect:/rest/director/%s", result);
	}

	// spustenie metody findMoviesbyDirectorName. Dáta pomocou curl prikazu.
	// Musel som to presunut z MovieResource sem, lebo tam nevedel nacitat udaje o directorovi
	@RequestMapping(value = "/director/findmovies", method = RequestMethod.POST)
	public String findMovies(@RequestBody Director entity) {

		String firstName = entity.getFirstName();
		String lastName = entity.getLastName();
		List<Movie> result = movieService.findMoviesByDirectorName(serviceContext(), firstName, lastName);
		System.out.println("size = " + result.size());

		System.out.println("All movies in db directed by " + firstName +
				" " + lastName + ": ");
		for (Movie movie : result) {
			System.out.println("  " + movie.getMovieName());
		}

		return String.format("redirect:/rest/director/%s", result);
	}

	// SELECT - najdi vsetkych hercov hrajucich vo filmoch daneho rezisera
	// metody findMoviesByDirectorName a showMoviesWithActors
	@RequestMapping(value = "/director/findactors", method = RequestMethod.POST)
	public String findActors(@RequestBody Director entity) {

		// movies daneho directora (bez actors)
		String firstName = entity.getFirstName();
		String lastName = entity.getLastName();
		List<Movie> results = movieService.findMoviesByDirectorName(serviceContext(), firstName, lastName);

		// vsetky movies aj s actors
		List<Movie> movies = movieService.showMoviesWithActors(serviceContext());

		HashSet<Actor> actors = new HashSet<Actor>(); // kazdy element (actor) iba raz

		for (Movie result : results) {
			for (Movie movie : movies) {
				if (movie.getId().equals(result.getId())) { // ak ide o to iste movie
					actors.addAll(movie.getActors()); // pridaj actors z movie (ale kazdeho iba raz)
					break;
				}
			}
		}

		System.out.println("All actors in db starring in movies directed by " + firstName +
				" " + lastName + ": ");
		for (Actor actor : actors) {
			System.out.println("  " + actor.getFirstName() + " " + actor.getLastName());
		}

		return String.format("redirect:/rest/director/%s", results);
	}

}
