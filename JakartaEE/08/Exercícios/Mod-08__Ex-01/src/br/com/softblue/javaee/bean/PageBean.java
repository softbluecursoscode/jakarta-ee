package br.com.softblue.javaee.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.softblue.javaee.ejb.ConverterBean;

@Named
@RequestScoped
public class PageBean implements Serializable {
	
	@EJB
	private ConverterBean converterBean;
	
	@Inject
	private FacesContext facesContext;
	
	private Double km;
	private Double miles;

	public String convert() {
		if (miles != null) {
			km = converterBean.toKm(miles);
		} else if (km != null) {
			miles = converterBean.toMiles(km);
		} else {
			facesContext.addMessage(null, new FacesMessage("Preencha uma informação"));
		}
		
		return null;
	}

	public Double getKm() {
		return km;
	}

	public void setKm(Double km) {
		this.km = km;
	}

	public Double getMiles() {
		return miles;
	}

	public void setMiles(Double miles) {
		this.miles = miles;
	}
}
