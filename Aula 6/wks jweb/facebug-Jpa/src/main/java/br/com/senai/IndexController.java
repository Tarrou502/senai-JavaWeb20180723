package br.com.senai;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping( value = {"/","index"})
public class IndexController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String main(HttpServletRequest request) {
		request.setAttribute("dateTime", LocalDateTime.now());
		return "index";
	}
}
