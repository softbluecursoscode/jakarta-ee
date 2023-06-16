package br.com.softblue.javaee;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named("page")
@RequestScoped
public class PageBean implements Serializable {

	@Inject
	private ExternalContext externalContext;
	
	private int valor1;
	private int valor2;
	
	@PostConstruct
	public void setup() {
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		//HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
		//HttpSession session = request.getSession();
		
		this.valor1 = Integer.parseInt(request.getParameter("v1"));
		this.valor2 = Integer.parseInt(request.getParameter("v2"));
	}
	
	public int getValor1() {
		return valor1;
	}

	public int getValor2() {
		return valor2;
	}

	public int getSoma() {
		return valor1 + valor2;
	}
}
