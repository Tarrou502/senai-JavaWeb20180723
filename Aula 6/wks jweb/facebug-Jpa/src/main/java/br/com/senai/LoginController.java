package br.com.senai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String login() {
		return "/WEB-INF/login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("senha") String senha, Model model) {
        
	 Usuario usuarioRecuperado =usuarioDAO.findById(email).orElse(new Usuario());
     
		
		if (usuarioRecuperado.getEmail().equals(email)  && usuarioRecuperado.getSenha().equals(senha)) {
			
			UsuarioAtivoUtils.usuario = usuarioRecuperado;
			
			model.addAttribute("usuario",usuarioRecuperado);
			return "/WEB-INF/meus-dados";
			
		} else {
			model.addAttribute("mensagem", "Houve um erro durante o login ");
			return "/WEB-INF/msg-cadastro-login";
		}
	}
}
