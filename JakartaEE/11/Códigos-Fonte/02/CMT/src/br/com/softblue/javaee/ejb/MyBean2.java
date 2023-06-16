package br.com.softblue.javaee.ejb;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.softblue.javaee.model.Livro;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class MyBean2 {

	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private EJBContext ejbContext;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void mB() {
		Livro l2 = em.find(Livro.class, 2);
		l2.setNumPaginas(100);
		ejbContext.setRollbackOnly();
	}
}
