package br.com.softblue.javaee;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Arquivo")
public class ArquivoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/zip");
		response.addHeader("Content-Disposition", "attachment; filename=arquivo.zip");
		
		try (
			FileInputStream in = new FileInputStream("D:/Temp/arquivo.zip");
			OutputStream out = response.getOutputStream()) {
			
			byte[] buffer = new byte[1024];
			int b;
			
			while ((b = in.read(buffer)) > -1) {
				out.write(buffer, 0, b);
			}
		}
	}
}
