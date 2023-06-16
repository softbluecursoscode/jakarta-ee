package br.com.softblue.javaee.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.softblue.javaee.ejb.CounterBean;

@Named
@RequestScoped
public class PageBean implements Serializable {
	
	@EJB
	private CounterBean counterBean;
	
	public String count() {
		counterBean.count();
		return null;
	}
	
	public int getCounter() {
		return counterBean.getCounter();
	}
}
