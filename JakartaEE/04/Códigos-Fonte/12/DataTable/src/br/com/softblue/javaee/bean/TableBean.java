package br.com.softblue.javaee.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

import br.com.softblue.javaee.model.Despesa;

@Named("table")
@SessionScoped
public class TableBean implements Serializable {

	private List<Despesa> despesasList = new ArrayList<>();
	private ListDataModel<Despesa> despesas = new ListDataModel<>(despesasList);
	
//	public TableBean() {
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		
//		Despesa d = new Despesa();
//		
//		try {
//			d.setData(sdf.parse("15/02/2030"));
//		} catch (ParseException e) {
//		}
//		
//		d.setDescricao("Item Qualquer");
//		d.setEdit(false);
//		d.setValor(135.0);
//		despesasList.add(d);
//		
//		d = new Despesa();
//		
//		try {
//			d.setData(sdf.parse("20/03/2030"));
//		} catch (ParseException e) {
//		}
//		
//		d.setDescricao("Item Qualquer 2");
//		d.setEdit(false);
//		d.setValor(1000.0);
//		despesasList.add(d);
//	}
	
	public String inserir() {
		Despesa d = new Despesa();
		d.setEdit(true);
		despesasList.add(d);
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
		despesasList.remove(despesa);
		return null;
	}
	
	public ListDataModel<Despesa> getDespesas() {
		return despesas;
	}
}
