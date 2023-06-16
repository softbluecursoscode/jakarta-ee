package br.com.softblue.javaee.model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Produto implements HttpSessionBindingListener {

	private String nome;

	public String getNome() {
		return nome;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		this.nome = event.getName();
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		this.nome = null;
	}
}
