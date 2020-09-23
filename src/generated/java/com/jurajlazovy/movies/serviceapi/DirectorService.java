package com.jurajlazovy.movies.serviceapi;

import com.jurajlazovy.movies.domain.Director;
import com.jurajlazovy.movies.exception.DirectorNotFoundException;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.context.ServiceContext;

/**
 * Generated interface for the Service DirectorService.
 */
public interface DirectorService {

	public final static String BEAN_ID = "directorService";

	public List<Director> findDirectorsByCondition(ServiceContext ctx) throws ParseException;

	public List<Director> findDirectorsByBirth(ServiceContext ctx, Date dateOfBirth);

	public List<Director> findAllDirectorsOrdered(ServiceContext ctx);

	public List<Director> findRussianDirectors(ServiceContext ctx);

	public List<Director> findDirectorsByNationality(ServiceContext ctx, String nationality);

	public List<Director> findByCondition(ServiceContext ctx, List<ConditionalCriteria> condition);

	public Director findById(ServiceContext ctx, Long id) throws DirectorNotFoundException;

	public List<Director> findAll(ServiceContext ctx);

	public Director save(ServiceContext ctx, Director entity);

	public void delete(ServiceContext ctx, Director entity);

}
