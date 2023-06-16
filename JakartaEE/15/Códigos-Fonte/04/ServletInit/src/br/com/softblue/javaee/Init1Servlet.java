package br.com.softblue.javaee;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(loadOnStartup = 1)
public class Init1Servlet extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		System.out.println("Servlet 1 inicializado!");
	}
}
