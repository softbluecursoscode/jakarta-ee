package br.com.softblue.javaee.model;

import javax.persistence.Entity;

@Entity
public abstract class VeiculoPasseio extends Veiculo {

	private Integer qtdePessoas;

	public Integer getQtdePessoas() {
		return qtdePessoas;
	}

	public void setQtdePessoas(Integer qtdePessoas) {
		this.qtdePessoas = qtdePessoas;
	}

}
