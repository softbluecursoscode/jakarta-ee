package br.com.softblue.primefaces;

import java.util.Arrays;
import java.util.Date;

public class Cliente {

	private String nome;
	private String cpf;
	private Date dataNasc;
	private Double salario;
	private Boolean casado;
	private String[] interesses;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Boolean getCasado() {
		return casado;
	}

	public void setCasado(Boolean casado) {
		this.casado = casado;
	}

	public String[] getInteresses() {
		return interesses;
	}

	public void setInteresses(String[] interesses) {
		this.interesses = interesses;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", dataNasc=" + dataNasc + ", salario=" + salario
				+ ", casado=" + casado + ", interesses=" + Arrays.toString(interesses) + "]";
	}
}
