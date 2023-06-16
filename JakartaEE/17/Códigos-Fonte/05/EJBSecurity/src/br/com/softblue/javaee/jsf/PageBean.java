package br.com.softblue.javaee.jsf;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;

import br.com.softblue.javaee.ejb.SecuredBean;

@Named
@RequestScoped
public class PageBean implements Serializable {

	public enum Metodo {
		adminRun, guestRun, adminAndGuestRun;
	}
	
	private Metodo selectedMetodo;
	
	@EJB
	private SecuredBean ejb;
	
	@Inject
	private SecurityContext securityContext;
	
	private String result;
	
	public String submit() {
		
		switch (selectedMetodo) {
		case adminRun : result = ejb.adminRun(); break;
		case guestRun : result = ejb.guestRun(); break;
		case adminAndGuestRun : result = ejb.adminAndGuestRun(); break;
		}
		
		return null;
	}
	
	public String getLoggedUser() {
		return securityContext.getCallerPrincipal().getName();
	}
	
	public Metodo[] getMetodos() {
		return Metodo.values();
	}
	
	public Metodo getSelectedMetodo() {
		return selectedMetodo;
	}
	
	public void setSelectedMetodo(Metodo selectedMetodo) {
		this.selectedMetodo = selectedMetodo;
	}
	
	public String getResult() {
		return result;
	}
}
