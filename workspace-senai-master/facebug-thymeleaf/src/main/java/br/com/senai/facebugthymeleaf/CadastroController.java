package br.com.senai.facebugthymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

	@RequestMapping(method = RequestMethod.GET)
	public String cadastro() {
		return "WEB-INF/cadastro";
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
		public String cadastro(Model model) {
		return "/WEB-INF/msg-cadastro-login";
		
	}
	
	
}
