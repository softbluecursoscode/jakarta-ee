package br.com.softblue.javaee;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class IndexBean implements Serializable {
	private int x;
	
	public String throwException() {
		x = 10 / 0;
		return null;
	}
	
	public int getX() {
		return x;
	}
}
