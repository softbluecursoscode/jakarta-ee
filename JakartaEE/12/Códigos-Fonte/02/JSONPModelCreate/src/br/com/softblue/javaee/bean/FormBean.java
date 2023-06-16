package br.com.softblue.javaee.bean;

import java.io.Serializable;
import java.io.StringWriter;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;

import br.com.softblue.javaee.model.Cadastro;

@Named("form")
@RequestScoped
public class FormBean implements Serializable {
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	private Cadastro cadastro = new Cadastro();
	
	private String jsonStr;
	
	public String convertToJson() {
		JsonObject rootObj = Json.createObjectBuilder()
			.add("nome", cadastro.getNome())
			.add("idade", cadastro.getIdade())
			.add("dataNascimento", FORMATTER.format(cadastro.getDataNascimento()))
			.add("casado", cadastro.getCasado())
			.add("endereco", Json.createObjectBuilder()
					.add("rua", cadastro.getEndereco().getRua())
					.add("numero", cadastro.getEndereco().getNumero())
					.build())
			.add("interesses", Json.createArrayBuilder(cadastro.getInteresses()))
			.build();
		
		StringWriter out = new StringWriter();
		
		//try (JsonWriter jsonWriter = Json.createWriter(out)) {
		//	jsonWriter.write(rootObj);
		//}
		
		Map<String, Boolean> config = Map.of(JsonGenerator.PRETTY_PRINTING, true);
		JsonWriterFactory writerFactory = Json.createWriterFactory(config);
		
		try (JsonWriter jsonWriter = writerFactory.createWriter(out)) {
			jsonWriter.write(rootObj);
		}
		
		jsonStr = out.toString();
		
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
