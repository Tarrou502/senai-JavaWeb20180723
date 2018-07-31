package br.com.senai.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculadoraServlet  extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
		
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer n1 = Integer.parseInt(req.getParameter("n1"));
		Integer n2 = Integer.parseInt(req.getParameter("n2"));
		String op = req.getParameter("operacao");
		
		switch(op) {
		   case "soma": 
			   System.out.println(n1+n2);
			   break;
			default:
				System.out.println("Não foi possivel realizar a operação");
				break;
		
		}
	}
	

}
