package br.com.fiap.util;

import javax.persistence.EntityManager;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JPAUtilTest {

	private EntityManager entityManager;
	private JPAUtilForTest jpaUtil;
	
	@Before
	public void setUp() throws Exception {
		jpaUtil = new JPAUtilForTest();
	}

	@Test
	public void testGetEntityManager() {
		entityManager = jpaUtil.getEntityManager();
		
		Assert.assertNotNull("Não obteve o entityManager", entityManager);
	}

	@After
	public void tearDown() throws Exception {
		entityManager.close();
	}
	
}
