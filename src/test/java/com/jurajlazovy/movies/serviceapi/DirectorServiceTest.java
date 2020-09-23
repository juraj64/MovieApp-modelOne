package com.jurajlazovy.movies.serviceapi;

import com.jurajlazovy.movies.serviceapi.DirectorService;
import org.junit.Test;
import org.sculptor.framework.test.AbstractDbUnitJpaTests;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Spring based transactional test with DbUnit support.
 */
public class DirectorServiceTest extends AbstractDbUnitJpaTests implements DirectorServiceTestBase {

	@Autowired
	protected DirectorService directorService;

	@Test
	public void testFindDirectorsByCondition() throws Exception {
		// TODO Auto-generated method stub
		fail("testFindDirectorsByCondition not implemented");
	}

	@Test
	public void testFindDirectorsByBirth() throws Exception {
		// TODO Auto-generated method stub
		fail("testFindDirectorsByBirth not implemented");
	}

	@Test
	public void testFindAllDirectorsOrdered() throws Exception {
		// TODO Auto-generated method stub
		fail("testFindAllDirectorsOrdered not implemented");
	}

	@Test
	public void testFindRussianDirectors() throws Exception {
		// TODO Auto-generated method stub
		fail("testFindRussianDirectors not implemented");
	}

	@Test
	public void testFindDirectorsByNationality() throws Exception {
		// TODO Auto-generated method stub
		fail("testFindDirectorsByNationality not implemented");
	}

	@Test
	public void testFindByCondition() throws Exception {
		// TODO Auto-generated method stub
		fail("testFindByCondition not implemented");
	}

	@Test
	public void testFindById() throws Exception {
		// TODO Auto-generated method stub
		fail("testFindById not implemented");
	}

	@Test
	public void testFindAll() throws Exception {
		// TODO Auto-generated method stub
		fail("testFindAll not implemented");
	}

	@Test
	public void testSave() throws Exception {
		// TODO Auto-generated method stub
		fail("testSave not implemented");
	}

	@Test
	public void testDelete() throws Exception {
		// TODO Auto-generated method stub
		fail("testDelete not implemented");
	}
}
