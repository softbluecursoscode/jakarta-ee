package br.com.softblue.javaee.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.json.bind.annotation.JsonbProperty;

public class Cadastro {

	@JsonbProperty("nome-da-pessoa")
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
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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