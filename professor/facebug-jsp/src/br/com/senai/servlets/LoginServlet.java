package br.com.senai.servlets;


import java.io.IOException;

import java.nio.file.Files;

import java.nio.file.Path;

import java.nio.file.Paths;


import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;


import br.com.senai.database.Database;

import br.com.senai.models.Usuario;

import br.com.senai.utils.Context;

import br.com.senai.utils.FilesUtils;


/**
 * Servlet implementation class LoginServlet
 */

@WebServlet(urlPatterns = { "/login" })

public class LoginServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;

	
   /**
	 * @see HttpServlet#HttpServlet()
	 */
	
	
   public LoginServlet() {
		
         super();
		
         // TODO Auto-generated constructor stub
		
				
	
   }
       

	
  /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 response)
	 */
	 
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		  
     RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
	      
     dispatcher.forward(request,response);			
	 
   }
	
	 
  /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 response)
	 */
	
protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
   //	Usuario usuario2 = new Usuario("leo","ng","leo@gmail.com","11 9999-9999","123","30",null);
		
		
   //Database.USUARIOS.put("leo@gmail.com",usuario2);
	
			

		
   String email = request.getParameter("email");
		
   String senha = request.getParameter("senha");

		
   Usuario usuario = Database.USUARIOS.get(email);
		
		
   if (usuario != null && usuario.getSenha().equals(senha)) {
				
				
      this.getRequestDispatcher(request,response,usuario.getGenero(),usuario.getNome(),true);
				

				
		
   } else {
			
       this.getRequestDispatcher(request,response,"","",false);
			
		
   }

	
}
	
	 

		

		

private void getRequestDispatcher(HttpServletRequest request, HttpServletResponse response,String genero,String nome,Boolean logado) {
			
   // TODO Auto-generated method stub
			request.setAttribute("op", "login");
			request.setAttribute("genero", genero);
			request.setAttribute("nome", nome);
			request.setAttribute("logado", logado);
			
			try {
				RequestDispatcher dispatcher =request.getServletContext().getRequestDispatcher("/WEB-INF/msg-cadastro-login.jsp");
				dispatcher.forward(request,response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
