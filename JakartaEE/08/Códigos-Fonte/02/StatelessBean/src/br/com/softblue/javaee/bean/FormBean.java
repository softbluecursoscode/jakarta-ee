package br.com.softblue.javaee.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.softblue.javaee.ejb.TemperatureConverter;

@Named("form")
@RequestScoped
public class FormBean implements Serializable {

	private Double tc;
	private Double tf;
	
	@EJB
	//private TemperatureConverterBean converter;
	private TemperatureConverter converter;
	
	public String convertCelsiusToFahrenheit() {
		this.tf = converter.convertCelsiusToFahrenheit(tc);
		return null;
	}
	
	public Double getTc() {
		return tc;
	}
	
	public void setTc(Double tc) {
		this.tc = tc;
	}
	
	public Double getTf() {
		return tf;
	}
	
	public void setTf(Double tf) {
		this.tf = tf;
	}
}
