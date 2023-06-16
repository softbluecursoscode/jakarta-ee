package br.com.softblue.javaee.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

@Named
@RequestScoped
public class PageBean implements Serializable {
	
	private Integer counter = 0;
	
	public void incrementar(AjaxBehaviorEvent event) {
		counter++;
	}
	
	public Integer getCounter() {
		return counter;
	}
	
	public void setCounter(Integer counter) {
		this.counter = counter;
	}
	
}
