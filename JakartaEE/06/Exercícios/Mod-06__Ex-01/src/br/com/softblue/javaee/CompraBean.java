package br.com.softblue.javaee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

@Named
@SessionScoped
public class CompraBean implements Serializable {

	private List<Compra> compras = new ArrayList<Compra>();

	private Compra compra = new Compra();

	/**
	 * Eventos disparado pelo botão para adicionar um item à lista
	 * @param event
	 */
	public void adicionar(ActionEvent event) {
		compras.add(compra);
		compra = new Compra();
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public List<Compra> getCompras() {
		return compras;
	}

}
