package br.com.softblue.javaee;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class FormBean implements Serializable {

	private Integer valor1;
	private Integer valor2;
	private Integer valor3;
	private Integer resultado;
	
	public String somar() {
		// Soma os valores, armazena no atributo da classe e leva o usuário pra tela 'result'
		resultado = valor1 + valor2 + valor3;
		return "result";
	}

	public Integer getValor1() {
		return valor1;
	}

	public void setValor1(Integer valor1) {
		this.valor1 = valor1;
	}

	public Integer getValor2() {
		return valor2;
	}

	public void setValor2(Integer valor2) {
		this.valor2 = valor2;
	}

	public Integer getValor3() {
		return valor3;
	}

	public void setValor3(Integer valor3) {
		this.valor3 = valor3;
	}

	public Integer getResultado() {
		return resultado;
	}

	public void setResultado(Integer resultado) {
		this.resultado = resultado;
	}
}
