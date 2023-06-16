package br.com.softblue.javaee.model;

public class Telefone {

	public enum Tipo {
		FIXO, CELULAR
	}

	private String ddd;
	private String numero;
	private Tipo tipo;

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

}
