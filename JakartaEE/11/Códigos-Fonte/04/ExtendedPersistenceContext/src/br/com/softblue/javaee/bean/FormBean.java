package br.com.softblue.javaee.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.softblue.javaee.ejb.ItensBean;
import br.com.softblue.javaee.model.Item;

@Named("form")
@SessionScoped
public class FormBean implements Serializable {

	@EJB
	private ItensBean itensBean;
	
	@Inject
	private ExternalContext externalContext;
	
	private List<Item> itens = new ArrayList<>();
	
	private Item item = new Item();
	
	public String adicionar() {
		itens.add(item);
		itensBean.adicionarItem(item);
		item = new Item();
		return "form?faces-redirect=true";
	}
	
	public String remover(Item item) {
		itens.remove(item);
		itensBean.removerItem(item.getId());
		item = new Item();
		return "form?faces-redirect=true";
	}
	
	public String finalizar() {
		itensBean.finalizar();
		externalContext.invalidateSession();
		return "form?faces-redirect=true";
	}
	
	public List<Item> getItens() {
		return itens;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}
