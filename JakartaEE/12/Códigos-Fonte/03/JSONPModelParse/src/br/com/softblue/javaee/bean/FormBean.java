package br.com.softblue.javaee.bean;

import java.io.Serializable;
import java.io.StringReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import br.com.softblue.javaee.model.Cadastro;

@Named("form")
@RequestScoped
public class FormBean implements Serializable {
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	private Cadastro cadastro = new Cadastro();
	
	private String jsonStr;
	
	public String parseJson() {
		StringReader in = new StringReader(jsonStr);
		
		JsonObject rootObj;
		try (JsonReader jsonReader = Json.createReader(in)) {
			rootObj = jsonReader.readObject();
		}
		
		cadastro.setNome(rootObj.getString("nome"));
		cadastro.setIdade(rootObj.getInt("idade"));
		cadastro.setDataNascimento(LocalDate.parse(rootObj.getString("dataNascimento"), FORMATTER));
		cadastro.setCasado(rootObj.getBoolean("casado"));
		
		JsonObject enderecoObj = rootObj.getJsonObject("endereco");
		
		cadastro.getEndereco().setRua(enderecoObj.getString("rua"));
		cadastro.getEndereco().setNumero(enderecoObj.getInt("numero"));
		
		JsonArray interessesArray = rootObj.getJsonArray("interesses");
		
		for (int i = 0; i < interessesArray.size(); i++) {
			String interesse = interessesArray.getString(i);
			cadastro.getInteresses().add(interesse);
		}
		
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
