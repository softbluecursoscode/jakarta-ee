package br.com.softblue.javaee.business;

import java.util.ArrayList;
import java.util.List;

import br.com.softblue.javaee.model.Estado;
import br.com.softblue.javaee.model.Interesse;

public class DataProvider {

	public static final List<Estado> ESTADOS;
	public static final List<Interesse> INTERESSES;
	
	static {
		ESTADOS = new ArrayList<>();
		ESTADOS.add(new Estado("Acre", "AC"));
		ESTADOS.add(new Estado("Alagoas", "AL"));
		ESTADOS.add(new Estado("Amazonas", "AM"));
		ESTADOS.add(new Estado("Manaus", "AP"));
		ESTADOS.add(new Estado("Bahia", "BA"));
		ESTADOS.add(new Estado("Ceará", "CE"));
		ESTADOS.add(new Estado("Distrito Federal", "DF"));
		ESTADOS.add(new Estado("Espírito Santo", "ES"));
		ESTADOS.add(new Estado("Goiás", "GO"));
		ESTADOS.add(new Estado("Maranhão", "MA"));
		ESTADOS.add(new Estado("Minas Geais", "MG"));
		ESTADOS.add(new Estado("Mato Grosso do Sul", "MS"));
		ESTADOS.add(new Estado("Mato Grosso", "MT"));
		ESTADOS.add(new Estado("Pará", "PA"));
		ESTADOS.add(new Estado("Paraíba", "PB"));
		ESTADOS.add(new Estado("Pernambuco", "PE"));
		ESTADOS.add(new Estado("Piauí", "PI"));
		ESTADOS.add(new Estado("Paraná", "PR"));
		ESTADOS.add(new Estado("Rio de Janeiro", "RJ"));
		ESTADOS.add(new Estado("Rio Grande do Norte", "RN"));
		ESTADOS.add(new Estado("Rondônia", "RO"));
		ESTADOS.add(new Estado("Roraima", "RR"));
		ESTADOS.add(new Estado("Rio Grande do Sul", "RS"));
		ESTADOS.add(new Estado("Santa Catarina", "SC"));
		ESTADOS.add(new Estado("Sergipe", "SE"));
		ESTADOS.add(new Estado("São Paulo", "SP"));
		ESTADOS.add(new Estado("Tocantins", "TO"));
		
		INTERESSES = new ArrayList<>();
		INTERESSES.add(new Interesse(1, "Esportes"));
		INTERESSES.add(new Interesse(2, "Música"));
		INTERESSES.add(new Interesse(3, "Artes Marciais"));
		INTERESSES.add(new Interesse(4, "Viagens"));
		INTERESSES.add(new Interesse(5, "Cinema"));
		INTERESSES.add(new Interesse(6, "Dança"));
	}
}
