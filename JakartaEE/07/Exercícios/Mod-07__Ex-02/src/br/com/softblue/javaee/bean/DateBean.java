package br.com.softblue.javaee.bean;

import java.io.Serializable;
import java.text.ParseException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.softblue.javaee.view.Date;

@Named
@RequestScoped
public class DateBean implements Serializable {

	/**
	 * Aqui será armazenada a data digitada nos campos da tag
	 */
	private Date date = new Date();
	
	public String processar() {
		// Exibe a data
		System.out.println("Data: " + date.asDateString());
		
		try {
			// Obtém a data como um objeto java.util.Date
			System.out.println("Data: " + date.asDate());
		
		} catch (ParseException e) {
			// Exceção ocorrida caso a data não possa ser convertida para java.util.Date
			System.err.println("A data está no formato inválido");
		
		}
		return null;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}