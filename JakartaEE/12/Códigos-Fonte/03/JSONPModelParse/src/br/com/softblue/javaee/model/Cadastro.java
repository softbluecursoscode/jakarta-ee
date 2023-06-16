package br.com.softblue.javaee.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cadastro {

	private String nome;
	private Integer idade;
	private LocalDate dataNascimento;
	private Boolean casado;
	private Endereco endereco = new Endereco();
	private List<String> interesses = new ArrayList<>();

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

	public Endereco getEndereco() {
		return endereco;
	}

	public List<String> getInteresses() {
		return interesses;
	}

	public void setInteresses(List<String> interesses) {
		this.interesses = interesses;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Boolean getCasado() {
		return casado;
	}

	public void setCasado(Boolean casado) {
		this.casado = casado;
	}

	@Override
	public String toString() {
		return "Cadastro [nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento + ", casado="
				+ casado + ", endereco=" + endereco + ", interesses=" + interesses + "]";
	}
}