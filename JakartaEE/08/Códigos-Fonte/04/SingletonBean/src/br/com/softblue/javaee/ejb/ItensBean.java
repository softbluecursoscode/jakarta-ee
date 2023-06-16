package br.com.softblue.javaee.ejb;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class ItensBean {

	private List<String> itens;

	@PostConstruct
	public void setup() {
		itens = Arrays.asList("Feijão", "Macarrão", "Alface");
		System.out.println("Itens inicializados!");
	}

	public List<String> getItens() {
		return itens;
	}
}
