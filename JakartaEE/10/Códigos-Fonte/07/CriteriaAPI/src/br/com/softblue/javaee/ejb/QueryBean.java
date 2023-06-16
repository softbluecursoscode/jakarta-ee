package br.com.softblue.javaee.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import br.com.softblue.javaee.model.Aula;
import br.com.softblue.javaee.model.Aula_;
import br.com.softblue.javaee.model.Curso;
import br.com.softblue.javaee.model.Curso_;
import br.com.softblue.javaee.model.Modulo;
import br.com.softblue.javaee.model.Modulo_;

@Singleton
@Startup
public class QueryBean {

	@PersistenceContext
	private EntityManager em;
	
	@PostConstruct
	public void setup() {
		Curso c1 = new Curso("JavaEE");
		em.persist(c1);
		
		Modulo m1c1 = new Modulo("Introdução ao JavaEE", 1, c1);
		Modulo m2c1 = new Modulo("JSF", 2, c1);
		Modulo m3c1 = new Modulo("EJB", 3, c1);
		em.persist(m1c1);
		em.persist(m2c1);
		em.persist(m3c1);
		
		Aula a1m1c1 = new Aula("A Plataforma", 10, 1, m1c1);
		Aula a2m1c1 = new Aula("Ambiente de Desenvolvimento", 15, 2, m1c1);
		Aula a1m2c1 = new Aula("Ciclo de Vida", 20, 1, m2c1);
		Aula a2m2c1 = new Aula("Beans JSF", 16, 2, m2c1);
		Aula a1m3c1 = new Aula("Stateless Session Beans", 10, 1, m3c1);
		Aula a2m3c1 = new Aula("Stateful Session Beans", 12, 2, m3c1);
		em.persist(a1m1c1);
		em.persist(a2m1c1);
		em.persist(a1m2c1);
		em.persist(a2m2c1);
		em.persist(a1m3c1);
		em.persist(a2m3c1);
		
		Curso c2 = new Curso("Fundamentos de Java");
		em.persist(c2);
		
		Modulo m1c2 = new Modulo("Introdução ao Java", 1, c2);
		Modulo m2c2 = new Modulo("Variáveis", 2, c2);
		Modulo m3c2 = new Modulo("Orientação a Objetos", 3, c2);
		em.persist(m1c2);
		em.persist(m2c2);
		em.persist(m3c2);
		
		Aula a1m1c2 = new Aula("História do Java", 6, 1, m1c2);
		Aula a2m1c2 = new Aula("Características do Java", 10, 2, m1c2);
		Aula a1m2c2 = new Aula("Criação de Variáveis", 15, 1, m2c2);
		Aula a2m2c2 = new Aula("Atribuição de Valor", 12, 2, m2c2);
		Aula a1m3c2 = new Aula("Classes", 25, 1, m3c2);
		Aula a2m3c2 = new Aula("Objetos", 22, 2, m3c2);
		em.persist(a1m1c2);
		em.persist(a2m1c2);
		em.persist(a1m2c2);
		em.persist(a2m2c2);
		em.persist(a1m3c2);
		em.persist(a2m3c2);
	}
	
	public List<Aula> executar1() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Aula> q = cb.createQuery(Aula.class);
		
		Root<Aula> aula = q.from(Aula.class);
		
		q.select(aula);
		
		q.orderBy(cb.asc(aula.get(Aula_.nome)));
		
		TypedQuery<Aula> tq = em.createQuery(q);
		return tq.getResultList();
	}
	
	public List<String> executar2() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<String> q = cb.createQuery(String.class);
		
		Root<Aula> aula = q.from(Aula.class);
		
		q.select(aula.get(Aula_.nome));
		
		q.orderBy(cb.desc(aula.get(Aula_.duracao)));
		
		TypedQuery<String> tq = em.createQuery(q);
		return tq.getResultList();
	}
	
	public List<Modulo> executar3() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Modulo> q = cb.createQuery(Modulo.class);
		
		Root<Modulo> modulo = q.from(Modulo.class);
		Join<Modulo, Curso> curso = modulo.join(Modulo_.curso);
		
		q.select(modulo);
		
		q.where(cb.equal(curso.get(Curso_.nome), "JavaEE"));
		
		TypedQuery<Modulo> tq = em.createQuery(q);
		return tq.getResultList();
	}
	
	public List<Integer> executar4() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Integer> q = cb.createQuery(Integer.class);
		
		Root<Aula> aula = q.from(Aula.class);
		Join<Aula, Modulo> modulo = aula.join(Aula_.modulo);
		Join<Modulo, Curso> curso = modulo.join(Modulo_.curso);
		
		q.select(cb.sum(aula.get(Aula_.duracao)));
		
		q.where(cb.and(
				cb.equal(curso.get(Curso_.id), 1),
				cb.greaterThanOrEqualTo(aula.get(Aula_.duracao), 10)
		));
		
		TypedQuery<Integer> tq = em.createQuery(q);
		return tq.getResultList();
	}
}
