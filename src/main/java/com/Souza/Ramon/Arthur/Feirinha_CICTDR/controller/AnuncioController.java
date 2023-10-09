package com.Souza.Ramon.Arthur.Feirinha_CICTDR.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
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

import com.Souza.Ramon.Arthur.Feirinha_CICTDR.dto.AnuncioDTO;
import com.Souza.Ramon.Arthur.Feirinha_CICTDR.model.Anuncio;
import com.Souza.Ramon.Arthur.Feirinha_CICTDR.model.Usuario;
import com.Souza.Ramon.Arthur.Feirinha_CICTDR.service.AnuncioService;
import com.Souza.Ramon.Arthur.Feirinha_CICTDR.service.UsuarioService;

@Controller
@RequestMapping("/anuncio")
public class AnuncioController {

	@Autowired
	private AnuncioService anuncioService;
	@Autowired
	private UsuarioService usuarioService;

	@ResponseBody
	@PostMapping("/criar")
	@ResponseStatus(HttpStatus.CREATED)
	public String criarAnuncio(@RequestBody AnuncioDTO anuncioDto) {
		Optional<Usuario> anunciante = usuarioService.getUsuarioByMatricula(anuncioDto.getMatriculaAnunciante());
		if (anunciante.isPresent()) {
			System.out.println("Anunciante cadastrado.\n");
			Anuncio anuncio = anuncioDto.toAnuncio();
			anuncioService.save(anuncio);
			return "Anuncio criado";
		}
		return "Não foi possível criar o anúncio pois o anunciante é inexistente.";
	}

	@ResponseBody
	@GetMapping("/{anuncioId}")
	public String visualizarAnuncio(@PathVariable Long anuncioId) {
		Optional<Anuncio> optionalAnuncio = anuncioService.getAnuncio(anuncioId);
		if (optionalAnuncio.isPresent())
			return optionalAnuncio.get().toString();
		return "Anúncio não encontrado no banco de dados!";
	}

	@ResponseBody
	@PutMapping("/{anuncioId}/atualizar")
	@ResponseStatus(HttpStatus.OK)
	public String editarAnuncio(@PathVariable Long anuncioId, @RequestBody AnuncioDTO anuncioDTOAtualizado) {
		Optional<Anuncio> optionalAnuncio = anuncioService.getAnuncio(anuncioId);
		if (optionalAnuncio.isPresent()) {
			Anuncio anuncioParaAtualizar = optionalAnuncio.get();
			Anuncio anuncioAtualizado = anuncioDTOAtualizado.toAnuncio();
			anuncioAtualizado.setAnuncioId(anuncioId);
			anuncioAtualizado.setMatriculaAnunciante(anuncioParaAtualizar.getMatriculaAnunciante());
			anuncioService.save(anuncioAtualizado);
			return "Anuncio alterado";
		}
		return "Anúncio não encontrado no banco de dados!";
	}

	@ResponseBody
	@DeleteMapping("/remover/{anuncioId}")
	@ResponseStatus(HttpStatus.OK)
	public String removerAnuncio(@PathVariable Long anuncioId) {
		anuncioService.deleteById(anuncioId);
		return "Anuncio removido!";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/paginaInicial";
	}
}
