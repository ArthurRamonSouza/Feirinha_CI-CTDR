package com.Souza.Ramon.Arthur.Feirinha_CICTDR.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class PaginaInicialController {
	
	@GetMapping()
	public String paginaInicial(){
		return "Pagina Inicial";
	}

}
