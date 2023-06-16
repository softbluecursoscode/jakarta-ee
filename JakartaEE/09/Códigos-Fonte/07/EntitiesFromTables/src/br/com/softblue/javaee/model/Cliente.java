package br.com.softblue.javaee.model;

import java.io.Serializable;
import javax.persistence.*;


@Entity
public class Cliente implements Serializable {
	
	@Id
	private int id;

	private String nome;

	@Column(name="RECEBER_EMAILS")
	private byte receberEmails;

	public Cliente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public byte getReceberEmails() {
		return this.receberEmails;
	}

	public void setReceberEmails(byte receberEmails) {
		this.receberEmails = receberEmails;
	}

}