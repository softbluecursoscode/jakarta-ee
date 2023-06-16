package br.com.softblue.javaee.bean;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("bean")
@RequestScoped
public class PagamentoBean implements Serializable {

	public enum Bandeira {
		VISA, MASTERCARD, AMEX, DINERS;
	}

	private Bandeira bandeira;
	private String numeroCartao;
	private String nome;
	private Date dataValidade;
	private Double valor;
	
	public String processar() {
		// Aqui vai a lógica de processamento do pagamento
		
		return "pagamento_sucesso";
	}
	
	public Bandeira[] getBandeiras() {
		return Bandeira.values();
	}

	public Bandeira getBandeira() {
		return bandeira;
	}

	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
}
