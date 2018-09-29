package br.com.fiap.util;

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
public class JPAUtilForTest {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Atendimento");
	
	public EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
	public void close(EntityManager em){
		em.close();
	}
}
