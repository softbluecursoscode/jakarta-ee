package br.com.softblue.javaee.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.softblue.javaee.model.Bicicleta;
import br.com.softblue.javaee.model.Carro;

@Stateless
public class VeiculoBean {

	@PersistenceContext
	private EntityManager em;
	
	public void processar() {
		
		Bicicleta b1 = new Bicicleta();
		b1.setFabricante("Caloi");
		b1.setQtdePessoas(2);
		b1.setTamanhoAro(29);
		em.persist(b1);
		
		Bicicleta b2 = new Bicicleta();
		b2.setFabricante("Caloi");
		b2.setQtdePessoas(1);
		b2.setTamanhoAro(20);
		em.persist(b2);
		
		Carro c1 = new Carro();
		c1.setFabricante("Renault");
		c1.setQtdePessoas(5);
		c1.setQtdePortas(2);
		em.persist(c1);
		
		Carro c2 = new Carro();
		c2.setFabricante("Fiat");
		c2.setQtdePessoas(7);
		c2.setQtdePortas(4);
		em.persist(c2);
	}
}
