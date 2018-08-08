package br.com.senai.facebugthymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String login() {
		return "/WEB-INF/login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(@RequestParam("email") String usuario, @RequestParam("senha") String senha, Model model) {
		if ("a@a".equals(usuario) && "1".equals(senha)) {
			model.addAttribute("mensagem", "Olá, " + usuario);
			return "/WEB-INF/msg-cadastro-login";	
		} else {
			model.addAttribute("mensagem", "O login não foi permitido para " + usuario);
			return "/WEB-INF/msg-cadastro-login";
		}
	}
}
