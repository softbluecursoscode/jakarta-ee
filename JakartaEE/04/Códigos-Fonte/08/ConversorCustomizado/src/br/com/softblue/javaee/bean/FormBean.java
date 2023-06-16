package br.com.softblue.javaee.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.softblue.javaee.model.Endereco;

@Named("form")
@RequestScoped
public class FormBean implements Serializable {

	private Endereco endereco;
	
	public FormBean() {
		endereco = new Endereco();
		endereco.setRua("Rua X");
		endereco.setNumero("777");
	}
	
	public String processar() {
		System.out.println("Rua: " + endereco.getRua());
		System.out.println("Número: " + endereco.getNumero());
		return "result";
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
