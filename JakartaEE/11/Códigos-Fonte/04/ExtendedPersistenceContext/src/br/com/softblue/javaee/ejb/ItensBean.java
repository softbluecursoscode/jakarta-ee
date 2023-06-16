package br.com.softblue.javaee.ejb;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import br.com.softblue.javaee.model.Item;

@Stateful
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ItensBean {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;
		
	public void adicionarItem(Item item) {
		em.persist(item);
	}
	
	public void removerItem(int itemId) {
		Item item = em.find(Item.class, itemId);
		em.remove(item);
	}
	
	@Remove
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void finalizar() {
		System.out.println("Commit realizado!");
	}
}
