package com.Souza.Ramon.Arthur.Feirinha_CICTDR.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Souza.Ramon.Arthur.Feirinha_CICTDR.model.Anuncio;
import com.Souza.Ramon.Arthur.Feirinha_CICTDR.model.Usuario;
import com.Souza.Ramon.Arthur.Feirinha_CICTDR.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Optional<Usuario> getUsuarioByMatricula(String matricula) {
		return usuarioRepository.findById(matricula);
	}

	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public void deleteByMatricula(String matricula) {
		usuarioRepository.deleteAnunciosByMatricula(matricula);
		usuarioRepository.deleteById(matricula);
	}

	public List<Anuncio> getAnuncios(String anuncianteMatricula) {
		return usuarioRepository.findAllAnunciosByMatricula(anuncianteMatricula);
	}

}
