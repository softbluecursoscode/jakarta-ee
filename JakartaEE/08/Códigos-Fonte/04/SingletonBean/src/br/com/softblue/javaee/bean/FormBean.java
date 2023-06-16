package br.com.softblue.javaee.bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.softblue.javaee.ejb.ItensBean;

@Named("form")
@RequestScoped
public class FormBean implements Serializable {

	@EJB
	private ItensBean itensBean;
	
	public List<String> getItens() {
		return itensBean.getItens();
	}
}
