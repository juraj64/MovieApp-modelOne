package com.jurajlazovy.movies.serviceimpl;

import com.jurajlazovy.movies.domain.Director;
import com.jurajlazovy.movies.domain.DirectorRepository;
import com.jurajlazovy.movies.exception.DirectorNotFoundException;
import com.jurajlazovy.movies.serviceapi.DirectorService;
import java.util.List;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.context.ServiceContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Generated base class for implementation of DirectorService.
 * <p>
 * Make sure that subclass defines the following annotations:
 * 
 * <pre>
 * @org.springframework.stereotype.Service("directorService")
 * </pre>
 *
 */
public abstract class DirectorServiceImplBase implements DirectorService {

	public DirectorServiceImplBase() {
	}

	@Autowired
	private DirectorRepository directorRepository;

	protected DirectorRepository getDirectorRepository() {
		return directorRepository;
	}

	/**
	 * Delegates to {@link com.jurajlazovy.movies.domain.DirectorRepository#findByCondition}
	 */
	public List<Director> findByCondition(ServiceContext ctx, List<ConditionalCriteria> condition) {
		return directorRepository.findByCondition(condition);
	}

	/**
	 * Delegates to {@link com.jurajlazovy.movies.domain.DirectorRepository#findById}
	 */
	public Director findById(ServiceContext ctx, Long id) throws DirectorNotFoundException {
		return directorRepository.findById(id);
	}

	/**
	 * Delegates to {@link com.jurajlazovy.movies.domain.DirectorRepository#findAll}
	 */
	public List<Director> findAll(ServiceContext ctx) {
		return directorRepository.findAll();
	}

	/**
	 * Delegates to {@link com.jurajlazovy.movies.domain.DirectorRepository#save}
	 */
	public Director save(ServiceContext ctx, Director entity) {
		return directorRepository.save(entity);
	}

	/**
	 * Delegates to {@link com.jurajlazovy.movies.domain.DirectorRepository#delete}
	 */
	public void delete(ServiceContext ctx, Director entity) {
		directorRepository.delete(entity);
	}

}
