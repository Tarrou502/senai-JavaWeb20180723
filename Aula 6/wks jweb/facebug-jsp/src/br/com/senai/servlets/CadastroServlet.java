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
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastroServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/cadastro.jsp");
        dispatcher.forward(request,response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String senha = request.getParameter("senha");
		String genero = request.getParameter("genero");
		String dataNascimento = request.getParameter("genero");

		
		Usuario usuario = new Usuario(nome, sobrenome, email, telefone, senha, genero, dataNascimento);
		Database.USUARIOS.put(email, usuario);
       this.getRequestDispatcher(request,response);

	}

	private void getRequestDispatcher(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		request.setAttribute("op", "Cadastro");
		
		try {
			RequestDispatcher dispatcher =request.getServletContext().getRequestDispatcher("WEB-INF/msg-cadstro-login.jsp");
			dispatcher.forward(request,response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
