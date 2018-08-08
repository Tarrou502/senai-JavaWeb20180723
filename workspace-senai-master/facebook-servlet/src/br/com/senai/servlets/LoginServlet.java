package br.com.senai.servlets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
@WebServlet(urlPatterns = { "/login.html" })
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
		 
		Path caminho = Paths.get(FilesUtils.webInfDir.toString(), "login.html");
		System.out.println(caminho);
    	
		String html = new String(Files.readAllBytes(caminho.toAbsolutePath()));
		System.out.println(html);
		
		response.getWriter().println(html);
	 }
	
	 /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Database.USUARIOS.put("a@a", newUsuario(null,null,"a@a", null, "123", null, null))
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		Usuario usuario = Database.USUARIOS.get(email);
		
		if (usuario != null && usuario.getSenha().equals(senha)) {
			try {
				Path caminho = Paths.get(FilesUtils.webInfDir.toString(), "sucesso-login.html");
				System.out.println(caminho);

				String html = new String(Files.readAllBytes(caminho.toAbsolutePath()));
				System.out.println(html);
				
				Context.isLogged = Boolean.TRUE;
				
				response.getWriter().println(html);
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				Path caminho = Paths.get(FilesUtils.webInfDir.toString(), "falha-login.html");
				System.out.println(caminho);
	
				String html = new String(Files.readAllBytes(caminho.toAbsolutePath()));
				System.out.println(html);
				
				Context.isLogged = Boolean.FALSE;
				
				response.getWriter().println(html);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
