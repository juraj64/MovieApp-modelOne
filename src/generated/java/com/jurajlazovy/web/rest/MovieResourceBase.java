package com.jurajlazovy.web.rest;

import com.jurajlazovy.movies.domain.Movie;
import com.jurajlazovy.movies.exception.MovieNotFoundException;
import com.jurajlazovy.movies.serviceapi.MovieService;
import java.io.IOException;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.sculptor.framework.context.ServiceContext;
import org.sculptor.framework.context.ServiceContextStore;
import org.sculptor.framework.errorhandling.OptimisticLockingException;
import org.sculptor.framework.errorhandling.SystemException;
import org.sculptor.framework.errorhandling.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Generated base class for implementation of MovieResource.
 * <p>
 * Make sure that subclass defines the following annotations:
 * 
 * <pre>
 * @org.springframework.stereotype.Controller
 * </pre>
 */
public abstract class MovieResourceBase {

	public MovieResourceBase() {
	}

	protected ServiceContext serviceContext() {
		return ServiceContextStore.get();
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	}

	@Autowired
	private MovieService movieService;

	protected MovieService getMovieService() {
		return movieService;
	}

	@RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long id, ModelMap modelMap) throws MovieNotFoundException {
		Movie result = movieService.findById(serviceContext(), id);
		modelMap.addAttribute("result", result);
		return "movie/show";
	}

	@RequestMapping(value = "/movie", method = RequestMethod.GET)
	public String showAll(ModelMap modelMap) {
		List<Movie> result = movieService.findAll(serviceContext());
		modelMap.addAttribute("result", result);
		return "movie/showlist";
	}

	@RequestMapping(value = "/movie", method = RequestMethod.POST)
	public String create(@RequestBody Movie entity) {
		Movie result = movieService.save(serviceContext(), entity);
		return String.format("redirect:/rest/movie/%s", result.getId());
	}

	@RequestMapping(value = "/movie/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) throws Exception {
		Movie deleteObj = movieService.findById(serviceContext(), id);
		movieService.delete(serviceContext(), deleteObj);
		return "redirect:/rest/movie";
	}

	/*
	 * @org.springframework.web.bind.annotation.RequestMapping(value = "/movie/form",
	 * method=org.springframework.web.bind.annotation.RequestMethod.GET) public String createForm(org.springframework.ui.ModelMap
	 * modelMap )
	 */
	public abstract String createForm(ModelMap modelMap);

	/**
	 * This method is needed for form data POST. Delegates to {@link #create}
	 */
	@RequestMapping(value = "/movie", method = RequestMethod.POST, headers = "content-type=application/x-www-form-urlencoded")
	public String createFromForm(@ModelAttribute("entity") Movie entity) {
		return create(entity);
	}

	@ExceptionHandler
	public void handleException(MovieNotFoundException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value(), e.getMessage());
	}

	@ExceptionHandler
	public void handleException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
	}

	@ExceptionHandler
	public void handleException(ValidationException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
	}

	@ExceptionHandler
	public void handleException(SystemException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.SERVICE_UNAVAILABLE.value(), e.getMessage());
	}

	@ExceptionHandler
	public void handleException(OptimisticLockingException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.CONFLICT.value(), e.getMessage());
	}

}
