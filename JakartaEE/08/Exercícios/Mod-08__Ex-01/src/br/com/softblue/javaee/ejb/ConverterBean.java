package br.com.softblue.javaee.ejb;

import javax.ejb.Stateless;

@Stateless
public class ConverterBean {
	
	private static final double C = 0.62137119;

	public double toKm(double miles) {
		return miles / C;
	}
	
	public double toMiles(double km) {
		return km * C;
	}
}
