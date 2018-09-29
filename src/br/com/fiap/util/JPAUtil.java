package br.com.fiap.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Esta classe é utilizada para abrir conexões com o banco.<br>
 * <br>
 * <b>Características desta classe:</b>
 * <p>
 * - abertura e fechamento das conexões através da CDI
 * </p>
 * @author Abimael
 *
 */
public class JPAUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaClinica");
	
	@Produces
	@RequestScoped
	public EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
	public void close(@Disposes EntityManager em){
		em.close();
	}
}
