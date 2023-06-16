package br.com.softblue.javaee;

import java.io.Serializable;
import java.util.Arrays;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.client.ClientBuilder;

@Named
@RequestScoped
public class PageBean implements Serializable {

	private Integer min;
	private Integer max;
	private Integer qtde;
	private String result;
	
	public String gerar() {
		int[] numbers = ClientBuilder.newClient()
			.target("http://localhost:8080/Mod-14__Ex-02/services/random")
			.queryParam("min", min)
			.queryParam("max", max)
			.queryParam("qtde", qtde)
			.request().get(int[].class);
		
		result = Arrays.toString(numbers);
		
		return null;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getQtde() {
		return qtde;
	}

	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
}
