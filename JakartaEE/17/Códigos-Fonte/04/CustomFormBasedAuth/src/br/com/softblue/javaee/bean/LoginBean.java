package br.com.softblue.javaee.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Named
@RequestScoped
public class LoginBean implements Serializable {

	private String userName;
	private String password;

	@Inject
	private SecurityContext securityContext;

	@Inject
	private ExternalContext externalContext;

	public String login() {
		UsernamePasswordCredential credential = new UsernamePasswordCredential(userName, password);

		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

		AuthenticationParameters authParams = AuthenticationParameters.withParams().credential(credential);

		AuthenticationStatus status = securityContext.authenticate(request, response, authParams);

		if (status == AuthenticationStatus.SUCCESS) {
			return "welcome?faces-redirect=true";
		}

		return null;
	}

	public String getLoggedUser() {
		return securityContext.getCallerPrincipal().getName();
	}
	
	public String logout() {
		try {
			((HttpServletRequest) externalContext.getRequest()).logout();
			return "welcome?faces-redirect=true";
		} catch (ServletException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
