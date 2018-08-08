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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/cadastro.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		usuario.setNome(request.getParameter("nome"));
		usuario.setSobrenome(request.getParameter("sobrenome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setTelefone(request.getParameter("telefone"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setGenero(request.getParameter("genero"));
		usuario.setDataNascimento(request.getParameter("data-nascimento"));
		
		
		//Database.USUARIOS.put("a@a", newUsuario(null,null,"a@a", null, "123", null, null))
		
		Database.USUARIOS.put(usuario.getEmail(), usuario);
		
		Database.USUARIOS.get(usuario.getEmail());
		
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println(usuario);
		
		this.getRequesDispatcher(request, response);
		
		
	}

	private void getRequesDispatcher(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("op", "Cadastro");
		
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
