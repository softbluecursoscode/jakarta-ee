package br.com.softblue.javaee.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("form")
@RequestScoped
public class FormBean implements Serializable {
	
	private Integer texto;

	public Integer getTexto() {
		return texto;
	}

	public void setTexto(Integer texto) {
		this.texto = texto;
	}
}
