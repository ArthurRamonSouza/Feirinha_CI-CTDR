package com.Souza.Ramon.Arthur.Feirinha_CICTDR.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EntrarController {
	
	@RequestMapping("/entrar")
	public String entrar() {
		return "entrar";
	}

}
