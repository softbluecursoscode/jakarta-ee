package br.com.softblue.primefaces;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

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

	private List<String> cidades = List.of("Brasília", "Londres", "Paris", "Buenos Aires", "Berlim");
	
	private String cidade;
	
	private String pais = "Brasil";
	
	public List<String> listarCidades(String query) {
		return cidades.stream().filter(c -> c.toUpperCase().startsWith(query.toUpperCase())).collect(Collectors.toList());
	}
	
	public String cadastrar() {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Cadastro realizado com sucesso!");
		facesContext.addMessage(null, msg);
		return null;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
}
