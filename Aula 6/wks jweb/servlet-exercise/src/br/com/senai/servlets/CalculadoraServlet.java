package br.com.senai.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculadoraServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res)  {
		Integer n1 = null;
		Integer n2 = null;
		String op  = req.getParameter("operacao");
		
	    if (req.getParameter("n1").isEmpty()|| req.getParameter("n2").isEmpty()) {
			// req.getParameter("n1").equals("") || req.getParameter("n2").equals("")
	    	op  = "erro";
	    
	    }	    	   
	    else {
	    	n1 = Integer.parseInt(req.getParameter("n1"));
	    	n2= Integer.parseInt(req.getParameter("n2"));	    	
	    }
	    
	  
		try {
			switch (op) {
			case "soma":
				System.out.println(n1 + n2);
				res.getWriter().println("<p style=\"text-align:center;padding:20px;background-color:steelblue;\">Resultado da soma:" + (n1 + n2)+"</p>");
				break;
			case "sub":
				System.out.println(n1 - n2);
				res.getWriter().println("Resultado da soma:" + (n1 - n2));
				break;
			case "div":
				System.out.println(n1 / n2);
				res.getWriter().println("Resultado da soma:" + (n1 / n2));
				break;
			case "mult":
				System.out.println(n1 * n2);
				res.getWriter().println("Resultado da soma:" + (n1 * n2));
				break;	
			default:
				System.out.println("Não foi possivel realizar a operação");
				res.getWriter().println("Não foi possivel realizar a operação:" );
				break;

			}
			
		}
		catch (ArithmeticException ae) {
            System.out.println("ArithmeticException occured!");
        }

		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
