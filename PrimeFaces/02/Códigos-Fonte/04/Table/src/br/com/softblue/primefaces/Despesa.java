package br.com.softblue.primefaces;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Despesa {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private int id;
	private Date data;
	private String descricao;
	private String categoria;
	private Double valor;

	public Despesa(int id, String data, String descricao, String categoria,
			double valor) {
		
		this.id = id; 
		
		try {
			this.data = sdf.parse(data);
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		this.descricao = descricao;
		this.categoria = categoria;
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
