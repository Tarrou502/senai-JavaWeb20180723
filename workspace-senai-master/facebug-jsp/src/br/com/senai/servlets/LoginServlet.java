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
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Database.USUARIOS.put("a@a", newUsuario(null,null,"a@a", null, "123", null,
		// null))

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		Usuario usuario = Database.USUARIOS.get(email);

		if (usuario != null && usuario.getSenha().equals(senha)) {

			Context.isLogged = Boolean.TRUE;
			
			request.setAttribute("logado", Boolean.TRUE);
			
			
			
			if (usuario.getGenero() > 50) {
				request.setAttribute("genero", "F");		
				
			}else {
				request.setAttribute("genero", "M");
			}
			
			this.getRequesDispatcher(request, response);

		}else {
			request.setAttribute("logado", Boolean.FALSE);
			
			this.getRequesDispatcher(request, response);
		}

	}
	
	private void getRequesDispatcher(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("op", "Login");
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/msg-cadastro-login.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
