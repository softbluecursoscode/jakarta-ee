package br.com.softblue.javaee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Gravar")
public class GravarServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String valor = request.getParameter("valor");
		
		HttpSession session = request.getSession();
		session.setAttribute(nome, valor);
		
		response.sendRedirect(request.getContextPath() + "/session.html");
	}

}
