package com.jurajlazovy.web.rest;

import com.jurajlazovy.movies.domain.Director;
import com.jurajlazovy.movies.exception.DirectorNotFoundException;
import com.jurajlazovy.movies.serviceapi.DirectorService;
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
 * Generated base class for implementation of DirectorResource.
 * <p>
 * Make sure that subclass defines the following annotations:
 * 
 * <pre>
 * @org.springframework.stereotype.Controller
 * </pre>
 */
public abstract class DirectorResourceBase {

	public DirectorResourceBase() {
	}

	protected ServiceContext serviceContext() {
		return ServiceContextStore.get();
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	}

	@Autowired
	private DirectorService directorService;

	protected DirectorService getDirectorService() {
		return directorService;
	}

	@RequestMapping(value = "/director/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long id, ModelMap modelMap) throws DirectorNotFoundException {
		Director result = directorService.findById(serviceContext(), id);
		modelMap.addAttribute("result", result);
		return "director/show";
	}

	@RequestMapping(value = "/director", method = RequestMethod.GET)
	public String showAll(ModelMap modelMap) {
		List<Director> result = directorService.findAll(serviceContext());
		modelMap.addAttribute("result", result);
		return "director/showlist";
	}

	@RequestMapping(value = "/director", method = RequestMethod.POST)
	public String create(@RequestBody Director entity) {
		Director result = directorService.save(serviceContext(), entity);
		return String.format("redirect:/rest/director/%s", result.getId());
	}

	@RequestMapping(value = "/director/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) throws Exception {
		Director deleteObj = directorService.findById(serviceContext(), id);
		directorService.delete(serviceContext(), deleteObj);
		return "redirect:/rest/director";
	}

	/*
	 * @org.springframework.web.bind.annotation.RequestMapping(value = "/director/form",
	 * method=org.springframework.web.bind.annotation.RequestMethod.GET) public String createForm(org.springframework.ui.ModelMap
	 * modelMap )
	 */
	public abstract String createForm(ModelMap modelMap);

	/**
	 * This method is needed for form data POST. Delegates to {@link #create}
	 */
	@RequestMapping(value = "/director", method = RequestMethod.POST, headers = "content-type=application/x-www-form-urlencoded")
	public String createFromForm(@ModelAttribute("entity") Director entity) {
		return create(entity);
	}

	@ExceptionHandler
	public void handleException(DirectorNotFoundException e, HttpServletResponse response) throws IOException {
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
