package com.jurajlazovy.web.rest;

import com.jurajlazovy.movies.domain.Actor;
import com.jurajlazovy.movies.domain.Director;
import com.jurajlazovy.movies.domain.Movie;
import com.jurajlazovy.movies.exception.MovieNotFoundException;
import com.jurajlazovy.movies.serviceapi.ActorService;
import com.jurajlazovy.movies.serviceapi.DirectorService;
import com.jurajlazovy.movies.serviceapi.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Implementation of MovieResource.
 */
@Controller
public class MovieResource extends MovieResourceBase {

    public MovieResource() {
    }

    @Autowired
    private DirectorService directorService;
    @Autowired
    private ActorService actorService;
    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/movie/form", method = RequestMethod.GET)
    public String createForm(ModelMap modelMap) {
        Movie entity = new Movie();
        modelMap.addAttribute("entity", entity);
        return "movie/create";
    }

    // Doplnena overwritnuta metoda pre vytvorenie noveho movie
    @RequestMapping(value = "/movie", method = RequestMethod.POST)
    public String create(@RequestBody Movie entity) {

        Long directorId = entity.getDirector().getId(); // moznost nacitat directora podla id
        if (directorId != null) {
            try {
                Director director = directorService.findById(serviceContext(), directorId);
                entity.setDirector(director);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // takto nacita tiez actors
        for (int i = 0; i < entity.getActors().size(); i++) {
            Long actorID = entity.getActors().get(i).getId();
            if (actorID != null) {
                try {
                    Actor actor = actorService.findById(serviceContext(), actorID);
                    entity.getActors().set(i, actor);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return super.create(entity);
    }

    // spustenie metody findMoviesByCondition. Dáta pomocou curl prikazu.
    @RequestMapping(value = "/movie/find", method = RequestMethod.POST)
    public String find(@RequestBody Movie entity) {
        // vysledok selectu, ale nenacita actors
        List<Movie> results = movieService.findMoviesByCondition(serviceContext());
        System.out.println("size = " + results.size());

        // takto nacita vsetky movies nezoradene, ale aj s actors
        List<Movie> movies = movieService.showMoviesWithActors(serviceContext());

        // selectovane results doplnim o actors s movies
        for (Movie result : results) {
            Long resultId = result.getId();
            for (Movie movie : movies) {
                if (movie.getId().equals(resultId)) { // ak resultId = movieId
                    System.out.println("Movie named " + movie.getMovieName() +
                            ", directed by " + movie.getDirector().getFirstName() +
                            " " + movie.getDirector().getLastName() +
                            " starring with: ");
                    for (int i = 0; i < movie.getActors().size(); i++) {
                        System.out.println(movie.getActors().get(i).getFirstName() +
                                " " + movie.getActors().get(i).getLastName());
                    }
                    break;
                }
            }
        }

        return String.format("redirect:/rest/movie/%s", results);
    }

    // spustenie metody findMoviesByDirector. Dáta pomocou curl prikazu.
    @RequestMapping(value = "/movie/finddirector", method = RequestMethod.POST)
    public String findDirector(@RequestBody Movie entity) {

        // aby nacital directora podla id (funguje len podla id, nie podla inych parametrov, napr.  lastName)
        Long directorId = entity.getDirector().getId();
        if (directorId != null) {
            try {
                Director director = directorService.findById(serviceContext(), directorId);
                entity.setDirector(director);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Director director = entity.getDirector();
        List<Movie> results = movieService.findMoviesByDirector(serviceContext(), director);
        System.out.println("size = " + results.size());

        System.out.println("All movies in db directed by " + director.getFirstName() +
                " " + director.getLastName() + ": ");
        for (Movie movie : results) {
            System.out.println("  " + movie.getMovieName());
        }

        return String.format("redirect:/rest/movie/%s", results);
    }

    // spustenie metody findMoviesByLanguage. Dáta pomocou curl prikazu.
    @RequestMapping(value = "/movie/findbylang", method = RequestMethod.POST)
    public String findByLang(@RequestBody Movie entity) {

        List<Movie> result = movieService.findMoviesByLanguages(serviceContext());
        System.out.println("size = " + result.size());

        for (Movie movie : result) {
            System.out.println("Director " + movie.getDirector().getFirstName() +
                    " " + movie.getDirector().getLastName() +
                    ", movie name = " + movie.getMovieName() +
                    ", movie release date = " + movie.getReleaseDate() +
                    ", movie language = " + movie.getMovieLang());
        }

        return String.format("redirect:/rest/movie/%s", result);
    }

    // Select - najdi pocet filmov pre jednotlivych directorov
    // Spustenie metody findAllMovies a findAllDirectorsOrdered.
    // Dáta klasicky pomocou curl prikazu.
    @RequestMapping(value = "/movie/findmoviesbydirectors", method = RequestMethod.POST)
    public String findMoviesByDirectors(@RequestBody Movie entity) {

        List<Movie> movies = movieService.findAllMovies(serviceContext());
        List<Director> directors = directorService.findAllDirectorsOrdered(serviceContext());

        for (Director director : directors) {
            int movieNum = 0;
            for (Movie movie : movies) {
                if (movie.getDirector().getId().equals(director.getId())) {
                    movieNum++;
                }
            }
            System.out.println("Director " + director.getFirstName() +
                    " " + director.getLastName() +
                    " has " + movieNum + " movies in our db.");
        }

        return String.format("redirect:/rest/movie/%s", movies);
    }

}
