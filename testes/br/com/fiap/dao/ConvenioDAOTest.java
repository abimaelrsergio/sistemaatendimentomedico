package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.fiap.model.dao.ConvenioDAO;
import br.com.fiap.model.entity.Convenio;
import br.com.fiap.util.JPAUtilForTest;

public class ConvenioDAOTest {

	EntityManager em;
	private ConvenioDAO convenioDAO;
	private Convenio convenio;
	private static Long id;

	@Before
	public void setUp() throws Exception {
		em = new JPAUtilForTest().getEntityManager();
		convenioDAO = new ConvenioDAO();
		convenioDAO.setEntityManager(em);
		convenio = prepararConvenio();
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testAdiciona() {
		em.getTransaction().begin();
		convenioDAO.adiciona(convenio);
		em.getTransaction().commit();
	}

	@Test
	public void testBuscarConveniosPorNome() {
		Convenio convenioEncontrado = convenioDAO
				.buscarConveniosPorNome(convenio.getNomeConvenio());
		Assert.assertNotNull("Não encontrou o convenio", convenioEncontrado);
		if (convenioEncontrado != null) {
			id = convenioEncontrado.getId();
		}
	}

	@Test
	public void testBuscaPorId() {
		Convenio convenio2 = convenioDAO.buscaPorId(id);
		Assert.assertNotNull("Não encontrou o convenio por id", convenio2);
	}

	@Test
	public void testListaTodos() {
		List<Convenio> todosConvenios = convenioDAO.listaTodos();
		Assert.assertNotNull("Não há convênios na base", todosConvenios);
	}

	@Test
	public void testAtualiza() {
		em.getTransaction().begin();
		convenio.setId(id);
		convenio.setNomeConvenio("Atualizado");
		convenioDAO.atualiza(convenio);
		em.getTransaction().commit();
	}

	@Test
	public void testRemoveT() {
		em.getTransaction().begin();
		convenio.setId(id);
		convenioDAO.remove(convenio.getId());
		em.getTransaction().commit();
	}

	private Convenio prepararConvenio() {
		Convenio convenio = new Convenio();
		convenio.setNomeConvenio("Santa Malia");
		return convenio;
	}

}
