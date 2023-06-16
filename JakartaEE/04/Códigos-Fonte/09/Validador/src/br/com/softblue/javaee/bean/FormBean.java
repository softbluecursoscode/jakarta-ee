package br.com.softblue.javaee.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named("form")
@RequestScoped
public class FormBean implements Serializable {

	private String nome;
	private Integer idade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public void validarInicial(FacesContext ctx, UIComponent comp, Object value) {
		String s = (String) value;

		if (s != null && !s.startsWith("A")) {
			FacesMessage msg = new FacesMessage("Nome não começa com A");
			throw new ValidatorException(msg);
		}
	}
}
