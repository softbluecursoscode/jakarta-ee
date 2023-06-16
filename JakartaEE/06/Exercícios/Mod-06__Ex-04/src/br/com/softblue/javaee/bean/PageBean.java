package br.com.softblue.javaee.bean;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class PageBean implements Serializable {
	
	public Date getData() {
		return new Date();
	}
}
