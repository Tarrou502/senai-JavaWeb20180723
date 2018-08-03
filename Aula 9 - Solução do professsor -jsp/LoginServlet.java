package br.com.senai.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senai.database.Database;
import br.com.senai.models.Usuario;

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
			throws ServletException {
		try {
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
			dispatcher.forward(request, response);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			Usuario usuario = Database.usuarios.get(email);
			
			if (usuario != null && usuario.getSenha().equals(senha)) {
				request.setAttribute("estaLogado", Boolean.TRUE);
				request.setAttribute("usuario", usuario);
				this.getRequestDispatcherParaResultadoLoginCadastro(request, response);
				
			} else {
				request.setAttribute("estaLogado", Boolean.FALSE);
				this.getRequestDispatcherParaResultadoLoginCadastro(request, response);
			}
			
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
	
	private void getRequestDispatcherParaResultadoLoginCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("operacao", "Login");
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/resultado-login-cadastro.jsp");
		dispatcher.forward(request, response);
		
	}


}
