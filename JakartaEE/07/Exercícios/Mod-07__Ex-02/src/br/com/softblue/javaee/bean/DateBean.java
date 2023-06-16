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
	 * Aqui ser� armazenada a data digitada nos campos da tag
	 */
	private Date date = new Date();
	
	public String processar() {
		// Exibe a data
		System.out.println("Data: " + date.asDateString());
		
		try {
			// Obt�m a data como um objeto java.util.Date
			System.out.println("Data: " + date.asDate());
		
		} catch (ParseException e) {
			// Exce��o ocorrida caso a data n�o possa ser convertida para java.util.Date
			System.err.println("A data est� no formato inv�lido");
		
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