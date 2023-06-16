package br.com.softblue.javaee.ejb;

import javax.ejb.Stateless;

@Stateless
public class TemperatureConverterBean implements TemperatureConverter {

	@Override
	public double convertCelsiusToFahrenheit(double tc) {
		return 9 * (tc / 5) + 32;
	}

}
