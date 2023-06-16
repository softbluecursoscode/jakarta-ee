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

@WebServlet("/admin/Welcome")
public class AdminWelcomeServlet extends HttpServlet {

	@Inject
	private SecurityContext securityContext;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("ISO-8859-1");
		
		try (PrintWriter out = resp.getWriter()) {
			out.print("<html><body><h1>");
			out.print("Administrador, você está logado com o usuário: ");
			out.print(securityContext.getCallerPrincipal().getName());
			out.print("</h1></body></html>");
		}
	}
}
