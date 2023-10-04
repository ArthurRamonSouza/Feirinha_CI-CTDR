package com.Souza.Ramon.Arthur.Feirinha_CICTDR.controller;

import java.util.Optional;

import javax.validation.Valid;

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

	@PostMapping("/criar")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public String criarAnuncio(@RequestBody @Valid Anuncio anuncio) {
		Optional<Usuario> anunciante = usuarioService.getUsuarioByMatricula(anuncio.getAnunciante().getMatricula());
		if (anunciante.isPresent()) {
			System.out.println("Anunciante founded.\n");
			// System.out.println(anunciante.get().toString());
			anuncio.setAnunciante(anunciante.get());
			anuncioService.save(anuncio);
			return "Anuncio criado";
		}
		return "Não foi possível criar o anúncio pois o anunciante é inexistente.";
	}

	@GetMapping("/{anuncioId}")
	public String visualizarAnuncio(@PathVariable Long anuncioId) {
		Optional<Anuncio> optionalAnuncio = anuncioService.getAnuncio(anuncioId);
		if (optionalAnuncio.isPresent())
			return optionalAnuncio.get().toString();

		return "Anúncio não encontrado no banco de dados!";
	}

	@PutMapping("/atualizar")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String editarAnuncio(@RequestBody Anuncio anuncioAtualizado) {
		Optional<Anuncio> optionalAnuncio = anuncioService.getAnuncio(anuncioAtualizado.getAnuncioId());
		if (optionalAnuncio.isPresent()) {
			Anuncio anuncioAntigo = optionalAnuncio.get();
			anuncioAntigo.setCategoria(anuncioAtualizado.getCategoria());
			anuncioAntigo.setDescricao(anuncioAtualizado.getDescricao());
			anuncioAntigo.setLocalizacao(anuncioAtualizado.getLocalizacao());
			anuncioAntigo.setPreco(anuncioAtualizado.getPreco());
			anuncioAntigo.setQuantidade(anuncioAtualizado.getQuantidade());
			anuncioAntigo.setTitulo(anuncioAtualizado.getTitulo());
			anuncioAntigo.setUrlImagem(anuncioAtualizado.getUrlImagem());

			anuncioService.save(anuncioAntigo);
			return "Anuncio alterado";
		}

		return "Anúncio não encontrado no banco de dados!";
	}

	@DeleteMapping("/remover/{anuncioId}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String removerAnuncio(@PathVariable Long anuncioId) {
		anuncioService.deleteById(anuncioId);
		return "Anuncio removido!";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/paginaInicial";
	}

}
