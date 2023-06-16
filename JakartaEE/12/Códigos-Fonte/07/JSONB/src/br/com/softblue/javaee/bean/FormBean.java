package br.com.softblue.javaee.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import br.com.softblue.javaee.model.Cadastro;

@Named("form")
@RequestScoped
public class FormBean implements Serializable {
	private Cadastro cadastro = new Cadastro();

	private String jsonStr;

	public String parseJson() {
		Jsonb jsonb = JsonbBuilder.create();
		cadastro = jsonb.fromJson(jsonStr, Cadastro.class);
		
		return null;
	}
	
	public String convertToJson() {
		JsonbConfig config = new JsonbConfig().withFormatting(true);
		Jsonb jsonb = JsonbBuilder.create(config);
		jsonStr = jsonb.toJson(cadastro);
		
		return null;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public String getJsonStr() {
		return jsonStr;
	}

	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}
}
