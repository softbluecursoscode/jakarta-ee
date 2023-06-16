package br.com.softblue.javaee.ejb;

import javax.ejb.Singleton;

@Singleton
public class CounterBean {
	
	private int counter;
	
	public void count() {
		counter++;
	}
	
	public int getCounter() {
		return counter;
	}
}
