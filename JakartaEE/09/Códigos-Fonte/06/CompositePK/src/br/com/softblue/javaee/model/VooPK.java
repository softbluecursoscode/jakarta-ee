package br.com.softblue.javaee.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

public class VooPK implements Serializable {   
   	         
	private Integer numero;         
	private String empresa;

	public VooPK() {
		
	}

	public VooPK(Integer numero, String empresa) {
		this.numero = numero;
		this.empresa = empresa;
	}

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
	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof VooPK)) {
			return false;
		}
		VooPK other = (VooPK) o;
		return true
			&& (getNumero() == null ? other.getNumero() == null : getNumero().equals(other.getNumero()))
			&& (getEmpresa() == null ? other.getEmpresa() == null : getEmpresa().equals(other.getEmpresa()));
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getNumero() == null ? 0 : getNumero().hashCode());
		result = prime * result + (getEmpresa() == null ? 0 : getEmpresa().hashCode());
		return result;
	}
   
   
}
