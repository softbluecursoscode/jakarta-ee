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
 * Filter que checa o arquivo application.properties para verificar se o site está ou não em manutenção.
 * Esta implementação tem fins didáticos. Numa aplicação real, ler o arquivo application.properties em todas as requisições pode causar
 * perda de performance na aplicação. O ideal seria ler de tempos em tempos, ou reler o arquivo apenas se alguma modificação foi detectada.
 */
@WebFilter("/*")
public class MaintenanceFilter implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		Properties props = null;
		
		//lê o arquivo application.properties, localizado junto com as classes da aplicação
		try (InputStream is = MaintenanceFilter.class.getResourceAsStream("/br/com/softblue/javaee/application.properties")) {
			//cria o objeto Properties e o popula com base nas propriedades definidas em application.properties
			props = new Properties();
			props.load(is);
		}
		
		//lê a propriedade maintenance
		boolean maintenance = Boolean.valueOf(props.getProperty("maintenance"));
		
		if (!maintenance) {
			//site não está em manutenção. processar a requisição normalmente
			chain.doFilter(request, response);
		
		} else {
			//site em manutenção. Direcionar o usuário para maintenance.xhtml e não processar a requisição
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
