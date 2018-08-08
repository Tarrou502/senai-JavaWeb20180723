package br.com.senai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/cadastro")
public class CadastroController {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@RequestMapping(method = RequestMethod.GET)
	public String cadastrar() {
		return "/WEB-INF/cadastro";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String cadastrar(Usuario usuario,
			@RequestParam(name = "termos", defaultValue = "false") Boolean usuarioConcordou, Model model) {

		if (usuarioConcordou) {
			Usuario u = new Usuario();
			u.setNome(usuario.getNome());
			u.setSobrenome(usuario.getSobrenome());
			u.setEmail(usuario.getEmail());
			u.setGenero(usuario.getGenero());
			u.setSenha(usuario.getSenha());
			u.setTelefone(usuario.getTelefone());
			u.setDataNascimento(usuario.getDataNascimento());
			
			usuarioDAO.save(u);
			
			model.addAttribute("mensagem", "Cadastro realizado com sucesso!");
			return "/WEB-INF/msg-cadastro-login";
		} else {
			model.addAttribute("mensagem", "Houve um erro em seu cadastro!");
			return "/WEB-INF/msg-cadastro-login";
		}
	}

}
