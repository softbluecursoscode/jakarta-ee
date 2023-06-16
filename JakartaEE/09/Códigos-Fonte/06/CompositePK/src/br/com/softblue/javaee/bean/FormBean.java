package br.com.softblue.javaee.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.softblue.javaee.ejb.VooBean;
import br.com.softblue.javaee.model.Voo;

@Named("form")
@RequestScoped
public class FormBean implements Serializable {
	
	@EJB
	private VooBean vooBean;
	
	public String processar() {
		
		int numero = 1266;
		String empresa = "LATAM";
		
		Voo voo = new Voo();
		voo.setNumero(numero);
		voo.setEmpresa(empresa);
		voo.setOrigem("São Paulo");
		voo.setDestino("Paris");
		
		vooBean.inserir(voo);
		
		Voo vooDB = vooBean.carregar(numero, empresa);
		System.out.println(vooDB);
		
		return null;
	}
}
