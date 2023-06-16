package br.com.softblue.javaee.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

@Entity
@IdClass(VooPK.class)
public class Voo implements Serializable {

	@Id
	private Integer numero;   
	
	@Id
	private String empresa;
	
	private String origem;
	
	private String destino;
	 
	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}   
	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}   
	public String getOrigem() {
		return this.origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}   
	public String getDestino() {
		return this.destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	@Override
	public String toString() {
		return "Voo [numero=" + numero + ", empresa=" + empresa + ", origem=" + origem + ", destino=" + destino + "]";
	}
}
