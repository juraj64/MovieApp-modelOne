package com.jurajlazovy.movies.serviceapi;

import com.jurajlazovy.movies.serviceapi.ActorService;
import org.junit.Test;
import org.sculptor.framework.test.AbstractDbUnitJpaTests;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Spring based transactional test with DbUnit support.
 */
public class ActorServiceTest extends AbstractDbUnitJpaTests implements ActorServiceTestBase {

	@Autowired
	protected ActorService actorService;

	@Test
	public void testFindActorsByCondition() throws Exception {
		// TODO Auto-generated method stub
		fail("testFindActorsByCondition not implemented");
	}

	@Test
	public void testFindActorsByGender() throws Exception {
		// TODO Auto-generated method stub
		fail("testFindActorsByGender not implemented");
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
