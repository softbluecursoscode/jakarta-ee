package br.com.softblue.javaee;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named("user")
@SessionScoped
public class UserBean implements Serializable {

	private String name;
	private String password;
	private boolean authenticated;
	
	@Inject
	private FacesContext facesContext;
	
	public String login() {
		if ("abc".equals(name) && "123".equals(password)) {
			authenticated = true;
			return "sucesso";
		}
		
		facesContext.addMessage(null, new FacesMessage("Login inválido"));
		return null;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isAuthenticated() {
		return authenticated;
	}
}
