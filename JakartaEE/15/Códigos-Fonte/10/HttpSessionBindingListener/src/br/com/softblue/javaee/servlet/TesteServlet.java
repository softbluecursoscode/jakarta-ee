package br.com.softblue.javaee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.softblue.javaee.model.Produto;

@WebServlet("/Teste")
public class TesteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Produto x = new Produto();
		Produto y = new Produto();
		
		HttpSession session = request.getSession();
		session.setAttribute("p1", x);
		session.setAttribute("p2", y);
		
		response.setContentType("text/plain");
		
		try (PrintWriter out = response.getWriter()) {
			out.println("Produto 1: " + x.getNome());
			out.println("Produto 2: " + y.getNome());
		}
	}
}
