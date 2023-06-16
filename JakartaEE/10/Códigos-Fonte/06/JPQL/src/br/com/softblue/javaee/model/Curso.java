package br.com.softblue.javaee.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Curso implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String nome;

	@OneToMany(mappedBy = "curso")
	private List<Modulo> modulos;
	
	public Curso(String nome) {
		this.nome = nome;
	}
	
	public Curso() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + "]";
	}
}
