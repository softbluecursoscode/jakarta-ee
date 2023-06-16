package br.com.softblue.javaee.business;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import br.com.softblue.javaee.model.Estado;
import br.com.softblue.javaee.model.Regiao;

public class RegioesProvider {
	private static final Map<String, Regiao> regioesMap = new TreeMap<String, Regiao>();

	static {
		Regiao regiao = null;
		Estado estado = null;
		
		regiao = new Regiao("Sul", "S");
		regioesMap.put("S", regiao);
		estado = new Estado("RS", "Rio Grande do Sul", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("SC", "Santa Catarina", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("PR", "Paraná", regiao);
		regiao.getEstados().add(estado);
		
		regiao = new Regiao("Sudeste", "SE");
		regioesMap.put("SE", regiao);
		estado = new Estado("SP", "São Paulo", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("RJ", "Rio de Janeiro", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("ES", "Espírito Santo", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("MG", "Minas Gerais", regiao);
		regiao.getEstados().add(estado);
		
		regiao = new Regiao("Nordeste", "NE");
		regioesMap.put("NE", regiao);
		estado = new Estado("BA", "Bahia", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("SE", "Sergipe", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("AL", "Alagoas", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("PE", "Pernambuco", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("PB", "Paraíba", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("RN", "Rio Grande do Norte", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("CE", "Ceará", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("PI", "Piauí", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("MA", "Maranhão", regiao);
		regiao.getEstados().add(estado);
		
		regiao = new Regiao("Norte", "N");
		regioesMap.put("N", regiao);
		estado = new Estado("AM", "Amazonas", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("PA", "Pará", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("AC", "Acre", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("RO", "Rondônia", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("RR", "Roraima", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("TO", "Tocantins", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("AP", "Amapá", regiao);
		regiao.getEstados().add(estado);
		
		regiao = new Regiao("Centro-Oeste", "CO");
		estado = new Estado("MS", "Mato Grosso do Sul", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("MT", "Mato Grosso", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("GO", "Goiás", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("DF", "Distrito Federal", regiao);
		regiao.getEstados().add(estado);
		regioesMap.put("CO", regiao);
	}
	
	public static Collection<Regiao> getRegioes() {
		return regioesMap.values();
	}
	
	public static Collection<Estado> getEstadosByRegiao(String siglaRegiao) {
		Regiao regiao = regioesMap.get(siglaRegiao);
		if (regiao == null) {
			return Collections.emptyList();
		}
		return regiao.getEstados();
	}
}
