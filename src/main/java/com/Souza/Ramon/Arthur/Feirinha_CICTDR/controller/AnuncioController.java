package com.Souza.Ramon.Arthur.Feirinha_CICTDR.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/anuncio")
public class AnuncioController {
	
	@GetMapping("/novo")
	public String criarAnuncio() {
		return "criarAnuncio";
	}
	
	@GetMapping("/{anuncioId}")
	public String visualizarAnuncio(@PathVariable("anuncioId") Long anuncioId) {
		return anuncioId.toString();
	}
	

}
