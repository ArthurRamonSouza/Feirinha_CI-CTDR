package com.Souza.Ramon.Arthur.Feirinha_CICTDR.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Souza.Ramon.Arthur.Feirinha_CICTDR.dto.UsuarioDTO;
import com.Souza.Ramon.Arthur.Feirinha_CICTDR.model.Usuario;
import com.Souza.Ramon.Arthur.Feirinha_CICTDR.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public String usuario() {
		return "Bateu aqui!";
	}

	@GetMapping("/perfil/{alunoMatricula}")
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView perfilUsuario(@PathVariable("alunoMatricula") String alunoMatricula) {
//		String matricula = "20210027186";
		if (usuarioService.getUsuario(alunoMatricula).isPresent()) {
			ModelAndView modelAndView = new ModelAndView("perfilUsuario");
			modelAndView.addObject("usuario", usuarioService.getUsuario(alunoMatricula));
			System.out.println("Bateu aqui! " + alunoMatricula);
			return modelAndView;
		}
		
		System.out.println("Bateu aqui! " + alunoMatricula);
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}
	
	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
		return usuario;
	}
	
	@PutMapping("/atualizar")
	@ResponseStatus(HttpStatus.OK)
	public String atualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		return "Usuario atualizado!";
	}
	
	@DeleteMapping("/remover/{alunoMatricula}")
	@ResponseStatus(HttpStatus.OK)
	public String removerUsuario(@PathVariable("alunoMatricula") String alunoMatricula) {
		return "Usuario removido!";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/usuario";
	}
}
