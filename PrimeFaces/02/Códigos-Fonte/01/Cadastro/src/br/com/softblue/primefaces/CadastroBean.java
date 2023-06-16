package br.com.softblue.primefaces;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CadastroBean implements Serializable {
	
	@Inject
	private FacesContext facesContext;

	private Cliente cliente = new Cliente();
	
	private String[] interesses = {
			"Esporte",
			"Cinema",
			"Viagens",
			"Culinária"
	};
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String[] getInteresses() {
		return interesses;
	}
	
	public String cadastrar() {
		System.out.println("Cliente: " + cliente);
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Cadastro realizado com sucesso");
		facesContext.addMessage(null, msg);
		return null;
	}
}
