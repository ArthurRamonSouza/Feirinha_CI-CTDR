package com.Souza.Ramon.Arthur.Feirinha_CICTDR.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Souza.Ramon.Arthur.Feirinha_CICTDR.model.Usuario;
import com.Souza.Ramon.Arthur.Feirinha_CICTDR.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Optional<Usuario> getUsuario(String matricula) {
		return usuarioRepository.findById(matricula);
	}

	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public void delete(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
}
