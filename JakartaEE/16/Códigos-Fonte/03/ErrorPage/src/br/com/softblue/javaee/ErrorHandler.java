package br.com.softblue.javaee;

import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.RequestMap;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ErrorHandler {

	@Inject
	@RequestMap
	private Map<String, Object> requestMap;
	
	public Integer getStatusCode() {
		return get("javax.servlet.error.status_code", Integer.class);
	}

	public String getMessage() {
		return get("javax.servlet.error.message");
	}

	public String getExceptionClassName() {
		return get("javax.servlet.error.exception", Exception.class).getClass().getName();
	}

	public String getRequestURI() {
		return get("javax.servlet.error.request_uri");
	}

	public String getServletName() {
		return get("javax.servlet.error.servlet_name");
	}
	
	@SuppressWarnings("unchecked")
	private <T> T get(String prop, Class<T> clazz) {
		return (T) requestMap.get(prop);
	}
	
	private String get(String prop) {
		return get(prop, String.class);
	}
}
