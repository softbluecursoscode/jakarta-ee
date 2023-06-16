package br.com.softblue.primefaces;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

@Named
@RequestScoped
public class ColorBean implements Serializable {
	
	@Inject
	private FacesContext facesContext;
	
	private DualListModel<String> colors;

	public ColorBean() {
		List<String> source = List.of("Amarelo", "Verde", "Azul", "Branco", "Preto", "Cinza");
		List<String> target = List.of();
		colors = new DualListModel<>(source, target);
	}
	
	public void onTransfer(TransferEvent event) {
		List<?> itens = event.getItems();
		String text = event.isAdd() ? "adicionados" : "removidos";
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Itens " + text + ": " + itens, null);
		facesContext.addMessage(null, msg);
	}
	
	public DualListModel<String> getColors() {
		return colors;
	}
	
	public void setColors(DualListModel<String> colors) {
		this.colors = colors;
	}
}
