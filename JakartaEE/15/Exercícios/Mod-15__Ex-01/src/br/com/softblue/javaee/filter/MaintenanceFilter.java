package br.com.softblue.javaee.filter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Filter que checa o arquivo application.properties para verificar se o site est� ou n�o em manuten��o.
 * Esta implementa��o tem fins did�ticos. Numa aplica��o real, ler o arquivo application.properties em todas as requisi��es pode causar
 * perda de performance na aplica��o. O ideal seria ler de tempos em tempos, ou reler o arquivo apenas se alguma modifica��o foi detectada.
 */
@WebFilter("/*")
public class MaintenanceFilter implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		Properties props = null;
		
		//l� o arquivo application.properties, localizado junto com as classes da aplica��o
		try (InputStream is = MaintenanceFilter.class.getResourceAsStream("/br/com/softblue/javaee/application.properties")) {
			//cria o objeto Properties e o popula com base nas propriedades definidas em application.properties
			props = new Properties();
			props.load(is);
		}
		
		//l� a propriedade maintenance
		boolean maintenance = Boolean.valueOf(props.getProperty("maintenance"));
		
		if (!maintenance) {
			//site n�o est� em manuten��o. processar a requisi��o normalmente
			chain.doFilter(request, response);
		
		} else {
			//site em manuten��o. Direcionar o usu�rio para maintenance.xhtml e n�o processar a requisi��o
			request.getRequestDispatcher("maintenance.faces").forward(request, response);
		}
	}

	
	public void init(FilterConfig config) throws ServletException {
		//nada aqui
	}

	public void destroy() {
		//nada aqui
	}
}
