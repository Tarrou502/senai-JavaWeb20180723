package br.com.senai.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculadoraServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse resp) {

		String op = req.getParameter("operacao");
		Integer result = null;
		
		Integer n1 = Integer.parseInt(req.getParameter("n1"));
		if (n1.equals("")) {
			op = "erro";
			
		}
		
		Integer n2 = Integer.parseInt(req.getParameter("n2"));
		if(n2.equals("")) {
			op = "erro";
			
		}
		try {

			switch (op) {

			case "soma":
				result = n1 + n2;
				System.out.println(result);
				resp.getWriter().println("Resultado: " + result);
				break;

			case "sub":
				result = n1 - n2;
				System.out.println(result);
				resp.getWriter().println("Resultado: " + result);
				break;

			case "div":
				result = n1 / n2;
				System.out.println(result);
				resp.getWriter().println("Resultado: " + result);
				break;

			case "mult":
				result = n1 * n2;
				System.out.println(result);
				resp.getWriter().println("Resultado: " + result);
				break;
			default:
				System.out.println("Digite uma opção valida");
				break;

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
