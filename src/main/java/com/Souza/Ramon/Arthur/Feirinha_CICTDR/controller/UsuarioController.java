package com.Souza.Ramon.Arthur.Feirinha_CICTDR.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Souza.Ramon.Arthur.Feirinha_CICTDR.dto.UsuarioDTO;
import com.Souza.Ramon.Arthur.Feirinha_CICTDR.model.Anuncio;
import com.Souza.Ramon.Arthur.Feirinha_CICTDR.model.Usuario;
import com.Souza.Ramon.Arthur.Feirinha_CICTDR.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@ResponseBody
	@GetMapping("/{alunoMatricula}")
	@ResponseStatus(HttpStatus.OK)
	public String usuario(@PathVariable String alunoMatricula) {
		if (usuarioService.getUsuarioByMatricula(alunoMatricula).isPresent())
			return usuarioService.getUsuarioByMatricula(alunoMatricula).get().toString();
		return "Usuário não encontrado na base de dados!";
	}

	@GetMapping("/{alunoMatricula}/perfil")
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView perfilUsuario(@PathVariable String alunoMatricula) {
		if (usuarioService.getUsuarioByMatricula(alunoMatricula).isPresent()) {
			ModelAndView modelAndView = new ModelAndView("perfilUsuario");
			modelAndView.addObject("usuario", usuarioService.getUsuarioByMatricula(alunoMatricula));
			System.out.println("Bateu aqui! " + alunoMatricula);
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}

	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public String cadastrarUsuario(@RequestBody Usuario usuario) {
		usuarioService.save(usuario);
		return "Usuario criado: " + usuario.toString();
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{alunoMatricula}/atualizar")
	public String atualizarUsuario(@PathVariable String alunoMatricula, @RequestBody UsuarioDTO usuarioDTOAtualizado) {
		Optional<Usuario> optionalUsuario = usuarioService.getUsuarioByMatricula(alunoMatricula);
		if (optionalUsuario.isPresent()) {
			Usuario usuarioParaAtualizar = optionalUsuario.get();
			Usuario usuarioAtualizado = usuarioDTOAtualizado.toUsuario();
			usuarioAtualizado.setNome(usuarioParaAtualizar.getNome());
			usuarioAtualizado.setAnuncios(usuarioParaAtualizar.getAnuncios());
			usuarioAtualizado.setCurso(usuarioParaAtualizar.getCurso());
			usuarioAtualizado.setEmail(usuarioParaAtualizar.getEmail());
			usuarioAtualizado.setEstrelas(usuarioParaAtualizar.getEstrelas());
			usuarioAtualizado.setMatricula(alunoMatricula);
			usuarioService.save(usuarioAtualizado);
			return "Usuario: " + usuarioAtualizado.getApelido() + " atualizado!";
		}
		return "Usuario não foi atualizado pois não foi encontrado!";
	}

	@DeleteMapping("/remover/{alunoMatricula}")
	@ResponseStatus(HttpStatus.OK)
	public String removerUsuario(@PathVariable String alunoMatricula) {
		usuarioService.deleteByMatricula(alunoMatricula);
		return "Usuario com matrícula " + alunoMatricula + " removido!";
	}

	@ResponseBody
	@GetMapping("/{alunoMatricula}/anuncios")
	public ResponseEntity<List<Anuncio>> meusAnuncios(@PathVariable String alunoMatricula) {
		Optional<Usuario> optionalUsuario = usuarioService.getUsuarioByMatricula(alunoMatricula);
		if (optionalUsuario.isPresent()) {
			List<Anuncio> anunciosUsuario = usuarioService.getAnuncios(alunoMatricula);
			return ResponseEntity.ok(anunciosUsuario);
		}
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/usuario";
	}
}
