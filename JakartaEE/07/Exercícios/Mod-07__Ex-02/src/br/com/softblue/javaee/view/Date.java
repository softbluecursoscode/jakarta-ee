package br.com.softblue.javaee.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Date {
	private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

	private String day;
	private String month;
	private String year;

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String asDateString() {
		return day + "/" + month + "/" + year;
	}
	
	public java.util.Date asDate() throws ParseException {
		return SDF.parse(asDateString());
	}
}
