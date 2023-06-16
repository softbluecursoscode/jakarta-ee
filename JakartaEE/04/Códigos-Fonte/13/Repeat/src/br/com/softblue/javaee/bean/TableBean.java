package br.com.softblue.javaee.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.softblue.javaee.model.Despesa;

@Named("table")
@SessionScoped
public class TableBean implements Serializable {

	private List<Despesa> despesas = new ArrayList<>();

	public String inserir() {
		Despesa d = new Despesa();
		d.setEdit(true);
		despesas.add(d);
		return null;
	}
	
	public String editar(Despesa despesa) {
		despesa.setEdit(true);
		return null;
	}
	
	public String gravar(Despesa despesa) {
		despesa.setEdit(false);
		return null;
	}
	
	public String excluir(Despesa despesa) {
		despesas.remove(despesa);
		return null;
	}
	
	public List<Despesa> getDespesas() {
		return despesas;
	}
}
