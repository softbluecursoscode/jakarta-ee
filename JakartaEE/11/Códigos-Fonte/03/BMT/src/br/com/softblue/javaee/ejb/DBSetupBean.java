package br.com.softblue.javaee.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.softblue.javaee.model.Livro;

@Singleton
@Startup
public class DBSetupBean {

	@PersistenceContext
	private EntityManager em;

	@PostConstruct
	public void setup() {
		Livro l1 = new Livro();
		l1.setId(1);
		l1.setTitulo("Java");
		l1.setNumPaginas(530);
		em.persist(l1);
		
		Livro l2 = new Livro();
		l2.setId(2);
		l2.setTitulo("Orientação a Objetos");
		l2.setNumPaginas(260);
		em.persist(l2);
		
		Livro l3 = new Livro();
		l3.setId(3);
		l3.setTitulo("Expressões Lambda");
		l3.setNumPaginas(160);
		em.persist(l3);
	}
}
