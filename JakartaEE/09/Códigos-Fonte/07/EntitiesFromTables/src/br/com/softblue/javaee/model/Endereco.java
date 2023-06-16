package br.com.softblue.javaee.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@IdClass(EnderecoPK.class)
public class Endereco implements Serializable {

	@Id
	@Column(name="CLIENTE_ID")
	private int clienteId;

	@Id
	private String rua;
	
	private String complemento;

	private int numero;

	public int getClienteId() {
		return this.clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRua() {
		return this.rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

}