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
	private List<String> categorias = List.of("Beleza e Estética", "Casa", "Automóvel", "Vestuário", "Livros e Revistas");
	
	static {
		despesas = new ArrayList<Despesa>();
		despesas.add(new Despesa(1, "02/10/2020", "Restaurante Comida Boa", "Alimentação", 95.0));
		despesas.add(new Despesa(2, "03/10/2020", "Salão de Beleza", "Beleza e Estética", 87.0));
		despesas.add(new Despesa(3, "04/10/2020", "Energia Elétrica", "Casa", 115.0));
		despesas.add(new Despesa(4, "04/10/2020", "Combustível", "Automóvel", 130.5));
		despesas.add(new Despesa(5, "05/10/2020", "Doce", "Alimentação", 3.0));
		despesas.add(new Despesa(6, "06/10/2020", "Livro", "Livros e Revistas", 39.9));
		despesas.add(new Despesa(7, "06/10/2020", "Uniforme escolar", "Vestuário", 150.4));
		despesas.add(new Despesa(8, "04/10/2020", "Sapato", "Vestuário", 110.9));
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
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Alteração na despesa " + despesa.getId() + " foi cancelada!");
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

