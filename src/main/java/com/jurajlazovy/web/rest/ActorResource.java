package com.jurajlazovy.web.rest;

import com.jurajlazovy.movies.domain.Actor;
import com.jurajlazovy.movies.domain.Director;
import com.jurajlazovy.movies.domain.Gender;
import com.jurajlazovy.movies.domain.Movie;
import com.jurajlazovy.movies.exception.ActorNotFoundException;
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
 * Implementation of ActorResource.
 */
@Controller
public class ActorResource extends ActorResourceBase {

    public ActorResource() {
    }

    @Autowired
    private ActorService actorService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private DirectorService directorService;

    @RequestMapping(value = "/actor/form", method = RequestMethod.GET)
    public String createForm(ModelMap modelMap) {
        Actor entity = new Actor();
        modelMap.addAttribute("entity", entity);
        return "actor/create";
    }

    // spustenie metody findActorsByCondition. Dáta pomocou curl prikazu.
    @RequestMapping(value = "/actor/find", method = RequestMethod.POST)
    public String find(@RequestBody Actor entity) {

        List<Actor> result = actorService.findActorsByCondition(serviceContext());
        System.out.println("size = " + result.size());

        for (Actor actor : result) {
            System.out.println("Actor's name = " + actor.getFirstName() +
                    " " + actor.getLastName());
        }

        return String.format("redirect:/rest/actor/%s", result);
    }

    // spustenie metody findActorsByGender. Dáta pomocou curl prikazu.
    @RequestMapping(value = "/actor/findgender", method = RequestMethod.POST)
    public String findGender(@RequestBody Actor entity) {

        Gender gender = entity.getGender();

        List<Actor> result = actorService.findActorsByGender(serviceContext(), gender);
        System.out.println("size = " + result.size());

        for (Actor actor : result) {
            System.out.println("Actor's name = " + actor.getFirstName() +
                    " " + actor.getLastName());
        }

        return String.format("redirect:/rest/actor/%s", result);
    }

    // spustenie metody findMoviesbyActor. Dáta pomocou curl prikazu.
    // Musel som to presunut z MovieResource sem, lebo tam nevedel nacitat udaje o actorovi
    @RequestMapping(value = "/actor/findmovies", method = RequestMethod.POST)
    public String findMovies(@RequestBody Actor entity) {

        String firstName = entity.getFirstName();
        String lastName = entity.getLastName();
        List<Movie> result = movieService.findMoviesByActor(serviceContext(), firstName, lastName);
        System.out.println("size = " + result.size());

        System.out.println("All movies in db starring with " + firstName +
                " " + lastName + ": ");
        for (Movie movie : result) {
            System.out.println("  " + movie.getMovieName());
        }

        return String.format("redirect:/rest/actor/%s", result);
    }

    // SELECT vyuzitim unionu - vsetky zenske herecky a reziseri ruskej narodnosti
    @RequestMapping(value = "/actor/finddirectorsandactors", method = RequestMethod.POST)
    public String findDirectorsAndActors(@RequestBody Actor entity) {

        List<Director> resultDir = directorService.findRussianDirectors(serviceContext());
        List<Actor> resultAct = actorService.findActorsByCondition(serviceContext());

        for (Director director : resultDir) {
            System.out.println("Director " + director.getFirstName() +
                    " " + director.getLastName() +
                    ", born in " + director.getDateOfBirth());
        }

        for (Actor actor : resultAct) {
            System.out.println("Actor " + actor.getFirstName() +
                    " " + actor.getLastName() +
                    ", born in " + actor.getDateOfBirth());
        }

        return String.format("redirect:/rest/actor/%s", resultAct);
    }

    // SELECT vyuzitim unionu - vsetky zenske herecky a reziseri ruskej narodnosti
    //  Takto mi to nefunguje. Ked zadam curl prikaz, tak to zmrzne. Zrejme, lebo su tam dve rozne entity
    @RequestMapping(value = "/actor/findactorsanddirectors", method = RequestMethod.POST)
    public String findActorsAndDirectors(@RequestBody Actor entityAct, Director entityDir) {

        Gender gender = entityAct.getGender();
        List<Actor> resultAct = actorService.findActorsByGender(serviceContext(), gender);

        String nationality = entityDir.getNationality();
        List<Director> resultDir = directorService.findDirectorsByNationality(serviceContext(), nationality);

        for (Actor actor : resultAct) {
            System.out.println("Actor " + actor.getFirstName() +
                    " " + actor.getLastName() +
                    ", born in " + actor.getDateOfBirth());
        }

        for (Director director : resultDir) {
            System.out.println("Director " + director.getFirstName() +
                    " " + director.getLastName() +
                    ", born in " + director.getDateOfBirth());
        }

        return String.format("redirect:/rest/actor/%s", resultAct);
    }

}
