package br.com.softblue.javaee.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.softblue.javaee.model.Voo;
import br.com.softblue.javaee.model.VooPK;

@Stateless
public class VooBean {

	@PersistenceContext
	private EntityManager em;
	
	public void inserir(Voo voo) {
		em.persist(voo);
	}
	
	public Voo carregar(Integer numero, String empresa) {
		return em.find(Voo.class, new VooPK(numero, empresa));
	}
}
