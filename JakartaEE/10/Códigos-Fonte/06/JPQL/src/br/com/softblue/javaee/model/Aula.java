package br.com.softblue.javaee.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Aula implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;

	private String nome;
	
	private Integer duracao;
	
	private Integer posicao;

	@ManyToOne
	private Modulo modulo;

	public Aula(String nome, Integer duracao, Integer posicao, Modulo modulo) {
		this.nome = nome;
		this.duracao = duracao;
		this.posicao = posicao;
		this.modulo = modulo;
	}

	public Aula() {
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public Integer getId() {
		return id;
	}
	
	public Integer getDuracao() {
		return duracao;
	}
	
	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	@Override
	public String toString() {
		return "Aula [id=" + id + ", nome=" + nome + ", duracao=" + duracao + ", posicao=" + posicao + ", modulo="
				+ modulo + "]";
	}
}
