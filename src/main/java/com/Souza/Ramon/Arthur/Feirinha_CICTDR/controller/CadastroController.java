package com.Souza.Ramon.Arthur.Feirinha_CICTDR.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CadastroController {

	@RequestMapping("/cadastrar")
	public String cadastro() {
		return "cadastro";
	}
}
