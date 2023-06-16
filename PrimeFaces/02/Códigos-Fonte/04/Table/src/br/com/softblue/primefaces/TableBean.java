package br.com.softblue.primefaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

@Named
@RequestScoped
public class TableBean implements Serializable {
	
	@Inject
	private FacesContext facesContext;
	
	private static List<Despesa> despesas = new ArrayList<>();
	
	private Despesa[] selectedDespesas;
	private List<String> categorias = List.of("Beleza e Est�tica", "Casa", "Autom�vel", "Vestu�rio", "Livros e Revistas");
	
	static {
		despesas = new ArrayList<Despesa>();
		despesas.add(new Despesa(1, "02/10/2020", "Restaurante Comida Boa", "Alimenta��o", 95.0));
		despesas.add(new Despesa(2, "03/10/2020", "Sal�o de Beleza", "Beleza e Est�tica", 87.0));
		despesas.add(new Despesa(3, "04/10/2020", "Energia El�trica", "Casa", 115.0));
		despesas.add(new Despesa(4, "04/10/2020", "Combust�vel", "Autom�vel", 130.5));
		despesas.add(new Despesa(5, "05/10/2020", "Doce", "Alimenta��o", 3.0));
		despesas.add(new Despesa(6, "06/10/2020", "Livro", "Livros e Revistas", 39.9));
		despesas.add(new Despesa(7, "06/10/2020", "Uniforme escolar", "Vestu�rio", 150.4));
		despesas.add(new Despesa(8, "04/10/2020", "Sapato", "Vestu�rio", 110.9));
	}
	
	public void processar() {
		StringBuilder sb = new StringBuilder("Despesas selecionadas: ");
		
		for (Despesa d : selectedDespesas) {
			sb.append(d.getDescricao()).append(", ");
		}
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, null, sb.toString());
		facesContext.addMessage(null, msg);
	}
	
	public void onEdit(RowEditEvent event) {
		Despesa despesa = (Despesa) event.getObject();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Despesa " + despesa.getId() + " foi alterada!");
		facesContext.addMessage(null, msg);
	}
	
	public void onCancel(RowEditEvent event) {
		Despesa despesa = (Despesa) event.getObject();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Altera��o na despesa " + despesa.getId() + " foi cancelada!");
		facesContext.addMessage(null, msg);
	}
	
	public List<Despesa> getDespesas() {
		return despesas;
	}
	
	public Despesa[] getSelectedDespesas() {
		return selectedDespesas;
	}
	
	public void setSelectedDespesas(Despesa[] selectedDespesas) {
		this.selectedDespesas = selectedDespesas;
	}
	
	public List<String> getCategorias() {
		return categorias;
	}
}

