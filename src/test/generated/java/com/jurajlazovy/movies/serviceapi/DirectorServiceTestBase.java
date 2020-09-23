package com.jurajlazovy.movies.serviceapi;

/**
 * Definition of test methods to implement.
 */
public interface DirectorServiceTestBase {

	public void testFindDirectorsByCondition() throws Exception;

	public void testFindDirectorsByBirth() throws Exception;

	public void testFindAllDirectorsOrdered() throws Exception;

	public void testFindRussianDirectors() throws Exception;

	public void testFindDirectorsByNationality() throws Exception;

	public void testFindByCondition() throws Exception;

	public void testFindById() throws Exception;

	public void testFindAll() throws Exception;

	public void testSave() throws Exception;

	public void testDelete() throws Exception;
}
