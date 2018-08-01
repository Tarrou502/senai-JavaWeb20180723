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
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/CadastroServlet")
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
		

		try {
			String nome = request.getParameter("nome");
			String sobrenome = request.getParameter("sobrenome");
			String email = request.getParameter("email");
			String telefone = request.getParameter("telefone");
			String senha = request.getParameter("senha");
			String genero = request.getParameter("genero");
			String dataNascimento = request.getParameter("genero");

			Usuario usuario = new Usuario(nome, sobrenome, email, telefone, senha, genero, dataNascimento);
			Database.USUARIOS.put(email, usuario);

			Path caminho = Paths.get(FilesUtils.webInfDir.toString(), "sucesso-cadastro.html");
			System.out.println(caminho);

			String html = new String(Files.readAllBytes(caminho.toAbsolutePath()));
			System.out.println(html);
			
			Context.isLogged = Boolean.TRUE;
			
			response.getWriter().println(html);
		} catch (Exception e) {
			System.out.println("Erro no cadastro");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
