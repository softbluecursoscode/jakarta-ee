package br.com.softblue.javaee.ejb;

import javax.ejb.EJB;
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
public class MyBean {

	@PersistenceContext
	private EntityManager em;
	
	@EJB
	private MyBean2 myBean2;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void mA() {
		Livro l1 = em.find(Livro.class, 1);
		l1.setNumPaginas(100);
		
		myBean2.mB();
	}
}
