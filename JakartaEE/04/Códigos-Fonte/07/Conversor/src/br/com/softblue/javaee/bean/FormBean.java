package br.com.softblue.javaee.bean;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.softblue.javaee.enumeration.Opcao;

@Named("form")
@RequestScoped
public class FormBean implements Serializable {

	private Integer numeroInteiro;
	private Double numeroDecimal;
	private Character caractere;
	private Date data;
	private Opcao opcao;
	
	public String processar() {
		System.out.println("Número inteiro: " + numeroInteiro);
		System.out.println("Número decimal: " + numeroDecimal);
		System.out.println("Caractere: " + caractere);
		System.out.println("Data: " + data);
		System.out.println("Opção: " + opcao);
		
		return "result";
	}

	public Integer getNumeroInteiro() {
		return numeroInteiro;
	}

	public void setNumeroInteiro(Integer numeroInteiro) {
		this.numeroInteiro = numeroInteiro;
	}

	public Double getNumeroDecimal() {
		return numeroDecimal;
	}

	public void setNumeroDecimal(Double numeroDecimal) {
		this.numeroDecimal = numeroDecimal;
	}

	public Character getCaractere() {
		return caractere;
	}

	public void setCaractere(Character caractere) {
		this.caractere = caractere;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Opcao getOpcao() {
		return opcao;
	}

	public void setOpcao(Opcao opcao) {
		this.opcao = opcao;
	}
}
