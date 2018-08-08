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
import br.com.senai.utils.FilesUtils;

/**
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/cadastro.html")
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
		
		Path caminho = Paths.get(FilesUtils.webInfDir.toString(), "cadastro.html");
		System.out.println(caminho);
    	
		String html = new String(Files.readAllBytes(caminho.toAbsolutePath()));
		System.out.println(html);
		
		response.getWriter().println(html);
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
		
		
		
	}

}
