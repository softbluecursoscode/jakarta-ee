package br.com.softblue.javaee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/guest/Welcome")
public class GuestWelcomeServlet extends HttpServlet {
	
	@Inject
	private SecurityContext securityContext;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		response.setCharacterEncoding("ISO-8859-1");
		
		try (PrintWriter out = response.getWriter()) {
			out.print("<html><body><h1>");
			out.print("Bem vindo CONVIDADO, você está autenticado como usuário ");
			out.print(securityContext.getCallerPrincipal().getName());
			out.print("</h1></body></html>");
		}
	}
}
