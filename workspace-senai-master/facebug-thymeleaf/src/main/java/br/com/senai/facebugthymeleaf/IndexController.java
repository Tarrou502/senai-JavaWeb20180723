package br.com.senai.facebugthymeleaf;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping(method = RequestMethod.GET)
	public String main (HttpServletRequest request) {
		
		request.setAttribute("datetime", LocalDateTime.now());
		return "index";
			
				
	}
}
