package br.com.softblue.javaee.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.softblue.javaee.business.DataProvider;
import br.com.softblue.javaee.model.Endereco;
import br.com.softblue.javaee.model.Estado;
import br.com.softblue.javaee.model.Interesse;
import br.com.softblue.javaee.model.Pessoa;
import br.com.softblue.javaee.model.Telefone;

@Named("cadastro")
@SessionScoped
public class CadastroBean implements Serializable {

	private Pessoa pessoa;

	public Pessoa getPessoa() {
		if (pessoa == null) {
			pessoa = new Pessoa();
			pessoa.setEnderecoResidencial(new Endereco());
			pessoa.getEnderecoResidencial().setEstado(new Estado());
			pessoa.setEnderecoComercial(new Endereco());
			pessoa.getEnderecoComercial().setEstado(new Estado());
			pessoa.setTelefoneResidencial(new Telefone());
			pessoa.setTelefoneCelular(new Telefone());
			pessoa.setTelefoneComercial(new Telefone());
		}
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<Estado> getEstados() {
		return DataProvider.ESTADOS;
	}

	public List<Interesse> getInteresses() {
		return DataProvider.INTERESSES;
	}
}