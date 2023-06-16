package br.com.softblue.javaee.ejb;

import javax.ejb.Local;

//@Remote
@Local
public interface TemperatureConverter {

	public double convertCelsiusToFahrenheit(double tc);
}
