package br.com.fiap.controller.interceptor;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

/**
 * Abre e fecha transação.
 * Passa para o JSF tratar a requisição, e pegando o retorno da lógica
 * @author Abimael
 *
 */
@Interceptor
@Transactional
public class TransactionInterceptor {

	@Inject
	private Logger logger;
	
	@Inject
	private EntityManager em;
	
	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception{
		logger.debug("Transação iniciada (begin)    ...");
		
		em.getTransaction().begin();
		
		Object resultado = ctx.proceed();
		
		em.getTransaction().commit();
		
		logger.debug("Transação finalizada (commit) ...");
		
		return resultado;
	}
}
