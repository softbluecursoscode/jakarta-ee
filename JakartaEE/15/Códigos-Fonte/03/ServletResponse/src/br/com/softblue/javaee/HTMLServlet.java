package br.com.softblue.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HTML")
public class HTMLServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		try (PrintWriter out = response.getWriter()) {
			out.print("<html><body>");
			out.print("<h1>Este é um conteúdo HTML</h1>");
			out.print("</body></html>");
		}
	}
}
