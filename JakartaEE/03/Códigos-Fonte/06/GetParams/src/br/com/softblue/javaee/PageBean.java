package br.com.softblue.javaee;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import javax.inject.Named;

@Named
@RequestScoped
public class PageBean implements Serializable {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
