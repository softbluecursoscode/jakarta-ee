package br.com.softblue.javaee.ejb;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;

@Stateless
//@RolesAllowed("guest")
public class SecuredBean {
	
	@Inject
	private SecurityContext securityContext;
	
	@RolesAllowed("admin")
	public String adminRun() {
		return "Executou adminRun()";
	}
	
	@RolesAllowed("guest")
	public String guestRun() {
		return "Executou guestRun()";
	}
	
	@RolesAllowed({ "admin", "guest" })
	public String adminAndGuestRun() {
		StringBuilder sb = new StringBuilder();
		
		if (securityContext.isCallerInRole("admin")) {
			sb.append("Você está logado como ADMINISTRADOR. Seu nome é ");
			sb.append(securityContext.getCallerPrincipal().getName());
		
		} else if (securityContext.isCallerInRole("guest")) {
			sb.append("Você está logado como CONVIDADO. Seu nome é ");
			sb.append(securityContext.getCallerPrincipal().getName());
		}
		
		return "Executou adminAndGuestRun(). " + sb;
	}
}
